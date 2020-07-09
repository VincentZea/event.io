package io.event.api.db.postgresql;

import com.google.inject.Singleton;
import com.google.inject.name.Named;
import io.event.api.db.EventsDB;
import io.event.api.models.*;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class PostgresqlEventsDB extends PostgresqlDB implements EventsDB {

  @Inject
  public PostgresqlEventsDB(
      @Named("PostgresqlDBUrl") String url,
      @Named("PostgresqlDBUser") String user,
      @Named("PostgresqlDBPassword") String password) {
    super(url, user, password);
  }

  @Override
  public Event get(Long eventId) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_GET_EVENT)) {

      preparedStatement.setLong(1, eventId);
      ResultSet rs = preparedStatement.executeQuery();
      return rs.next() ? constructEventFromDBQuery(rs) : null;
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
  public void update(Long eventId, Event event) {
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

  @Override
  public List<Event> findOrganizedEvents(Long organizerId) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_FIND_ORGANIZED_EVENTS)) {

      preparedStatement.setLong(1, organizerId);
      ResultSet rs = preparedStatement.executeQuery();
      List<Event> events = new ArrayList<>();
      while (rs.next()) {
        events.add(constructEventFromDBQuery(rs));
      }
      return events;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
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
