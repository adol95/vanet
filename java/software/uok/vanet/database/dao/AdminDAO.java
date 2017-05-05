package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class AdminDAO {

    // Admin table name
    public static final String TABLE_ADMIN = "admin";

    // Admin Table Columns names
    public static final String KEY_ID = "admin_id";
    public static final String KEY_NAME = "admin_name";
    public static final String KEY_FAMILY = "admin_family";
    public static final String KEY_USERNAME = "admin_username";
    public static final String KEY_PASSWORD = "admin_password";
    public static final String KEY_PHONE = "admin_phone";
    public static final String KEY_ADDRESS = "admin_address";
    public static final String KEY_NATIONAL_CODE = "admin_national_code";


    public static final String CREATE_ADMIN_TABLE = "CREATE TABLE "
            + TABLE_ADMIN
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,"
            + KEY_NATIONAL_CODE + " VARCHAR(11) UNIQUE,"
            + KEY_NAME + " TEXT,"
            + KEY_FAMILY + " TEXT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT,"
            + KEY_PHONE + " VARCHAR(15),"
            + KEY_ADDRESS + " TEXT"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_ADMIN_COLUMNS = {
            KEY_ID,
            KEY_NAME,
            KEY_FAMILY,
            KEY_USERNAME,
            KEY_PASSWORD,
            KEY_PHONE,
            KEY_ADDRESS,
            KEY_NATIONAL_CODE
    };
}
