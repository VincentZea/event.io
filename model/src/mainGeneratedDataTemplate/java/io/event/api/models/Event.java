
package io.event.api.models;

import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * 
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/Event.pdl.")
public class Event
    extends RecordTemplate
{

    private final static Event.Fields _fields = new Event.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"Event\",\"namespace\":\"io.event.api.models\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"isFree\",\"type\":\"boolean\"},{\"name\":\"status\",\"type\":{\"type\":\"enum\",\"name\":\"EventStatus\",\"symbols\":[\"ACTIVE\",\"CANCELED\",\"COMPLETED\"]}},{\"name\":\"startTime\",\"type\":{\"type\":\"typeref\",\"name\":\"Time\",\"ref\":\"long\"}},{\"name\":\"endTime\",\"type\":\"Time\"},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"postalCode\",\"type\":\"int\",\"optional\":true},{\"name\":\"address\",\"type\":\"string\",\"optional\":true},{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"country\",\"type\":\"string\"}]},\"optional\":true},{\"name\":\"link\",\"type\":\"string\",\"optional\":true},{\"name\":\"organizerId\",\"type\":\"long\"},{\"name\":\"capacity\",\"type\":\"int\"}]}"));
    private final static RecordDataSchema.Field FIELD_Id = SCHEMA.getField("id");
    private final static RecordDataSchema.Field FIELD_Description = SCHEMA.getField("description");
    private final static RecordDataSchema.Field FIELD_Category = SCHEMA.getField("category");
    private final static RecordDataSchema.Field FIELD_IsFree = SCHEMA.getField("isFree");
    private final static RecordDataSchema.Field FIELD_Status = SCHEMA.getField("status");
    private final static RecordDataSchema.Field FIELD_StartTime = SCHEMA.getField("startTime");
    private final static RecordDataSchema.Field FIELD_EndTime = SCHEMA.getField("endTime");
    private final static RecordDataSchema.Field FIELD_Location = SCHEMA.getField("location");
    private final static RecordDataSchema.Field FIELD_Link = SCHEMA.getField("link");
    private final static RecordDataSchema.Field FIELD_OrganizerId = SCHEMA.getField("organizerId");
    private final static RecordDataSchema.Field FIELD_Capacity = SCHEMA.getField("capacity");

    public Event() {
        super(new DataMap(15, 0.75F), SCHEMA, 2);
    }

    public Event(DataMap data) {
        super(data, SCHEMA);
    }

    public static Event.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for id
     * 
     * @see Event.Fields#id
     */
    public boolean hasId() {
        return contains(FIELD_Id);
    }

    /**
     * Remover for id
     * 
     * @see Event.Fields#id
     */
    public void removeId() {
        remove(FIELD_Id);
    }

    /**
     * Getter for id
     * 
     * @see Event.Fields#id
     */
    public Long getId(GetMode mode) {
        return obtainDirect(FIELD_Id, Long.class, mode);
    }

    /**
     * Getter for id
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#id
     */
    @Nonnull
    public Long getId() {
        return obtainDirect(FIELD_Id, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for id
     * 
     * @see Event.Fields#id
     */
    public Event setId(Long value, SetMode mode) {
        putDirect(FIELD_Id, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for id
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#id
     */
    public Event setId(
        @Nonnull
        Long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for id
     * 
     * @see Event.Fields#id
     */
    public Event setId(long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for description
     * 
     * @see Event.Fields#description
     */
    public boolean hasDescription() {
        return contains(FIELD_Description);
    }

    /**
     * Remover for description
     * 
     * @see Event.Fields#description
     */
    public void removeDescription() {
        remove(FIELD_Description);
    }

    /**
     * Getter for description
     * 
     * @see Event.Fields#description
     */
    public String getDescription(GetMode mode) {
        return obtainDirect(FIELD_Description, String.class, mode);
    }

    /**
     * Getter for description
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#description
     */
    @Nonnull
    public String getDescription() {
        return obtainDirect(FIELD_Description, String.class, GetMode.STRICT);
    }

    /**
     * Setter for description
     * 
     * @see Event.Fields#description
     */
    public Event setDescription(String value, SetMode mode) {
        putDirect(FIELD_Description, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for description
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#description
     */
    public Event setDescription(
        @Nonnull
        String value) {
        putDirect(FIELD_Description, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for category
     * 
     * @see Event.Fields#category
     */
    public boolean hasCategory() {
        return contains(FIELD_Category);
    }

    /**
     * Remover for category
     * 
     * @see Event.Fields#category
     */
    public void removeCategory() {
        remove(FIELD_Category);
    }

    /**
     * Getter for category
     * 
     * @see Event.Fields#category
     */
    public String getCategory(GetMode mode) {
        return obtainDirect(FIELD_Category, String.class, mode);
    }

    /**
     * Getter for category
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#category
     */
    @Nonnull
    public String getCategory() {
        return obtainDirect(FIELD_Category, String.class, GetMode.STRICT);
    }

    /**
     * Setter for category
     * 
     * @see Event.Fields#category
     */
    public Event setCategory(String value, SetMode mode) {
        putDirect(FIELD_Category, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for category
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#category
     */
    public Event setCategory(
        @Nonnull
        String value) {
        putDirect(FIELD_Category, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for isFree
     * 
     * @see Event.Fields#isFree
     */
    public boolean hasIsFree() {
        return contains(FIELD_IsFree);
    }

    /**
     * Remover for isFree
     * 
     * @see Event.Fields#isFree
     */
    public void removeIsFree() {
        remove(FIELD_IsFree);
    }

    /**
     * Getter for isFree
     * 
     * @see Event.Fields#isFree
     */
    public Boolean isIsFree(GetMode mode) {
        return obtainDirect(FIELD_IsFree, Boolean.class, mode);
    }

    /**
     * Getter for isFree
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#isFree
     */
    @Nonnull
    public Boolean isIsFree() {
        return obtainDirect(FIELD_IsFree, Boolean.class, GetMode.STRICT);
    }

    /**
     * Setter for isFree
     * 
     * @see Event.Fields#isFree
     */
    public Event setIsFree(Boolean value, SetMode mode) {
        putDirect(FIELD_IsFree, Boolean.class, Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for isFree
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#isFree
     */
    public Event setIsFree(
        @Nonnull
        Boolean value) {
        putDirect(FIELD_IsFree, Boolean.class, Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for isFree
     * 
     * @see Event.Fields#isFree
     */
    public Event setIsFree(boolean value) {
        putDirect(FIELD_IsFree, Boolean.class, Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for status
     * 
     * @see Event.Fields#status
     */
    public boolean hasStatus() {
        return contains(FIELD_Status);
    }

    /**
     * Remover for status
     * 
     * @see Event.Fields#status
     */
    public void removeStatus() {
        remove(FIELD_Status);
    }

    /**
     * Getter for status
     * 
     * @see Event.Fields#status
     */
    public EventStatus getStatus(GetMode mode) {
        return obtainDirect(FIELD_Status, EventStatus.class, mode);
    }

    /**
     * Getter for status
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#status
     */
    @Nonnull
    public EventStatus getStatus() {
        return obtainDirect(FIELD_Status, EventStatus.class, GetMode.STRICT);
    }

    /**
     * Setter for status
     * 
     * @see Event.Fields#status
     */
    public Event setStatus(EventStatus value, SetMode mode) {
        putDirect(FIELD_Status, EventStatus.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for status
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#status
     */
    public Event setStatus(
        @Nonnull
        EventStatus value) {
        putDirect(FIELD_Status, EventStatus.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for startTime
     * 
     * @see Event.Fields#startTime
     */
    public boolean hasStartTime() {
        return contains(FIELD_StartTime);
    }

    /**
     * Remover for startTime
     * 
     * @see Event.Fields#startTime
     */
    public void removeStartTime() {
        remove(FIELD_StartTime);
    }

    /**
     * Getter for startTime
     * 
     * @see Event.Fields#startTime
     */
    public Long getStartTime(GetMode mode) {
        return obtainDirect(FIELD_StartTime, Long.class, mode);
    }

    /**
     * Getter for startTime
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#startTime
     */
    @Nonnull
    public Long getStartTime() {
        return obtainDirect(FIELD_StartTime, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for startTime
     * 
     * @see Event.Fields#startTime
     */
    public Event setStartTime(Long value, SetMode mode) {
        putDirect(FIELD_StartTime, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for startTime
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#startTime
     */
    public Event setStartTime(
        @Nonnull
        Long value) {
        putDirect(FIELD_StartTime, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for startTime
     * 
     * @see Event.Fields#startTime
     */
    public Event setStartTime(long value) {
        putDirect(FIELD_StartTime, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for endTime
     * 
     * @see Event.Fields#endTime
     */
    public boolean hasEndTime() {
        return contains(FIELD_EndTime);
    }

    /**
     * Remover for endTime
     * 
     * @see Event.Fields#endTime
     */
    public void removeEndTime() {
        remove(FIELD_EndTime);
    }

    /**
     * Getter for endTime
     * 
     * @see Event.Fields#endTime
     */
    public Long getEndTime(GetMode mode) {
        return obtainDirect(FIELD_EndTime, Long.class, mode);
    }

    /**
     * Getter for endTime
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#endTime
     */
    @Nonnull
    public Long getEndTime() {
        return obtainDirect(FIELD_EndTime, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for endTime
     * 
     * @see Event.Fields#endTime
     */
    public Event setEndTime(Long value, SetMode mode) {
        putDirect(FIELD_EndTime, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for endTime
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#endTime
     */
    public Event setEndTime(
        @Nonnull
        Long value) {
        putDirect(FIELD_EndTime, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for endTime
     * 
     * @see Event.Fields#endTime
     */
    public Event setEndTime(long value) {
        putDirect(FIELD_EndTime, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for location
     * 
     * @see Event.Fields#location
     */
    public boolean hasLocation() {
        return contains(FIELD_Location);
    }

    /**
     * Remover for location
     * 
     * @see Event.Fields#location
     */
    public void removeLocation() {
        remove(FIELD_Location);
    }

    /**
     * Getter for location
     * 
     * @see Event.Fields#location
     */
    public Location getLocation(GetMode mode) {
        return obtainWrapped(FIELD_Location, Location.class, mode);
    }

    /**
     * Getter for location
     * 
     * @return
     *     Optional field. Always check for null.
     * @see Event.Fields#location
     */
    @Nullable
    public Location getLocation() {
        return obtainWrapped(FIELD_Location, Location.class, GetMode.STRICT);
    }

    /**
     * Setter for location
     * 
     * @see Event.Fields#location
     */
    public Event setLocation(Location value, SetMode mode) {
        putWrapped(FIELD_Location, Location.class, value, mode);
        return this;
    }

    /**
     * Setter for location
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#location
     */
    public Event setLocation(
        @Nonnull
        Location value) {
        putWrapped(FIELD_Location, Location.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for link
     * 
     * @see Event.Fields#link
     */
    public boolean hasLink() {
        return contains(FIELD_Link);
    }

    /**
     * Remover for link
     * 
     * @see Event.Fields#link
     */
    public void removeLink() {
        remove(FIELD_Link);
    }

    /**
     * Getter for link
     * 
     * @see Event.Fields#link
     */
    public String getLink(GetMode mode) {
        return obtainDirect(FIELD_Link, String.class, mode);
    }

    /**
     * Getter for link
     * 
     * @return
     *     Optional field. Always check for null.
     * @see Event.Fields#link
     */
    @Nullable
    public String getLink() {
        return obtainDirect(FIELD_Link, String.class, GetMode.STRICT);
    }

    /**
     * Setter for link
     * 
     * @see Event.Fields#link
     */
    public Event setLink(String value, SetMode mode) {
        putDirect(FIELD_Link, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for link
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#link
     */
    public Event setLink(
        @Nonnull
        String value) {
        putDirect(FIELD_Link, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for organizerId
     * 
     * @see Event.Fields#organizerId
     */
    public boolean hasOrganizerId() {
        return contains(FIELD_OrganizerId);
    }

    /**
     * Remover for organizerId
     * 
     * @see Event.Fields#organizerId
     */
    public void removeOrganizerId() {
        remove(FIELD_OrganizerId);
    }

    /**
     * Getter for organizerId
     * 
     * @see Event.Fields#organizerId
     */
    public Long getOrganizerId(GetMode mode) {
        return obtainDirect(FIELD_OrganizerId, Long.class, mode);
    }

    /**
     * Getter for organizerId
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#organizerId
     */
    @Nonnull
    public Long getOrganizerId() {
        return obtainDirect(FIELD_OrganizerId, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for organizerId
     * 
     * @see Event.Fields#organizerId
     */
    public Event setOrganizerId(Long value, SetMode mode) {
        putDirect(FIELD_OrganizerId, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for organizerId
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#organizerId
     */
    public Event setOrganizerId(
        @Nonnull
        Long value) {
        putDirect(FIELD_OrganizerId, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for organizerId
     * 
     * @see Event.Fields#organizerId
     */
    public Event setOrganizerId(long value) {
        putDirect(FIELD_OrganizerId, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for capacity
     * 
     * @see Event.Fields#capacity
     */
    public boolean hasCapacity() {
        return contains(FIELD_Capacity);
    }

    /**
     * Remover for capacity
     * 
     * @see Event.Fields#capacity
     */
    public void removeCapacity() {
        remove(FIELD_Capacity);
    }

    /**
     * Getter for capacity
     * 
     * @see Event.Fields#capacity
     */
    public Integer getCapacity(GetMode mode) {
        return obtainDirect(FIELD_Capacity, Integer.class, mode);
    }

    /**
     * Getter for capacity
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Event.Fields#capacity
     */
    @Nonnull
    public Integer getCapacity() {
        return obtainDirect(FIELD_Capacity, Integer.class, GetMode.STRICT);
    }

    /**
     * Setter for capacity
     * 
     * @see Event.Fields#capacity
     */
    public Event setCapacity(Integer value, SetMode mode) {
        putDirect(FIELD_Capacity, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for capacity
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Event.Fields#capacity
     */
    public Event setCapacity(
        @Nonnull
        Integer value) {
        putDirect(FIELD_Capacity, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for capacity
     * 
     * @see Event.Fields#capacity
     */
    public Event setCapacity(int value) {
        putDirect(FIELD_Capacity, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public Event clone()
        throws CloneNotSupportedException
    {
        return ((Event) super.clone());
    }

    @Override
    public Event copy()
        throws CloneNotSupportedException
    {
        return ((Event) super.copy());
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<String> path, String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        public PathSpec id() {
            return new PathSpec(getPathComponents(), "id");
        }

        public PathSpec description() {
            return new PathSpec(getPathComponents(), "description");
        }

        public PathSpec category() {
            return new PathSpec(getPathComponents(), "category");
        }

        public PathSpec isFree() {
            return new PathSpec(getPathComponents(), "isFree");
        }

        public PathSpec status() {
            return new PathSpec(getPathComponents(), "status");
        }

        public PathSpec startTime() {
            return new PathSpec(getPathComponents(), "startTime");
        }

        public PathSpec endTime() {
            return new PathSpec(getPathComponents(), "endTime");
        }

        public io.event.api.models.Location.Fields location() {
            return new io.event.api.models.Location.Fields(getPathComponents(), "location");
        }

        public PathSpec link() {
            return new PathSpec(getPathComponents(), "link");
        }

        public PathSpec organizerId() {
            return new PathSpec(getPathComponents(), "organizerId");
        }

        public PathSpec capacity() {
            return new PathSpec(getPathComponents(), "capacity");
        }

    }

}
