package io.event.api.resources;

import com.linkedin.restli.common.PatchRequest;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.PagingContext;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Finder;
import com.linkedin.restli.server.annotations.PagingContextParam;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import io.event.api.impl.EventsMgr;
import io.event.api.models.Event;

import javax.inject.Inject;
import java.util.List;

@RestLiCollection(name = "events", namespace = "io.event.api.models", keyName = "eventId")
public class EventsResource extends CollectionResourceTemplate<Long, Event> {

  @Inject
  public EventsMgr _eventsMgr;

  @Override
  public Event get(Long key) {
    return new Event().setDescription("This is an event.");
  }

  @Finder("findOrganizedEvents")
  public List<Event> findOrganizedEvents(
      @PagingContextParam PagingContext context,
      @QueryParam("userId") Long userId) {
    return null;
  }

  @Finder("findRegisteredEvents")
  public List<Event> findRegisteredEvents(
      @PagingContextParam PagingContext context,
      @QueryParam("userId") Long userId) {
    return null;
  }

  @Finder("findLikedEvents")
  public List<Event> findLikedEvents(
      @PagingContextParam PagingContext context,
      @QueryParam("userId") Long userId) {
    return null;
  }

  @Finder("findSavedEvents")
  public List<Event> findSavedEvents(
      @PagingContextParam PagingContext context,
      @QueryParam("userId") Long userId) {
    return null;
  }

  @Override
  public CreateResponse create(Event entity) {
    return super.create(entity);
  }

  @Override
  public UpdateResponse update(Long key, Event entity) {
    return super.update(key, entity);
  }

  @Override
  public UpdateResponse update(Long key, PatchRequest<Event> patch) {
    return super.update(key, patch);
  }
}
