
package io.event.api.models;

import javax.annotation.Generated;
import com.linkedin.data.schema.EnumDataSchema;
import com.linkedin.data.template.DataTemplateUtil;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/Gender.pdl.")
public enum Gender {

    MALE,
    FEMALE,
    OTHER,
    $UNKNOWN;
    private final static EnumDataSchema SCHEMA = ((EnumDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"enum\",\"name\":\"Gender\",\"namespace\":\"io.event.api.models\",\"symbols\":[\"MALE\",\"FEMALE\",\"OTHER\"]}"));

}
