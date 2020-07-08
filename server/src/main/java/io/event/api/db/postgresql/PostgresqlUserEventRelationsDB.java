package io.event.api.db.postgresql;

import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.linkedin.restli.common.CompoundKey;
import io.event.api.db.UserEventRelationsDB;
import io.event.api.models.Event;
import io.event.api.models.User;
import io.event.api.models.UserEventRelation;
import io.event.api.resources.RestliConstants;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class PostgresqlUserEventRelationsDB extends PostgresqlDB implements UserEventRelationsDB {

  @Inject
  public PostgresqlUserEventRelationsDB(
      @Named("PostgresqlDBUrl") String url,
      @Named("PostgresqlDBUser") String user,
      @Named("PostgresqlDBPassword") String password) {
    super(url, user, password);
  }

  @Override
  public UserEventRelation get(CompoundKey key) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_GET_USER_EVENT_RELATION)) {

      preparedStatement.setLong(1, key.getPartAsLong(RestliConstants.USER_KEY));
      preparedStatement.setLong(2, key.getPartAsLong(RestliConstants.EVENT_KEY));
      ResultSet rs = preparedStatement.executeQuery();
      return constructUserEventRelationFromDBQuery(rs);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(CompoundKey key, UserEventRelation userEventRelation) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPSERT_USER_EVENT_RELATION)) {
      setDBQueryParametersFromUserEventRelation(preparedStatement, key, userEventRelation);

      int affectedRows = preparedStatement.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Failed to update the user event relation.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<User> findRegisteredUsers(long eventId) {
    return findUsers(eventId, SQL_FIND_REGISTERED_USERS);
  }

  @Override
  public List<User> findLikedUsers(long eventId) {
    return findUsers(eventId, SQL_FIND_LIKED_USERS);
  }

  @Override
  public List<User> findSavedUsers(long eventId) {
    return findUsers(eventId, SQL_FIND_SAVED_USERS);
  }

  private List<User> findUsers(long eventId, String sqlQuery) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

      preparedStatement.setLong(1, eventId);
      ResultSet rs = preparedStatement.executeQuery();
      List<User> users = new ArrayList<>();
      while (rs.next()) {
        users.add(constructUserFromDBQuery(rs));
      }
      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Event> findRegisteredEvents(long userId) {
    return findEvents(userId, SQL_FIND_REGISTERED_EVENTS);
  }

  @Override
  public List<Event> findLikedEvents(long userId) {
    return findEvents(userId, SQL_FIND_LIKED_EVENTS);
  }

  @Override
  public List<Event> findSavedEvents(long userId) {
    return findEvents(userId, SQL_FIND_SAVED_EVENTS);
  }

  private List<Event> findEvents(long userId, String sqlQuery) {
    try (Connection conn = connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {

      preparedStatement.setLong(1, userId);
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

  private UserEventRelation constructUserEventRelationFromDBQuery(ResultSet rs) throws SQLException {
    UserEventRelation userEventRelation = null;
    if (rs.next()) {
      userEventRelation = new UserEventRelation();
      userEventRelation.setRegistered(rs.getBoolean(USER_EVENT_RELATION_TABLE_REGISTERED_COLUMN));
      userEventRelation.setLiked(rs.getBoolean(USER_EVENT_RELATION_TABLE_LIKED_COLUMN));
      userEventRelation.setSaved(rs.getBoolean(USER_EVENT_RELATION_TABLE_SAVED_COLUMN));
    }
    return userEventRelation;
  }

  private void setDBQueryParametersFromUserEventRelation(
      PreparedStatement preparedStatement, CompoundKey key, UserEventRelation userEventRelation) throws SQLException {
    int index = 1;
    preparedStatement.setLong(index++, key.getPartAsLong(RestliConstants.USER_KEY));
    preparedStatement.setLong(index++, key.getPartAsLong(RestliConstants.EVENT_KEY));
    preparedStatement.setBoolean(index++, userEventRelation.isRegistered());
    preparedStatement.setBoolean(index++, userEventRelation.isLiked());
    preparedStatement.setBoolean(index++, userEventRelation.isSaved());
    preparedStatement.setBoolean(index++, userEventRelation.isRegistered());
    preparedStatement.setBoolean(index++, userEventRelation.isLiked());
    preparedStatement.setBoolean(index, userEventRelation.isSaved());
  }
}
