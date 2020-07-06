
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
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/User.pdl.")
public class User
    extends RecordTemplate
{

    private final static User.Fields _fields = new User.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"io.event.api.models\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"userName\",\"type\":\"string\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"gender\",\"type\":{\"type\":\"enum\",\"name\":\"Gender\",\"symbols\":[\"MALE\",\"FEMALE\",\"OTHER\"]},\"optional\":true},{\"name\":\"email\",\"type\":\"string\",\"optional\":true},{\"name\":\"phoneNumber\",\"type\":\"string\",\"optional\":true},{\"name\":\"description\",\"type\":\"string\",\"optional\":true},{\"name\":\"birthday\",\"type\":{\"type\":\"typeref\",\"name\":\"Time\",\"ref\":\"long\"},\"optional\":true},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"postalCode\",\"type\":\"int\",\"optional\":true},{\"name\":\"address\",\"type\":\"string\",\"optional\":true},{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"country\",\"type\":\"string\"}]}}]}"));
    private final static RecordDataSchema.Field FIELD_Id = SCHEMA.getField("id");
    private final static RecordDataSchema.Field FIELD_UserName = SCHEMA.getField("userName");
    private final static RecordDataSchema.Field FIELD_FirstName = SCHEMA.getField("firstName");
    private final static RecordDataSchema.Field FIELD_LastName = SCHEMA.getField("lastName");
    private final static RecordDataSchema.Field FIELD_Gender = SCHEMA.getField("gender");
    private final static RecordDataSchema.Field FIELD_Email = SCHEMA.getField("email");
    private final static RecordDataSchema.Field FIELD_PhoneNumber = SCHEMA.getField("phoneNumber");
    private final static RecordDataSchema.Field FIELD_Description = SCHEMA.getField("description");
    private final static RecordDataSchema.Field FIELD_Birthday = SCHEMA.getField("birthday");
    private final static RecordDataSchema.Field FIELD_Location = SCHEMA.getField("location");

    public User() {
        super(new DataMap(14, 0.75F), SCHEMA, 2);
    }

    public User(DataMap data) {
        super(data, SCHEMA);
    }

    public static User.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for id
     * 
     * @see User.Fields#id
     */
    public boolean hasId() {
        return contains(FIELD_Id);
    }

    /**
     * Remover for id
     * 
     * @see User.Fields#id
     */
    public void removeId() {
        remove(FIELD_Id);
    }

    /**
     * Getter for id
     * 
     * @see User.Fields#id
     */
    public Long getId(GetMode mode) {
        return obtainDirect(FIELD_Id, Long.class, mode);
    }

    /**
     * Getter for id
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#id
     */
    @Nonnull
    public Long getId() {
        return obtainDirect(FIELD_Id, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for id
     * 
     * @see User.Fields#id
     */
    public User setId(Long value, SetMode mode) {
        putDirect(FIELD_Id, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for id
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#id
     */
    public User setId(
        @Nonnull
        Long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for id
     * 
     * @see User.Fields#id
     */
    public User setId(long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for userName
     * 
     * @see User.Fields#userName
     */
    public boolean hasUserName() {
        return contains(FIELD_UserName);
    }

    /**
     * Remover for userName
     * 
     * @see User.Fields#userName
     */
    public void removeUserName() {
        remove(FIELD_UserName);
    }

    /**
     * Getter for userName
     * 
     * @see User.Fields#userName
     */
    public String getUserName(GetMode mode) {
        return obtainDirect(FIELD_UserName, String.class, mode);
    }

    /**
     * Getter for userName
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#userName
     */
    @Nonnull
    public String getUserName() {
        return obtainDirect(FIELD_UserName, String.class, GetMode.STRICT);
    }

    /**
     * Setter for userName
     * 
     * @see User.Fields#userName
     */
    public User setUserName(String value, SetMode mode) {
        putDirect(FIELD_UserName, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for userName
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#userName
     */
    public User setUserName(
        @Nonnull
        String value) {
        putDirect(FIELD_UserName, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for firstName
     * 
     * @see User.Fields#firstName
     */
    public boolean hasFirstName() {
        return contains(FIELD_FirstName);
    }

    /**
     * Remover for firstName
     * 
     * @see User.Fields#firstName
     */
    public void removeFirstName() {
        remove(FIELD_FirstName);
    }

    /**
     * Getter for firstName
     * 
     * @see User.Fields#firstName
     */
    public String getFirstName(GetMode mode) {
        return obtainDirect(FIELD_FirstName, String.class, mode);
    }

    /**
     * Getter for firstName
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#firstName
     */
    @Nonnull
    public String getFirstName() {
        return obtainDirect(FIELD_FirstName, String.class, GetMode.STRICT);
    }

    /**
     * Setter for firstName
     * 
     * @see User.Fields#firstName
     */
    public User setFirstName(String value, SetMode mode) {
        putDirect(FIELD_FirstName, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for firstName
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#firstName
     */
    public User setFirstName(
        @Nonnull
        String value) {
        putDirect(FIELD_FirstName, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for lastName
     * 
     * @see User.Fields#lastName
     */
    public boolean hasLastName() {
        return contains(FIELD_LastName);
    }

    /**
     * Remover for lastName
     * 
     * @see User.Fields#lastName
     */
    public void removeLastName() {
        remove(FIELD_LastName);
    }

    /**
     * Getter for lastName
     * 
     * @see User.Fields#lastName
     */
    public String getLastName(GetMode mode) {
        return obtainDirect(FIELD_LastName, String.class, mode);
    }

    /**
     * Getter for lastName
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#lastName
     */
    @Nonnull
    public String getLastName() {
        return obtainDirect(FIELD_LastName, String.class, GetMode.STRICT);
    }

    /**
     * Setter for lastName
     * 
     * @see User.Fields#lastName
     */
    public User setLastName(String value, SetMode mode) {
        putDirect(FIELD_LastName, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for lastName
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#lastName
     */
    public User setLastName(
        @Nonnull
        String value) {
        putDirect(FIELD_LastName, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for gender
     * 
     * @see User.Fields#gender
     */
    public boolean hasGender() {
        return contains(FIELD_Gender);
    }

    /**
     * Remover for gender
     * 
     * @see User.Fields#gender
     */
    public void removeGender() {
        remove(FIELD_Gender);
    }

    /**
     * Getter for gender
     * 
     * @see User.Fields#gender
     */
    public Gender getGender(GetMode mode) {
        return obtainDirect(FIELD_Gender, Gender.class, mode);
    }

    /**
     * Getter for gender
     * 
     * @return
     *     Optional field. Always check for null.
     * @see User.Fields#gender
     */
    @Nullable
    public Gender getGender() {
        return obtainDirect(FIELD_Gender, Gender.class, GetMode.STRICT);
    }

    /**
     * Setter for gender
     * 
     * @see User.Fields#gender
     */
    public User setGender(Gender value, SetMode mode) {
        putDirect(FIELD_Gender, Gender.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for gender
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#gender
     */
    public User setGender(
        @Nonnull
        Gender value) {
        putDirect(FIELD_Gender, Gender.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for email
     * 
     * @see User.Fields#email
     */
    public boolean hasEmail() {
        return contains(FIELD_Email);
    }

    /**
     * Remover for email
     * 
     * @see User.Fields#email
     */
    public void removeEmail() {
        remove(FIELD_Email);
    }

    /**
     * Getter for email
     * 
     * @see User.Fields#email
     */
    public String getEmail(GetMode mode) {
        return obtainDirect(FIELD_Email, String.class, mode);
    }

    /**
     * Getter for email
     * 
     * @return
     *     Optional field. Always check for null.
     * @see User.Fields#email
     */
    @Nullable
    public String getEmail() {
        return obtainDirect(FIELD_Email, String.class, GetMode.STRICT);
    }

    /**
     * Setter for email
     * 
     * @see User.Fields#email
     */
    public User setEmail(String value, SetMode mode) {
        putDirect(FIELD_Email, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for email
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#email
     */
    public User setEmail(
        @Nonnull
        String value) {
        putDirect(FIELD_Email, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for phoneNumber
     * 
     * @see User.Fields#phoneNumber
     */
    public boolean hasPhoneNumber() {
        return contains(FIELD_PhoneNumber);
    }

    /**
     * Remover for phoneNumber
     * 
     * @see User.Fields#phoneNumber
     */
    public void removePhoneNumber() {
        remove(FIELD_PhoneNumber);
    }

    /**
     * Getter for phoneNumber
     * 
     * @see User.Fields#phoneNumber
     */
    public String getPhoneNumber(GetMode mode) {
        return obtainDirect(FIELD_PhoneNumber, String.class, mode);
    }

    /**
     * Getter for phoneNumber
     * 
     * @return
     *     Optional field. Always check for null.
     * @see User.Fields#phoneNumber
     */
    @Nullable
    public String getPhoneNumber() {
        return obtainDirect(FIELD_PhoneNumber, String.class, GetMode.STRICT);
    }

    /**
     * Setter for phoneNumber
     * 
     * @see User.Fields#phoneNumber
     */
    public User setPhoneNumber(String value, SetMode mode) {
        putDirect(FIELD_PhoneNumber, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for phoneNumber
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#phoneNumber
     */
    public User setPhoneNumber(
        @Nonnull
        String value) {
        putDirect(FIELD_PhoneNumber, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for description
     * 
     * @see User.Fields#description
     */
    public boolean hasDescription() {
        return contains(FIELD_Description);
    }

    /**
     * Remover for description
     * 
     * @see User.Fields#description
     */
    public void removeDescription() {
        remove(FIELD_Description);
    }

    /**
     * Getter for description
     * 
     * @see User.Fields#description
     */
    public String getDescription(GetMode mode) {
        return obtainDirect(FIELD_Description, String.class, mode);
    }

    /**
     * Getter for description
     * 
     * @return
     *     Optional field. Always check for null.
     * @see User.Fields#description
     */
    @Nullable
    public String getDescription() {
        return obtainDirect(FIELD_Description, String.class, GetMode.STRICT);
    }

    /**
     * Setter for description
     * 
     * @see User.Fields#description
     */
    public User setDescription(String value, SetMode mode) {
        putDirect(FIELD_Description, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for description
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#description
     */
    public User setDescription(
        @Nonnull
        String value) {
        putDirect(FIELD_Description, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for birthday
     * 
     * @see User.Fields#birthday
     */
    public boolean hasBirthday() {
        return contains(FIELD_Birthday);
    }

    /**
     * Remover for birthday
     * 
     * @see User.Fields#birthday
     */
    public void removeBirthday() {
        remove(FIELD_Birthday);
    }

    /**
     * Getter for birthday
     * 
     * @see User.Fields#birthday
     */
    public Long getBirthday(GetMode mode) {
        return obtainDirect(FIELD_Birthday, Long.class, mode);
    }

    /**
     * Getter for birthday
     * 
     * @return
     *     Optional field. Always check for null.
     * @see User.Fields#birthday
     */
    @Nullable
    public Long getBirthday() {
        return obtainDirect(FIELD_Birthday, Long.class, GetMode.STRICT);
    }

    /**
     * Setter for birthday
     * 
     * @see User.Fields#birthday
     */
    public User setBirthday(Long value, SetMode mode) {
        putDirect(FIELD_Birthday, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for birthday
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#birthday
     */
    public User setBirthday(
        @Nonnull
        Long value) {
        putDirect(FIELD_Birthday, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for birthday
     * 
     * @see User.Fields#birthday
     */
    public User setBirthday(long value) {
        putDirect(FIELD_Birthday, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for location
     * 
     * @see User.Fields#location
     */
    public boolean hasLocation() {
        return contains(FIELD_Location);
    }

    /**
     * Remover for location
     * 
     * @see User.Fields#location
     */
    public void removeLocation() {
        remove(FIELD_Location);
    }

    /**
     * Getter for location
     * 
     * @see User.Fields#location
     */
    public Location getLocation(GetMode mode) {
        return obtainWrapped(FIELD_Location, Location.class, mode);
    }

    /**
     * Getter for location
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see User.Fields#location
     */
    @Nonnull
    public Location getLocation() {
        return obtainWrapped(FIELD_Location, Location.class, GetMode.STRICT);
    }

    /**
     * Setter for location
     * 
     * @see User.Fields#location
     */
    public User setLocation(Location value, SetMode mode) {
        putWrapped(FIELD_Location, Location.class, value, mode);
        return this;
    }

    /**
     * Setter for location
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see User.Fields#location
     */
    public User setLocation(
        @Nonnull
        Location value) {
        putWrapped(FIELD_Location, Location.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public User clone()
        throws CloneNotSupportedException
    {
        return ((User) super.clone());
    }

    @Override
    public User copy()
        throws CloneNotSupportedException
    {
        return ((User) super.copy());
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

        public PathSpec userName() {
            return new PathSpec(getPathComponents(), "userName");
        }

        public PathSpec firstName() {
            return new PathSpec(getPathComponents(), "firstName");
        }

        public PathSpec lastName() {
            return new PathSpec(getPathComponents(), "lastName");
        }

        public PathSpec gender() {
            return new PathSpec(getPathComponents(), "gender");
        }

        public PathSpec email() {
            return new PathSpec(getPathComponents(), "email");
        }

        public PathSpec phoneNumber() {
            return new PathSpec(getPathComponents(), "phoneNumber");
        }

        public PathSpec description() {
            return new PathSpec(getPathComponents(), "description");
        }

        public PathSpec birthday() {
            return new PathSpec(getPathComponents(), "birthday");
        }

        public io.event.api.models.Location.Fields location() {
            return new io.event.api.models.Location.Fields(getPathComponents(), "location");
        }

    }

}
