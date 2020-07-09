package io.event.api.validation.beforeafter;

import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.transform.DataProcessingException;
import com.linkedin.restli.common.PatchRequest;
import com.linkedin.restli.server.util.PatchApplier;
import io.event.api.db.SupplierByKey;
import io.event.api.validation.Validator;

import java.util.List;

public abstract class BeforeAfterValidator<K, V extends RecordTemplate> implements Validator<K, V> {

  private final SupplierByKey<K, V> _supplier;
  private final List<BeforeAfterValidation<V>> _validations;

  protected BeforeAfterValidator(SupplierByKey<K, V> supplier, List<BeforeAfterValidation<V>> validations) {
    _supplier = supplier;
    _validations = validations;
  }

  @Override
  public void validate(K key, V after) {
    if (after == null) {
      throw new IllegalArgumentException("Provided entity is null");
    }

    final V before;
    if (key != null) {
      before = _supplier.get(key);
      if (before == null) {
        throw new IllegalArgumentException("Entity not found for key: " + key);
      }
    } else {
      before = null;
    }

    _validations.forEach(validation -> validation.validate(before, after));
  }

  @Override
  public V validate(K key, PatchRequest<V> patch) throws DataProcessingException, CloneNotSupportedException {
    final V before;
    if (key != null) {
      before = _supplier.get(key);
      if (before == null) {
        throw new IllegalArgumentException("Entity not found for key: " + key);
      }
    } else {
      before = null;
    }

    V after = (V) before.clone();
    PatchApplier.applyPatch(after, patch);
    _validations.forEach(validation -> validation.validate(before, after));
    return after;
  }
}
