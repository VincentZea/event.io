package io.event.api.resources;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.common.PatchRequest;
import com.linkedin.restli.server.*;
import com.linkedin.restli.server.annotations.Finder;
import com.linkedin.restli.server.annotations.PagingContextParam;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import io.event.api.db.UserEventRelationsDB;
import io.event.api.db.UsersDB;
import io.event.api.models.User;
import io.event.api.validation.UsersValidator;

import javax.inject.Inject;
import java.util.List;

@RestLiCollection(name = "users", namespace = "io.event.api.models", keyName = RestliConstants.USER_KEY)
public class UsersResource extends CollectionResourceTemplate<Long, User> {

  @Inject
  public UsersDB _usersDB;

  @Inject
  public UserEventRelationsDB _userEventRelationsDB;

  @Inject
  public UsersValidator _usersValidator;

  @Override
  public User get(Long userId) {
    try {
      return _usersDB.get(userId);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Finder("findRegisteredUsers")
  public List<User> findRegisteredUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    try {
      return _userEventRelationsDB.findRegisteredUsers(eventId);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Finder("findLikedUsers")
  public List<User> findLikedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    try {
      return _userEventRelationsDB.findLikedUsers(eventId);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Finder("findSavedUsers")
  public List<User> findSavedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    try {
      return _userEventRelationsDB.findSavedUsers(eventId);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public CreateResponse create(User user) {
    try {
      _usersValidator.validate(null, user);
      return new CreateResponse(_usersDB.create(user));
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public UpdateResponse update(Long userId, User user) {
    try {
      _usersValidator.validate(userId, user);
      _usersDB.update(userId, user);
      return new UpdateResponse(HttpStatus.S_202_ACCEPTED);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public UpdateResponse update(Long userId, PatchRequest<User> userPatch) {
    try {
      User patchedUser = _usersValidator.validate(userId, userPatch);
      _usersDB.update(userId, patchedUser);
      return new UpdateResponse(HttpStatus.S_202_ACCEPTED);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }
}
