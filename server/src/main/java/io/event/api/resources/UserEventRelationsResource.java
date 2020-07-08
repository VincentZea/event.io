package io.event.api.resources;

import com.linkedin.restli.common.CompoundKey;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Key;
import com.linkedin.restli.server.annotations.RestLiAssociation;
import com.linkedin.restli.server.resources.AssociationResourceTemplate;
import io.event.api.db.UserEventRelationsDB;
import io.event.api.models.UserEventRelation;

import javax.inject.Inject;

@RestLiAssociation(name = "userEventRelations", namespace = "io.event.api.models",
    assocKeys = {
        @Key(name = RestliConstants.USER_KEY, type = Long.class),
        @Key(name = RestliConstants.EVENT_KEY, type = Long.class)
    }
)
public class UserEventRelationsResource extends AssociationResourceTemplate<UserEventRelation> {

  @Inject
  public UserEventRelationsDB _userEventRelationsDB;

  @Override
  public UserEventRelation get(CompoundKey key) {
    try {
      UserEventRelation userEventRelation = _userEventRelationsDB.get(key);
      return userEventRelation != null ? userEventRelation : new UserEventRelation();
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }

  @Override
  public UpdateResponse update(CompoundKey key, UserEventRelation userEventRelation) {
    try {
      _userEventRelationsDB.update(key, userEventRelation);
      return new UpdateResponse(HttpStatus.S_202_ACCEPTED);
    } catch (Exception e) {
      throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR, e);
    }
  }
}
