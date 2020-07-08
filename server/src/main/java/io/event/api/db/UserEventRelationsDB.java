package io.event.api.db;

import com.linkedin.restli.common.CompoundKey;
import io.event.api.models.Event;
import io.event.api.models.User;
import io.event.api.models.UserEventRelation;

import java.util.List;

public interface UserEventRelationsDB {

  UserEventRelation get(CompoundKey key);

  void update(CompoundKey key, UserEventRelation userEventRelation);

  List<User> findRegisteredUsers(long eventId);

  List<User> findLikedUsers(long eventId);

  List<User> findSavedUsers(long eventId);

  List<Event> findRegisteredEvents(long userId);

  List<Event> findLikedEvents(long userId);

  List<Event> findSavedEvents(long userId);
}
