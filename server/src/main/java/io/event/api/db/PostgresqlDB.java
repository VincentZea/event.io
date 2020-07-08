package io.event.api.db;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
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

  protected static final String SQL_GET_USER = "SELECT " + String.join(", ", USER_TABLE_ALL_COLUMNS) +
      " FROM " + USER_TABLE +
      " WHERE " + USER_TABLE_ID_COLUMN + " = ?";
  protected static final String SQL_CREATE_USER = "INSERT INTO " + USER_TABLE +
      " (" + String.join(", ", USER_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
  protected static final String SQL_UPDATE_USER = "UPDATE " + USER_TABLE +
      " SET (" + String.join(", ", USER_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " = (?, ?, ?, ?, ?, ?, ?, ?, ?)" +
      " WHERE " + USER_TABLE_ID_COLUMN + " = ?";

  protected static final String SQL_GET_EVENT = "SELECT " + String.join(", ", EVENT_TABLE_ALL_COLUMNS) +
      " FROM " + EVENT_TABLE +
      " WHERE " + EVENT_TABLE_ID_COLUMN + " = ?";
  protected static final String SQL_CREATE_EVENT = "INSERT INTO " + EVENT_TABLE +
      " (" + String.join(", ", EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
  protected static final String SQL_UPDATE_EVENT = "UPDATE " + EVENT_TABLE +
      " SET (" + String.join(", ", EVENT_TABLE_ALL_COLUMNS_EXCEPT_ID)  + ")" +
      " = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
      " WHERE " + EVENT_TABLE_ID_COLUMN + " = ?";

  private final String _url;
  private final String _user;
  private final String _password;

  public PostgresqlDB(String url, String user, String password) {
    _url = url;
    _user = user;
    _password = password;
  }

  protected Connection connect() throws SQLException {
    return DriverManager.getConnection(_url, _user, _password);
  }
}
