package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class ServiceDAO {

    // student table name
    public static final String TABLE_SERVICE = "service";

    // admin Table Columns names
    public static final String KEY_ID = "service_id";
    public static final String KEY_DRIVER_ID = "service_driver_id";
    public static final String KEY_CUSTOMER_ID = "service_customer_id";
    public static final String KEY_SERVICE_SRC = "service_src";
    public static final String KEY_SERVICE_DST = "service_dst";
    public static final String KEY_PRICE = "service_price";
    public static final String KEY_TIME = "service_time";


    public static final String CREATE_SERVICE_TABLE = "CREATE TABLE "
            + TABLE_SERVICE
            + " ("
            + KEY_ID
            + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE,"
            + KEY_DRIVER_ID
            + " INTEGER,"
            + KEY_CUSTOMER_ID
            + " INTEGER,"
            + KEY_SERVICE_SRC
            + " TEXT,"
            + KEY_SERVICE_DST
            + " TEXT,"
            + KEY_PRICE
            + " INTEGER,"
            + KEY_TIME
            + " DATETIME,"
            + "FOREIGN KEY(" + KEY_DRIVER_ID + ") REFERENCES "
            + DriverDAO.TABLE_DRIVER + "(" + DriverDAO.KEY_ID + "),"
            + "FOREIGN KEY(" + KEY_CUSTOMER_ID + ") REFERENCES "
            + CustomerDAO.TABLE_CUSTOMER + "(" + CustomerDAO.KEY_ID + ")"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_SERVICE_COLUMNS = {
            KEY_ID,
            KEY_DRIVER_ID,
            KEY_CUSTOMER_ID,
            KEY_SERVICE_SRC,
            KEY_SERVICE_DST,
            KEY_PRICE,
            KEY_TIME
    };
}
