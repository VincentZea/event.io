package io.event.api.validation.beforeafter;

import com.google.inject.Singleton;
import io.event.api.db.UsersDB;
import io.event.api.models.User;
import io.event.api.validation.UsersValidator;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class BeforeAfterUsersValidator extends BeforeAfterValidator<Long, User> implements UsersValidator {

  private static final List<BeforeAfterValidation<User>> USERS_VALIDATIONS = new ArrayList<>();

  @Inject
  public BeforeAfterUsersValidator(UsersDB usersDB) {
    super(usersDB, USERS_VALIDATIONS);
  }
}
