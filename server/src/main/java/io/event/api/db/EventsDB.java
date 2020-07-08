package io.event.api.db;

import io.event.api.models.Event;

public interface EventsDB {

  Event get(long eventId);

  long create(Event event);

  void update(long eventId, Event event);
}
