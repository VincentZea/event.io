package io.event.api.db;

import io.event.api.models.Event;

import java.util.List;

public interface EventsDB extends SupplierByKey<Long, Event> {

  Event get(Long eventId);

  long create(Event event);

  void update(Long eventId, Event event);

  List<Event> findOrganizedEvents(Long organizerId);
}
