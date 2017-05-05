package software.uok.vanet.database.dao;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class LoginDAO {


    // Login table name
    public static final String TABLE_LOGIN = "login";

    // Login Table Columns names
    public static final String KEY_ID = "login_id";
    public static final String KEY_CLERK_ID = "clerk_id";
    public static final String KEY_LOGIN_TIME = "login_time";
    public static final String KEY_LOGOUT_TIME = "logout_time";

    public static final String CREATE_LOGIN_TABLE = "CREATE TABLE "
            + TABLE_LOGIN
            + " ("
            + KEY_ID
            + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE,"
            + KEY_CLERK_ID
            + "  INTEGER NOT NULL,"
            + KEY_LOGIN_TIME
            + " VARCHAR(50),"
            + KEY_LOGOUT_TIME
            + " VARCHAR(50),"
            + "FOREIGN KEY(" + KEY_CLERK_ID + ") REFERENCES "
            + ClerkDAO.TABLE_CLERK + "(" + ClerkDAO.KEY_ID + ")"
            + ")";

    // All table columns in an array
    public static final String[] TABLE_LOGIN_COLUMNS = {
            KEY_ID,
            KEY_CLERK_ID,
            KEY_LOGIN_TIME,
            KEY_LOGOUT_TIME
    };
}
