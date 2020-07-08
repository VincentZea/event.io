package io.event.api.db;

import io.event.api.models.User;

public interface UsersDB {

  User get(long userId);

  long create(User user);

  void update(long userId, User user);
}
