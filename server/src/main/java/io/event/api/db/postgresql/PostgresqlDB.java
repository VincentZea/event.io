package io.event.api.db.postgresql;

import com.linkedin.data.template.SetMode;
import io.event.api.models.*;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PostgresqlDB {

  protected static final String LOCATION_COLUMN_DELIMITER = ",";
  protected static final String USER_TABLE = "users";
  protected static final String USER_TABLE_ID_COLUMN = "id";
  protected static final String USER_TABLE_USER_NAME_COLUMN = "user_name";
  protected static final String USER_TABLE_FIRST_NAME_COLUMN = "first_name";
  protected static final String USER_TABLE_LAST_NAME_COLUMN = "last_name";
  protected static final String USER_TABLE_GENDER_COLUMN = "gender";
  protected static final String USER_TABLE_EMAIL_COLUMN = "email";
  protected static final String USER_TABLE_PHONE_NUMBER_COLUMN = "phone_number";
  protected static final String USER_TABLE_DESCRIPTION_COLUMN = "description";
  protected static final String USER_TABLE_BIRTHDAY_COLUMN = "birthday";
  protected static final String USER_TABLE_LOCATION_COLUMN = "location";
  protected static final List<String> USER_TABLE_ALL_COLUMNS_EXCEPT_ID = Arrays.asList(
      USER_TABLE_USER_NAME_COLUMN,
      USER_TABLE_FIRST_NAME_COLUMN,
      USER_TABLE_LAST_NAME_COLUMN,
      USER_TABLE_GENDER_COLUMN,
      USER_TABLE_EMAIL_COLUMN,
      USER_TABLE_PHONE_NUMBER_COLUMN,
      USER_TABLE_DESCRIPTION_COLUMN,
      USER_TABLE_BIRTHDAY_COLUMN,
      USER_TABLE_LOCATION_COLUMN
  );
  protected static final List<String> USER_TABLE_ALL_COLUMNS =
      Stream.concat(Stream.of(USER_TABLE_ID_COLUMN), USER_TABLE_ALL_COLUMNS_EXCEPT_ID.stream())
          .collect(Collectors.toList());

  protected static final String EVENT_TABLE = "events";
  protected static final String EVENT_TABLE_ID_COLUMN = "id";
  protected static final String EVENT_TABLE_DESCRIPTION_COLUMN = "description";
  protected static final String EVENT_TABLE_CATEGORY_COLUMN = "category";
  protected static final String EVENT_TABLE_FREE_COLUMN = "free";
  protected static final String EVENT_TABLE_STATUS_COLUMN = "status";
  protected static final String EVENT_TABLE_START_TIME_COLUMN = "start_time";
  protected static final String EVENT_TABLE_END_TIME_COLUMN = "end_time";
  protected static final String EVENT_TABLE_LOCATION_COLUMN = "location";
  protected static final String EVENT_TABLE_LINK_COLUMN = "link";
  protected static final String EVENT_TABLE_ORGANIZER_ID_COLUMN = "organizer_id";
  protected static final String EVENT_TABLE_CAPACITY_COLUMN = "capacity";
  protected static final List<String> EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID = Arrays.asList(
      EVENT_TABLE_DESCRIPTION_COLUMN,
      EVENT_TABLE_CATEGORY_COLUMN,
      EVENT_TABLE_FREE_COLUMN,
      EVENT_TABLE_STATUS_COLUMN,
      EVENT_TABLE_START_TIME_COLUMN,
      EVENT_TABLE_END_TIME_COLUMN,
      EVENT_TABLE_LOCATION_COLUMN,
      EVENT_TABLE_LINK_COLUMN,
      EVENT_TABLE_ORGANIZER_ID_COLUMN,
      EVENT_TABLE_CAPACITY_COLUMN
  );
  protected static final List<String> EVENT_TABLE_ALL_COLUMNS =
      Stream.concat(Stream.of(EVENT_TABLE_ID_COLUMN), EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID.stream())
      .collect(Collectors.toList());

  protected static final String USER_EVENT_RELATION_TABLE = "user_event_relations";
  protected static final String USER_EVENT_RELATION_TABLE_UNIQUE_CONSTRAINT = "user_event_unique_user_and_event";
  protected static final String USER_EVENT_RELATION_TABLE_USER_ID_COLUMN = "user_id";
  protected static final String USER_EVENT_RELATION_TABLE_EVENT_ID_COLUMN = "event_id";
  protected static final String USER_EVENT_RELATION_TABLE_REGISTERED_COLUMN = "registered";
  protected static final String USER_EVENT_RELATION_TABLE_LIKED_COLUMN = "liked";
  protected static final String USER_EVENT_RELATION_TABLE_SAVED_COLUMN = "saved";
  protected static final List<String> USER_EVENT_RELATION_TABLE_ALL_COLUMNS_EXCEPT_IDS = Arrays.asList(
      USER_EVENT_RELATION_TABLE_REGISTERED_COLUMN,
      USER_EVENT_RELATION_TABLE_LIKED_COLUMN,
      USER_EVENT_RELATION_TABLE_SAVED_COLUMN
  );
  protected static final List<String> USER_EVENT_RELATION_TABLE_ALL_COLUMNS =
      Stream.concat(
          Stream.of(USER_EVENT_RELATION_TABLE_USER_ID_COLUMN, USER_EVENT_RELATION_TABLE_EVENT_ID_COLUMN),
          USER_EVENT_RELATION_TABLE_ALL_COLUMNS_EXCEPT_IDS.stream())
      .collect(Collectors.toList());

  protected static final String SQL_GET_USER = "SELECT " + String.join(", ", USER_TABLE_ALL_COLUMNS) +
      " FROM " + USER_TABLE +
      " WHERE " + USER_TABLE_ID_COLUMN + " = ?";
  protected static final String SQL_CREATE_USER = "INSERT INTO " + USER_TABLE +
      " (" + String.join(", ", USER_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  protected static final String SQL_UPDATE_USER = "UPDATE " + USER_TABLE +
      " SET (" + String.join(", ", USER_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " = (?, ?, ?, ?, ?, ?, ?, ?, ?)" +
      " WHERE " + USER_TABLE_ID_COLUMN + " = ?";

  protected static final String SQL_GET_EVENT = "SELECT " + String.join(", ", EVENT_TABLE_ALL_COLUMNS) +
      " FROM " + EVENT_TABLE +
      " WHERE " + EVENT_TABLE_ID_COLUMN + " = ?";
  protected static final String SQL_CREATE_EVENT = "INSERT INTO " + EVENT_TABLE +
      " (" + String.join(", ", EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  protected static final String SQL_UPDATE_EVENT = "UPDATE " + EVENT_TABLE +
      " SET (" + String.join(", ", EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
      " WHERE " + EVENT_TABLE_ID_COLUMN + " = ?";
  protected static final String SQL_FIND_ORGANIZED_EVENTS = "SELECT " + String.join(", ", EVENT_TABLE_ALL_COLUMNS) +
      " FROM " + EVENT_TABLE +
      " WHERE " + EVENT_TABLE_ORGANIZER_ID_COLUMN + " = ?";

  protected static final String SQL_GET_USER_EVENT_RELATION = "SELECT " +
      String.join(", ", USER_EVENT_RELATION_TABLE_ALL_COLUMNS_EXCEPT_IDS) +
      " FROM " + USER_EVENT_RELATION_TABLE +
      " WHERE " + USER_EVENT_RELATION_TABLE_USER_ID_COLUMN + " = ?" +
      " AND " + USER_EVENT_RELATION_TABLE_EVENT_ID_COLUMN + " = ?";
  protected static final String SQL_UPSERT_USER_EVENT_RELATION = "INSERT INTO " + USER_EVENT_RELATION_TABLE +
      " (" + String.join(", ", USER_EVENT_RELATION_TABLE_ALL_COLUMNS)  + ")" +
      " VALUES (?, ?, ?, ?, ?)" +
      " ON CONFLICT ON CONSTRAINT " + USER_EVENT_RELATION_TABLE_UNIQUE_CONSTRAINT +
      " DO UPDATE SET (" + String.join(", ", USER_EVENT_RELATION_TABLE_ALL_COLUMNS_EXCEPT_IDS) + ")" +
      " = (?, ?, ?)";

  protected static final String SQL_FIND_USERS = "SELECT " + String.join(", ", USER_TABLE_ALL_COLUMNS_EXCEPT_ID) +
      " FROM " + USER_EVENT_RELATION_TABLE + " JOIN " + USER_TABLE +
      " ON " + USER_EVENT_RELATION_TABLE + "." + USER_EVENT_RELATION_TABLE_USER_ID_COLUMN +
      " = " + USER_TABLE + "." + USER_TABLE_ID_COLUMN +
      " WHERE " + USER_EVENT_RELATION_TABLE_EVENT_ID_COLUMN + " = ?";
  protected static final String SQL_FIND_REGISTERED_USERS =
      SQL_FIND_USERS + " AND " + USER_EVENT_RELATION_TABLE_REGISTERED_COLUMN + " = true";
  protected static final String SQL_FIND_LIKED_USERS =
      SQL_FIND_USERS + " AND " + USER_EVENT_RELATION_TABLE_LIKED_COLUMN + " = true";
  protected static final String SQL_FIND_SAVED_USERS =
      SQL_FIND_USERS + " AND " + USER_EVENT_RELATION_TABLE_SAVED_COLUMN + " = true";

  protected static final String SQL_FIND_EVENTS = "SELECT " + String.join(", ", EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID) +
      " FROM " + USER_EVENT_RELATION_TABLE + " JOIN " + EVENT_TABLE +
      " ON " + USER_EVENT_RELATION_TABLE + "." + USER_EVENT_RELATION_TABLE_EVENT_ID_COLUMN +
      " = " + EVENT_TABLE + "." + EVENT_TABLE_ID_COLUMN +
      " WHERE " + USER_EVENT_RELATION_TABLE_USER_ID_COLUMN + " = ?";
  protected static final String SQL_FIND_REGISTERED_EVENTS =
      SQL_FIND_EVENTS + " AND " + USER_EVENT_RELATION_TABLE_REGISTERED_COLUMN + " = true";
  protected static final String SQL_FIND_LIKED_EVENTS =
      SQL_FIND_EVENTS + " AND " + USER_EVENT_RELATION_TABLE_LIKED_COLUMN + " = true";
  protected static final String SQL_FIND_SAVED_EVENTS =
      SQL_FIND_EVENTS + " AND " + USER_EVENT_RELATION_TABLE_SAVED_COLUMN + " = true";

  private final String _url;
  private final String _user;
  private final String _password;

  protected PostgresqlDB(String url, String user, String password) {
    _url = url;
    _user = user;
    _password = password;
  }

  protected Connection connect() throws SQLException {
    return DriverManager.getConnection(_url, _user, _password);
  }

  protected User constructUserFromDBQuery(ResultSet rs) throws SQLException {
    User user = new User();
    user.setUserName(rs.getString(USER_TABLE_USER_NAME_COLUMN));
    user.setFirstName(rs.getString(USER_TABLE_FIRST_NAME_COLUMN));
    user.setLastName(rs.getString(USER_TABLE_LAST_NAME_COLUMN));
    user.setGender(Optional.ofNullable(rs.getString(USER_TABLE_GENDER_COLUMN)).map(Gender::valueOf).orElse(null),
        SetMode.REMOVE_OPTIONAL_IF_NULL);
    user.setEmail(rs.getString(USER_TABLE_EMAIL_COLUMN), SetMode.REMOVE_OPTIONAL_IF_NULL);
    user.setPhoneNumber(rs.getString(USER_TABLE_PHONE_NUMBER_COLUMN), SetMode.REMOVE_OPTIONAL_IF_NULL);
    user.setDescription(rs.getString(USER_TABLE_DESCRIPTION_COLUMN), SetMode.REMOVE_OPTIONAL_IF_NULL);
    user.setBirthday(Optional.ofNullable(rs.getDate(USER_TABLE_BIRTHDAY_COLUMN)).map(Date::getTime).orElse(null),
        SetMode.REMOVE_OPTIONAL_IF_NULL);

    String[] locationParts = rs.getString(USER_TABLE_LOCATION_COLUMN).split(LOCATION_COLUMN_DELIMITER);
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
    user.setLocation(location);
    return user;
  }

  protected Event constructEventFromDBQuery(ResultSet rs) throws SQLException {
    Event event = new Event();
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
    return event;
  }
}
