package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class DriverDAO {

    // Driver Table name
    public static final String TABLE_DRIVER = "driver";

    // Driver Table Columns names
    public static final String KEY_ID = "driver_id";
    public static final String KEY_NAME = "driver_name";
    public static final String KEY_FAMILY = "driver_family";
    public static final String KEY_PHONE = "driver_phone";
    public static final String KEY_ADDRESS = "driver_address";
    public static final String KEY_NATIONAL_CODE = "driver_national_code";
    public static final String KEY_CAR_TYPE = "driver_car_type";

    public static final String CREATE_DRIVER_TABLE = "CREATE TABLE "
            + TABLE_DRIVER
            + " ("
            + KEY_ID
            + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE,"
            + KEY_NAME
            + "  VARCHAR(50),"
            + KEY_FAMILY
            + " VARCHAR(50),"
            + KEY_PHONE
            + " VARCHAR(50),"
            + KEY_ADDRESS
            + " TEXT,"
            + KEY_NATIONAL_CODE
            + " VARCHAR(11),"
            + KEY_CAR_TYPE
            + " VARCHAR(20)"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_DRIVER_COLUMNS = {
            KEY_ID,
            KEY_NAME,
            KEY_FAMILY,
            KEY_PHONE,
            KEY_ADDRESS,
            KEY_NATIONAL_CODE,
            KEY_CAR_TYPE
    };

}
