
package io.event.api.models;

import javax.annotation.Generated;
import com.linkedin.data.schema.TyperefDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.TyperefInfo;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/Event.pdl.")
public class Time
    extends TyperefInfo
{

    private final static TyperefDataSchema SCHEMA = ((TyperefDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"typeref\",\"name\":\"Time\",\"namespace\":\"io.event.api.models\",\"ref\":\"long\"}"));

    public Time() {
        super(SCHEMA);
    }

}
