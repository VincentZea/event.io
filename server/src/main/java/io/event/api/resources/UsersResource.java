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
import io.event.api.impl.UsersMgr;
import io.event.api.models.User;

import javax.inject.Inject;
import java.util.List;

@RestLiCollection(name = "users", namespace = "io.event.api.models", keyName = "userId")
public class UsersResource extends CollectionResourceTemplate<Long, User> {

  @Inject
  public UsersMgr _usersMgr;

  @Override
  public User get(Long key) {
    return new User().setFirstName("Yang").setLastName("Zhao");
  }

  @Finder("findRegisteredUsers")
  public List<User> findRegisteredUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    return null;
  }

  @Finder("findLikedUsers")
  public List<User> findLikedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    return null;
  }

  @Finder("findSavedUsers")
  public List<User> findSavedUsers(
      @PagingContextParam PagingContext context,
      @QueryParam("eventId") Long eventId) {
    return null;
  }

  @Override
  public CreateResponse create(User entity) {
    return super.create(entity);
  }

  @Override
  public UpdateResponse update(Long key, User entity) {
    return super.update(key, entity);
  }

  @Override
  public UpdateResponse update(Long key, PatchRequest<User> patch) {
    return super.update(key, patch);
  }
}
