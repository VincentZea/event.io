package io.event.api.resources;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.*;
import com.linkedin.restli.server.annotations.Finder;
import com.linkedin.restli.server.annotations.PagingContextParam;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import io.event.api.db.UsersDB;
import io.event.api.models.User;

import javax.inject.Inject;
import java.util.List;

@RestLiCollection(name = "users", namespace = "io.event.api.models", keyName = "userId")
public class UsersResource extends CollectionResourceTemplate<Long, User> {

  @Inject
  public UsersDB _usersDB;

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
    throw new RoutingException("'findRegisteredUsers' not implemented", 400);
  }

  @Finder("findLikedUsers")
  public List<User> findLikedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    throw new RoutingException("'findLikedUsers' not implemented", 400);
  }

  @Finder("findSavedUsers")
  public List<User> findSavedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    throw new RoutingException("'findSavedUsers' not implemented", 400);
  }

  @Override
  public CreateResponse create(User user) {
    try {
      return new CreateResponse(_usersDB.create(user));
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public UpdateResponse update(Long userId, User user) {
    try {
      _usersDB.update(userId, user);
      return new UpdateResponse(HttpStatus.S_202_ACCEPTED);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }
}
