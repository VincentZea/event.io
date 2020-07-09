package io.event.api.db;

import io.event.api.models.User;

public interface UsersDB extends SupplierByKey<Long, User> {

  User get(Long userId);

  long create(User user);

  void update(Long userId, User user);
}
