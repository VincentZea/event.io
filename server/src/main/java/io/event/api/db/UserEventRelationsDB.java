package io.event.api.db;

import com.linkedin.restli.common.CompoundKey;
import io.event.api.models.Event;
import io.event.api.models.User;
import io.event.api.models.UserEventRelation;

import java.util.List;

public interface UserEventRelationsDB extends SupplierByKey<CompoundKey, UserEventRelation> {

  UserEventRelation get(CompoundKey key);

  void update(CompoundKey key, UserEventRelation userEventRelation);

  List<User> findRegisteredUsers(Long eventId);

  List<User> findLikedUsers(Long eventId);

  List<User> findSavedUsers(Long eventId);

  List<Event> findRegisteredEvents(Long userId);

  List<Event> findLikedEvents(Long userId);

  List<Event> findSavedEvents(Long userId);
}
