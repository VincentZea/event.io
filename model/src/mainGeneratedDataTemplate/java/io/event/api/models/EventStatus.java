
package io.event.api.models;

import javax.annotation.Generated;
import com.linkedin.data.schema.EnumDataSchema;
import com.linkedin.data.template.DataTemplateUtil;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/EventStatus.pdl.")
public enum EventStatus {

    ACTIVE,
    CANCELED,
    COMPLETED,
    $UNKNOWN;
    private final static EnumDataSchema SCHEMA = ((EnumDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"enum\",\"name\":\"EventStatus\",\"namespace\":\"io.event.api.models\",\"symbols\":[\"ACTIVE\",\"CANCELED\",\"COMPLETED\"]}"));

}
