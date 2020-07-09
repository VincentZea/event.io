package io.event.api.validation.beforeafter;

import com.linkedin.data.template.RecordTemplate;

public interface BeforeAfterValidation<T extends RecordTemplate> {

  void validate(T before, T after);
}
