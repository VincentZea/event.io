
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
@Generated(value = "com.linkedin.pegasus.generator.JavaCodeUtil", comments = "Rest.li Data Template. Generated from model/src/main/pegasus/io/event/api/models/Location.pdl.")
public class Location
    extends RecordTemplate
{

    private final static Location.Fields _fields = new Location.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"Location\",\"namespace\":\"io.event.api.models\",\"fields\":[{\"name\":\"postalCode\",\"type\":\"int\",\"optional\":true},{\"name\":\"address\",\"type\":\"string\",\"optional\":true},{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"country\",\"type\":\"string\"}]}"));
    private final static RecordDataSchema.Field FIELD_PostalCode = SCHEMA.getField("postalCode");
    private final static RecordDataSchema.Field FIELD_Address = SCHEMA.getField("address");
    private final static RecordDataSchema.Field FIELD_City = SCHEMA.getField("city");
    private final static RecordDataSchema.Field FIELD_State = SCHEMA.getField("state");
    private final static RecordDataSchema.Field FIELD_Country = SCHEMA.getField("country");

    public Location() {
        super(new DataMap(7, 0.75F), SCHEMA);
    }

    public Location(DataMap data) {
        super(data, SCHEMA);
    }

    public static Location.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for postalCode
     * 
     * @see Location.Fields#postalCode
     */
    public boolean hasPostalCode() {
        return contains(FIELD_PostalCode);
    }

    /**
     * Remover for postalCode
     * 
     * @see Location.Fields#postalCode
     */
    public void removePostalCode() {
        remove(FIELD_PostalCode);
    }

    /**
     * Getter for postalCode
     * 
     * @see Location.Fields#postalCode
     */
    public Integer getPostalCode(GetMode mode) {
        return obtainDirect(FIELD_PostalCode, Integer.class, mode);
    }

    /**
     * Getter for postalCode
     * 
     * @return
     *     Optional field. Always check for null.
     * @see Location.Fields#postalCode
     */
    @Nullable
    public Integer getPostalCode() {
        return obtainDirect(FIELD_PostalCode, Integer.class, GetMode.STRICT);
    }

    /**
     * Setter for postalCode
     * 
     * @see Location.Fields#postalCode
     */
    public Location setPostalCode(Integer value, SetMode mode) {
        putDirect(FIELD_PostalCode, Integer.class, Integer.class, value, mode);
        return this;
    }

    /**
     * Setter for postalCode
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Location.Fields#postalCode
     */
    public Location setPostalCode(
        @Nonnull
        Integer value) {
        putDirect(FIELD_PostalCode, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for postalCode
     * 
     * @see Location.Fields#postalCode
     */
    public Location setPostalCode(int value) {
        putDirect(FIELD_PostalCode, Integer.class, Integer.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for address
     * 
     * @see Location.Fields#address
     */
    public boolean hasAddress() {
        return contains(FIELD_Address);
    }

    /**
     * Remover for address
     * 
     * @see Location.Fields#address
     */
    public void removeAddress() {
        remove(FIELD_Address);
    }

    /**
     * Getter for address
     * 
     * @see Location.Fields#address
     */
    public String getAddress(GetMode mode) {
        return obtainDirect(FIELD_Address, String.class, mode);
    }

    /**
     * Getter for address
     * 
     * @return
     *     Optional field. Always check for null.
     * @see Location.Fields#address
     */
    @Nullable
    public String getAddress() {
        return obtainDirect(FIELD_Address, String.class, GetMode.STRICT);
    }

    /**
     * Setter for address
     * 
     * @see Location.Fields#address
     */
    public Location setAddress(String value, SetMode mode) {
        putDirect(FIELD_Address, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for address
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Location.Fields#address
     */
    public Location setAddress(
        @Nonnull
        String value) {
        putDirect(FIELD_Address, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for city
     * 
     * @see Location.Fields#city
     */
    public boolean hasCity() {
        return contains(FIELD_City);
    }

    /**
     * Remover for city
     * 
     * @see Location.Fields#city
     */
    public void removeCity() {
        remove(FIELD_City);
    }

    /**
     * Getter for city
     * 
     * @see Location.Fields#city
     */
    public String getCity(GetMode mode) {
        return obtainDirect(FIELD_City, String.class, mode);
    }

    /**
     * Getter for city
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Location.Fields#city
     */
    @Nonnull
    public String getCity() {
        return obtainDirect(FIELD_City, String.class, GetMode.STRICT);
    }

    /**
     * Setter for city
     * 
     * @see Location.Fields#city
     */
    public Location setCity(String value, SetMode mode) {
        putDirect(FIELD_City, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for city
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Location.Fields#city
     */
    public Location setCity(
        @Nonnull
        String value) {
        putDirect(FIELD_City, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for state
     * 
     * @see Location.Fields#state
     */
    public boolean hasState() {
        return contains(FIELD_State);
    }

    /**
     * Remover for state
     * 
     * @see Location.Fields#state
     */
    public void removeState() {
        remove(FIELD_State);
    }

    /**
     * Getter for state
     * 
     * @see Location.Fields#state
     */
    public String getState(GetMode mode) {
        return obtainDirect(FIELD_State, String.class, mode);
    }

    /**
     * Getter for state
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Location.Fields#state
     */
    @Nonnull
    public String getState() {
        return obtainDirect(FIELD_State, String.class, GetMode.STRICT);
    }

    /**
     * Setter for state
     * 
     * @see Location.Fields#state
     */
    public Location setState(String value, SetMode mode) {
        putDirect(FIELD_State, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for state
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Location.Fields#state
     */
    public Location setState(
        @Nonnull
        String value) {
        putDirect(FIELD_State, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for country
     * 
     * @see Location.Fields#country
     */
    public boolean hasCountry() {
        return contains(FIELD_Country);
    }

    /**
     * Remover for country
     * 
     * @see Location.Fields#country
     */
    public void removeCountry() {
        remove(FIELD_Country);
    }

    /**
     * Getter for country
     * 
     * @see Location.Fields#country
     */
    public String getCountry(GetMode mode) {
        return obtainDirect(FIELD_Country, String.class, mode);
    }

    /**
     * Getter for country
     * 
     * @return
     *     Required field. Could be null for partial record.
     * @see Location.Fields#country
     */
    @Nonnull
    public String getCountry() {
        return obtainDirect(FIELD_Country, String.class, GetMode.STRICT);
    }

    /**
     * Setter for country
     * 
     * @see Location.Fields#country
     */
    public Location setCountry(String value, SetMode mode) {
        putDirect(FIELD_Country, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for country
     * 
     * @param value
     *     Must not be null. For more control, use setters with mode instead.
     * @see Location.Fields#country
     */
    public Location setCountry(
        @Nonnull
        String value) {
        putDirect(FIELD_Country, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    @Override
    public Location clone()
        throws CloneNotSupportedException
    {
        return ((Location) super.clone());
    }

    @Override
    public Location copy()
        throws CloneNotSupportedException
    {
        return ((Location) super.copy());
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

        public PathSpec postalCode() {
            return new PathSpec(getPathComponents(), "postalCode");
        }

        public PathSpec address() {
            return new PathSpec(getPathComponents(), "address");
        }

        public PathSpec city() {
            return new PathSpec(getPathComponents(), "city");
        }

        public PathSpec state() {
            return new PathSpec(getPathComponents(), "state");
        }

        public PathSpec country() {
            return new PathSpec(getPathComponents(), "country");
        }

    }

}
