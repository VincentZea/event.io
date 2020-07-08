package io.event.api.db;

import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.linkedin.data.template.SetMode;
import io.event.api.models.*;

import javax.inject.Inject;
import java.sql.*;

@Singleton
public class PostgresqlEventsDB extends PostgresqlDB implements EventsDB {

  @Inject
  public PostgresqlEventsDB(
      @Named("PostgresqlDBUrl") String url,
      @Named("PostgresqlDBUser") String user,
      @Named("PostgresqlDBPassword") String password) {
    super(url, user, password);
  }

  @Override
  public Event get(long eventId) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_GET_EVENT)) {

      preparedStatement.setLong(1, eventId);
      ResultSet rs = preparedStatement.executeQuery();
      return constructEventFromDBQuery(rs);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public long create(Event event) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE_EVENT, Statement.RETURN_GENERATED_KEYS)) {
      setDBQueryParametersFromEvent(preparedStatement, event);

      preparedStatement.executeUpdate();
      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        return generatedKeys.getLong(EVENT_TABLE_ID_COLUMN);
      }
      throw new SQLException("Failed to create a new event.");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(long eventId, Event event) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE_EVENT, Statement.RETURN_GENERATED_KEYS)) {
      setDBQueryParametersFromEvent(preparedStatement, event);
      preparedStatement.setLong(EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID.size() + 1, eventId);

      int affectedRows = preparedStatement.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Event not found.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Event constructEventFromDBQuery(ResultSet rs) throws SQLException {
    Event event = null;
    if (rs.next()) {
      event = new Event();
      event.setDescription(rs.getString(EVENT_TABLE_DESCRIPTION_COLUMN));
      event.setCategory(rs.getString(EVENT_TABLE_CATEGORY_COLUMN));
      event.setFree(rs.getBoolean(EVENT_TABLE_FREE_COLUMN));
      event.setStatus(EventStatus.valueOf(rs.getString(EVENT_TABLE_STATUS_COLUMN)));
      event.setStartTime(rs.getTimestamp(EVENT_TABLE_START_TIME_COLUMN).getTime());
      event.setEndTime(rs.getTimestamp(EVENT_TABLE_END_TIME_COLUMN).getTime());

      String locationStr = rs.getString(EVENT_TABLE_LOCATION_COLUMN);
      if (locationStr != null) {
        String[] locationParts = locationStr.split(LOCATION_COLUMN_DELIMITER);
        Location location = new Location()
            .setCountry(locationParts[0])
            .setState(locationParts[1])
            .setCity(locationParts[2]);
        if (locationParts.length > 3) {
          location.setAddress(locationParts[3]);
        }
        if (locationParts.length > 4) {
          location.setPostalCode(Integer.valueOf(locationParts[4]));
        }
        event.setLocation(location);
      }

      event.setLink(rs.getString(EVENT_TABLE_LINK_COLUMN), SetMode.REMOVE_OPTIONAL_IF_NULL);
      event.setOrganizerId(rs.getLong(EVENT_TABLE_ORGANIZER_ID_COLUMN));
      event.setCapacity(rs.getInt(EVENT_TABLE_CAPACITY_COLUMN));
    }
    return event;
  }

  private void setDBQueryParametersFromEvent(PreparedStatement preparedStatement, Event event) throws SQLException {
    // Assume the parameters are listed as EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID
    int index = 1;
    preparedStatement.setString(index++, event.getDescription());
    preparedStatement.setString(index++, event.getCategory());
    preparedStatement.setBoolean(index++, event.isFree());
    preparedStatement.setString(index++, event.getStatus().toString());
    preparedStatement.setTimestamp(index++, new Timestamp(event.getStartTime()));
    preparedStatement.setTimestamp(index++, new Timestamp(event.getEndTime()));

    Location location = event.getLocation();
    if (location != null) {
      StringBuilder locationBuilder = new StringBuilder();
      locationBuilder.append(location.getCountry())
          .append(LOCATION_COLUMN_DELIMITER).append(location.getState())
          .append(LOCATION_COLUMN_DELIMITER).append(location.getCity());
      if (location.hasAddress()) {
        locationBuilder.append(LOCATION_COLUMN_DELIMITER).append(location.getAddress());
      }
      if (location.hasPostalCode()) {
        locationBuilder.append(LOCATION_COLUMN_DELIMITER).append(location.getPostalCode());
      }
      preparedStatement.setString(index++, locationBuilder.toString());
    } else {
      preparedStatement.setString(index++, null);
    }

    preparedStatement.setString(index++, event.getLink());
    preparedStatement.setLong(index++, event.getOrganizerId());
    preparedStatement.setInt(index, event.getCapacity());
  }
}
