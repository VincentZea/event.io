package io.event.api.db.postgresql;

import com.google.inject.Singleton;
import com.google.inject.name.Named;
import io.event.api.db.UsersDB;
import io.event.api.models.Gender;
import io.event.api.models.Location;
import io.event.api.models.User;

import javax.inject.Inject;
import java.sql.*;
import java.util.Optional;

@Singleton
public final class PostgresqlUsersDB extends PostgresqlDB implements UsersDB {

  @Inject
  public PostgresqlUsersDB(
      @Named("PostgresqlDBUrl") String url,
      @Named("PostgresqlDBUser") String user,
      @Named("PostgresqlDBPassword") String password) {
    super(url, user, password);
  }

  @Override
  public User get(Long userId) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_GET_USER)) {

      preparedStatement.setLong(1, userId);
      ResultSet rs = preparedStatement.executeQuery();
      return rs.next() ? constructUserFromDBQuery(rs) : null;
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
  public void update(Long userId, User user) {
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
        .append(LOCATION_COLUMN_DELIMITER).append(location.getState())
        .append(LOCATION_COLUMN_DELIMITER).append(location.getCity());
    if (location.hasAddress()) {
      locationBuilder.append(LOCATION_COLUMN_DELIMITER).append(location.getAddress());
    }
    if (location.hasPostalCode()) {
      locationBuilder.append(LOCATION_COLUMN_DELIMITER).append(location.getPostalCode());
    }
    preparedStatement.setString(index, locationBuilder.toString());
  }
}
