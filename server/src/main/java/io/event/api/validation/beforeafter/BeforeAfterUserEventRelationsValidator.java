package io.event.api.validation.beforeafter;

import com.google.inject.Singleton;
import com.linkedin.restli.common.CompoundKey;
import io.event.api.db.UserEventRelationsDB;
import io.event.api.models.UserEventRelation;
import io.event.api.validation.UserEventRelationsValidator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class BeforeAfterUserEventRelationsValidator extends BeforeAfterValidator<CompoundKey, UserEventRelation> implements UserEventRelationsValidator {

  private static final List<BeforeAfterValidation<UserEventRelation>> USER_EVENT_RELATIONS_VALIDATIONS = new ArrayList<>();

  @Inject
  public BeforeAfterUserEventRelationsValidator(UserEventRelationsDB userEventRelationsDB) {
    super(userEventRelationsDB, USER_EVENT_RELATIONS_VALIDATIONS);
  }
}
