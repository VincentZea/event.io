package io.event.api.validation.beforeafter;

import com.google.inject.Singleton;
import io.event.api.db.EventsDB;
import io.event.api.models.Event;
import io.event.api.validation.EventsValidator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class BeforeAfterEventsValidator extends BeforeAfterValidator<Long, Event> implements EventsValidator {

  private static final List<BeforeAfterValidation<Event>> EVENTS_VALIDATIONS = new ArrayList<>();

  @Inject
  public BeforeAfterEventsValidator(EventsDB eventsDB) {
    super(eventsDB, EVENTS_VALIDATIONS);
  }
}
