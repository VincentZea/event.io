package io.event.api.db;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.linkedin.data.template.SetMode;
import io.event.api.models.Gender;
import io.event.api.models.Location;
import io.event.api.models.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

@Singleton
public class PostgresqlDB extends PostgresqlDBConstants implements UsersDB {

  private final String _url;
  private final String _user;
  private final String _password;

  @Inject
  public PostgresqlDB(
      @Named("PostgresqlDBUrl") String url,
      @Named("PostgresqlDBUser") String user,
      @Named("PostgresqlDBPassword") String password) {
    _url = url;
    _user = user;
    _password = password;
  }

  private Connection connect() throws SQLException {
    return DriverManager.getConnection(_url, _user, _password);
  }

  @Override
  public User get(long userId) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_GET_USER)) {

      preparedStatement.setLong(1, userId);
      ResultSet rs = preparedStatement.executeQuery();
      return constructUserFromDBQuery(rs);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public long create(User user) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
      setDBQueryParametersFromUser(preparedStatement, user);

      preparedStatement.executeUpdate();
      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        return generatedKeys.getLong(USER_TABLE_ID_COLUMN);
      }
      throw new SQLException("Failed to create a new user.");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(long userId, User user) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE_USER, Statement.RETURN_GENERATED_KEYS)) {
      setDBQueryParametersFromUser(preparedStatement, user);
      preparedStatement.setLong(USER_TABLE_ALL_COLUMNS_EXCEPT_ID.size() + 1, userId);

      int affectedRows = preparedStatement.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("User not found.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private User constructUserFromDBQuery(ResultSet rs) throws SQLException {
    User user = null;
    if (rs.next()) {
      user = new User();
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

      String[] locationParts = rs.getString(USER_TABLE_LOCATION_COLUMN).split(USER_TABLE_LOCATION_COLUMN_DELIMITER);
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
    }
    return user;
  }

  private void setDBQueryParametersFromUser(PreparedStatement preparedStatement, User user) throws SQLException {
    // Assume the parameters are listed as USER_TABLE_ALL_COLUMNS_EXCEPT_ID
    int index = 1;
    preparedStatement.setString(index++, user.getUserName());
    preparedStatement.setString(index++, user.getFirstName());
    preparedStatement.setString(index++, user.getLastName());
    preparedStatement.setString(index++,
        Optional.ofNullable(user.getGender()).map(Gender::toString).orElse(null));
    preparedStatement.setString(index++, user.getEmail());
    preparedStatement.setString(index++, user.getPhoneNumber());
    preparedStatement.setString(index++, user.getDescription());
    preparedStatement.setDate(index++, Optional.ofNullable(user.getBirthday()).map(Date::new).orElse(null));

    Location location = user.getLocation();
    StringBuilder locationBuilder = new StringBuilder();
    locationBuilder.append(location.getCountry())
        .append(USER_TABLE_LOCATION_COLUMN_DELIMITER).append(location.getState())
        .append(USER_TABLE_LOCATION_COLUMN_DELIMITER).append(location.getCity());
    if (location.hasAddress()) {
      locationBuilder.append(USER_TABLE_LOCATION_COLUMN_DELIMITER).append(location.getAddress());
    }
    if (location.hasPostalCode()) {
      locationBuilder.append(USER_TABLE_LOCATION_COLUMN_DELIMITER).append(location.getPostalCode());
    }
    preparedStatement.setString(index,locationBuilder.toString());
  }
}
