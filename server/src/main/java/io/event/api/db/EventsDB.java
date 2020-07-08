package io.event.api.db;

import io.event.api.models.Event;

import java.util.List;

public interface EventsDB {

  Event get(long eventId);

  long create(Event event);

  void update(long eventId, Event event);

  List<Event> findOrganizedEvents(long organizerId);
}
