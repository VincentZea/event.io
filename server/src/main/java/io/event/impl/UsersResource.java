package io.event.impl;

import com.linkedin.restli.common.PatchRequest;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import io.event.models.User;

@RestLiCollection(name = "users", namespace = "io.event.models", keyName = "userId")
public class UsersResource extends CollectionResourceTemplate<Long, User> {

  @Override
  public User get(Long key) {
    return new User().setFirstName("Yang").setLastName("Zhao");
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
