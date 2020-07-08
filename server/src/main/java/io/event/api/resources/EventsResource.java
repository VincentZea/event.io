package io.event.api.resources;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.PagingContext;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Finder;
import com.linkedin.restli.server.annotations.PagingContextParam;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import io.event.api.db.EventsDB;
import io.event.api.models.Event;

import javax.inject.Inject;
import java.util.List;

@RestLiCollection(name = "events", namespace = "io.event.api.models", keyName = "eventId")
public class EventsResource extends CollectionResourceTemplate<Long, Event> {

  @Inject
  public EventsDB _eventsDB;

  @Override
  public Event get(Long eventId) {
    try {
      return _eventsDB.get(eventId);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
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
  public CreateResponse create(Event event) {
    try {
      return new CreateResponse(_eventsDB.create(event));
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public UpdateResponse update(Long eventId, Event event) {
    try {
      _eventsDB.update(eventId, event);
      return new UpdateResponse(HttpStatus.S_202_ACCEPTED);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }
}
