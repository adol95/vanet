package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class CustomerDAO {

    // Customer table name
    public static final String TABLE_CUSTOMER = "customer";

    // Customer Table Columns names
    public static final String KEY_ID = "customer_id";
    public static final String KEY_NAME = "customer_name";
    public static final String KEY_FAMILY = "customer_family";
    public static final String KEY_PHONE = "customer_phone";
    public static final String KEY_ADDRESS = "customer_address";

    public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE "
            + TABLE_CUSTOMER
            + " ("
            + KEY_ID
            + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE DEFAULT 1,"
            + KEY_NAME
            + "  VARCHAR(50),"
            + KEY_FAMILY
            + " VARCHAR(50),"
            + KEY_PHONE
            + " VARCHAR(15),"
            + KEY_ADDRESS
            + " TEXT"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_CUSTOMER_COLUMNS = {
            KEY_ID,
            KEY_NAME,
            KEY_FAMILY,
            KEY_PHONE,
            KEY_ADDRESS
    };
}
