package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class ClerkDAO {


    // Clerk table name
    public static final String TABLE_CLERK = "clerk";

    // Clerk Table Columns names
    public static final String KEY_ID = "clerk_id";
    public static final String KEY_NAME = "clerk_name";
    public static final String KEY_FAMILY = "clerk_family";
    public static final String KEY_USERNAME = "clerk_username";
    public static final String KEY_PASSWORD = "clerk_password";
    public static final String KEY_PHONE = "clerk_phone";
    public static final String KEY_ADDRESS= "clerk_address";
    public static final String KEY_NATIONAL_CODE = "clerk_national_code";

    public static final String CREATE_CLERK_TABLE = "CREATE TABLE "
            + TABLE_CLERK
            + " ("
            + KEY_ID
            + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE,"
            + KEY_NATIONAL_CODE
            + " VARCHAR(11) UNIQUE,"
            + KEY_NAME
            + "  VARCHAR(50),"
            + KEY_FAMILY
            + " VARCHAR(50),"
            + KEY_USERNAME
            + " VARCHAR(50),"
            + KEY_PASSWORD
            + " VARCHAR(50),"
            + KEY_PHONE
            + " VARCHAR(15),"
            + KEY_ADDRESS
            + " TEXT"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_CLERK_COLUMNS = {
            KEY_ID ,
            KEY_NAME ,
            KEY_FAMILY ,
            KEY_USERNAME ,
            KEY_PASSWORD ,
            KEY_PHONE ,
            KEY_ADDRESS,
            KEY_NATIONAL_CODE
    };
}
