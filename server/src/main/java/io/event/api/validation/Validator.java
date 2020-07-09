package io.event.api.validation;

import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.transform.DataProcessingException;
import com.linkedin.restli.common.PatchRequest;

public interface Validator<K, V extends RecordTemplate> {

  void validate(K key, V value);

  V validate(K key, PatchRequest<V> patch) throws DataProcessingException, CloneNotSupportedException;
}
