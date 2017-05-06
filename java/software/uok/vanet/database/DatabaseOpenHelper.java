package software.uok.vanet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import software.uok.vanet.database.dao.AdminDAO;
import software.uok.vanet.database.dao.ClerkDAO;
import software.uok.vanet.database.dao.CustomerDAO;
import software.uok.vanet.database.dao.DriverDAO;
import software.uok.vanet.database.dao.LoginDAO;
import software.uok.vanet.database.dao.ServiceDAO;
import software.uok.vanet.model.Admin;
import software.uok.vanet.model.Clerk;
import software.uok.vanet.model.Customer;
import software.uok.vanet.model.Driver;
import software.uok.vanet.model.Service;

/**
 * Created by Mr648 on 5/2/2017.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper implements DatabaseOperations {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "vanet.db";

    private static DatabaseOpenHelper mInstance;

    public static DatabaseOpenHelper getInstance(Context context) {
        return (mInstance == null) ? new DatabaseOpenHelper(context) : mInstance;
    }

    private DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // dont modify order of table creation commands
        db.execSQL(AdminDAO.CREATE_ADMIN_TABLE);
        db.execSQL(ClerkDAO.CREATE_CLERK_TABLE);
        db.execSQL(CustomerDAO.CREATE_CUSTOMER_TABLE);
        db.execSQL(DriverDAO.CREATE_DRIVER_TABLE);
        db.execSQL(LoginDAO.CREATE_LOGIN_TABLE);
        db.execSQL(ServiceDAO.CREATE_SERVICE_TABLE);

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public boolean addAdmin(Admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(AdminDAO.KEY_NATIONAL_CODE, admin.getNationalCode());
        values.put(AdminDAO.KEY_NAME, admin.getName());
        values.put(AdminDAO.KEY_FAMILY, admin.getFamily());
        values.put(AdminDAO.KEY_PASSWORD, admin.getPassword());
        values.put(AdminDAO.KEY_USERNAME, admin.getUsername());
        values.put(AdminDAO.KEY_PHONE, admin.getPhone());
        values.put(AdminDAO.KEY_ADDRESS, admin.getAddress());

        long result = db.insert(AdminDAO.TABLE_ADMIN, null, values);
        db.close();

        return (result != -1);
    }

    @Override
    public boolean addClerk(Clerk clerk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ClerkDAO.KEY_NAME, clerk.getName());
        values.put(ClerkDAO.KEY_NATIONAL_CODE, clerk.getNationalCode());
        values.put(ClerkDAO.KEY_FAMILY, clerk.getFamily());
        values.put(ClerkDAO.KEY_PASSWORD, clerk.getPassword());
        values.put(ClerkDAO.KEY_USERNAME, clerk.getUsername());
        values.put(ClerkDAO.KEY_PHONE, clerk.getPhone());
        values.put(ClerkDAO.KEY_ADDRESS, clerk.getAddress());

        long result = db.insert(ClerkDAO.TABLE_CLERK, null, values);
        db.close();

        return (result != -1);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CustomerDAO.KEY_NAME, customer.getName());
        values.put(CustomerDAO.KEY_FAMILY, customer.getFamily());
        values.put(CustomerDAO.KEY_PHONE, customer.getPhone());
        values.put(CustomerDAO.KEY_ADDRESS, customer.getAddress());

        long result = db.insert(CustomerDAO.TABLE_CUSTOMER, null, values);
        db.close();

        return (result != -1);
    }

    @Override
    public boolean addDriver(Driver driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DriverDAO.KEY_NAME, driver.getName());
        values.put(DriverDAO.KEY_NATIONAL_CODE, driver.getAddress());
        values.put(DriverDAO.KEY_FAMILY, driver.getFamily());
        values.put(DriverDAO.KEY_PHONE, driver.getPhone());
        values.put(DriverDAO.KEY_ADDRESS, driver.getAddress());
        values.put(DriverDAO.KEY_CAR_TYPE, driver.getCarType().getType());

        long result = db.insert(DriverDAO.TABLE_DRIVER, null, values);
        db.close();

        return (result != -1);
    }


    @Override
    public boolean addService(Service service) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ServiceDAO.KEY_DRIVER_ID, service.getDriverId());
        values.put(ServiceDAO.KEY_CUSTOMER_ID, service.getCustomerId());
        values.put(ServiceDAO.KEY_SERVICE_SRC, service.getSrcAddress());
        values.put(ServiceDAO.KEY_SERVICE_DST, service.getDstAddress());
        values.put(ServiceDAO.KEY_PRICE, service.getPrice());
        values.put(ServiceDAO.KEY_TIME, service.getTimeMiliSecond());

        long result = db.insert(ServiceDAO.TABLE_SERVICE, null, values);
        db.close();

        return (result != -1);
    }

    @Override
    public boolean removeAdmin(Admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        byte result = (byte) db.delete(AdminDAO.TABLE_ADMIN, AdminDAO.KEY_ID + " = ?",
                new String[]{Integer.toString(admin.getId())});
        db.close();
        return result != 0;
    }

    @Override
    public boolean removeClerk(Clerk admin) {
        SQLiteDatabase db = this.getWritableDatabase();
        byte result = (byte) db.delete(ClerkDAO.TABLE_CLERK, ClerkDAO.KEY_ID + " = ?",
                new String[]{Integer.toString(admin.getId())});
        db.close();
        return result != 0;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        byte result = (byte) db.delete(CustomerDAO.TABLE_CUSTOMER, CustomerDAO.KEY_ID + "=?",
                new String[]{Integer.toString(customer.getId())});
        db.close();
        return result != 0;
    }

    @Override
    public boolean removeDriver(Driver driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        byte result = (byte) db.delete(DriverDAO.TABLE_DRIVER, DriverDAO.KEY_ID + "=?",
                new String[]{Integer.toString(driver.getId())});
        db.close();
        return result != 0;
    }

    @Override
    public boolean removeService(Service service) {

        SQLiteDatabase db = this.getWritableDatabase();
        int result = (byte) db.delete(ServiceDAO.TABLE_SERVICE, ServiceDAO.KEY_ID + "=?",
                new String[]{Integer.toString(service.getId())});
        db.close();
        return result != 0;
    }

    @Override
    public boolean updateAdmin(Admin current, Admin updated) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AdminDAO.KEY_NAME, updated.getName());
        values.put(AdminDAO.KEY_FAMILY, updated.getFamily());
        values.put(AdminDAO.KEY_PASSWORD, updated.getPassword());
        values.put(AdminDAO.KEY_USERNAME, updated.getUsername());
        values.put(AdminDAO.KEY_NATIONAL_CODE, updated.getNationalCode());

        // updating row
        return (db.update(AdminDAO.TABLE_ADMIN, values, AdminDAO.KEY_ID + " = ?",
                new String[]{String.valueOf(current.getId())}) > 0);
    }

    @Override
    public boolean updateClerk(Clerk current, Clerk updated) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ClerkDAO.KEY_NAME, updated.getName());
        values.put(ClerkDAO.KEY_FAMILY, updated.getFamily());
        values.put(ClerkDAO.KEY_PASSWORD, updated.getPassword());
        values.put(ClerkDAO.KEY_USERNAME, updated.getUsername());
        values.put(ClerkDAO.KEY_NATIONAL_CODE, updated.getNationalCode());

        // updating row
        return (db.update(AdminDAO.TABLE_ADMIN, values, ClerkDAO.KEY_ID + " = ?",
                new String[]{String.valueOf(current.getId())}) > 0);
    }

    @Override
    public boolean updateCustomer(Customer current, Customer updated) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CustomerDAO.KEY_NAME, updated.getName());
        values.put(CustomerDAO.KEY_FAMILY, updated.getFamily());
        values.put(CustomerDAO.KEY_PHONE, updated.getPhone());
        values.put(CustomerDAO.KEY_ADDRESS, updated.getAddress());

        // updating row
        return db.update(CustomerDAO.TABLE_CUSTOMER, values, CustomerDAO.KEY_ID + " = ?",
                new String[]{String.valueOf(current.getId())}) > 0;
    }

    @Override
    public boolean updateDriver(Driver current, Driver updated) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DriverDAO.KEY_NAME, updated.getName());
        values.put(DriverDAO.KEY_FAMILY, updated.getFamily());
        values.put(DriverDAO.KEY_PHONE, updated.getPhone());
        values.put(DriverDAO.KEY_ADDRESS, updated.getAddress());
        values.put(DriverDAO.KEY_NATIONAL_CODE, updated.getAddress());
        values.put(DriverDAO.KEY_CAR_TYPE, updated.getAddress());

        // updating row
        return db.update(DriverDAO.TABLE_DRIVER, values, DriverDAO.KEY_ID + " = ?",
                new String[]{String.valueOf(current.getId())}) > 0;
    }

    @Override
    public boolean updateService(Service current, Service updated) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ServiceDAO.KEY_ID, current.getId());
        values.put(ServiceDAO.KEY_DRIVER_ID, updated.getDriverId());
        values.put(ServiceDAO.KEY_CUSTOMER_ID, updated.getCustomerId());
        values.put(ServiceDAO.KEY_SERVICE_SRC, updated.getSrcAddress());
        values.put(ServiceDAO.KEY_SERVICE_DST, updated.getDstAddress());
        values.put(ServiceDAO.KEY_PRICE, updated.getPrice());
        values.put(ServiceDAO.KEY_TIME, updated.getTimeMiliSecond());

        // updating row
        return db.update(ServiceDAO.TABLE_SERVICE, values, ServiceDAO.KEY_ID + " = ?",
                new String[]{String.valueOf(current.getId())}) > 0;
    }


    @Override
    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + AdminDAO.TABLE_ADMIN;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Admin admin = new Admin();

                admin.setId(cursor.getInt(0));
                admin.setName(cursor.getString(1));
                admin.setFamily(cursor.getString(2));
                admin.setPhone(cursor.getString(3));
                admin.setAddress(cursor.getString(4));

                // Adding admin to list
                adminList.add(admin);
            }
            while (cursor.moveToNext());
        }

        // return course list
        return adminList;
    }

    @Override
    public ArrayList<Clerk> getAllClerk() {
        ArrayList<Clerk> clerkList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + ClerkDAO.TABLE_CLERK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Clerk clerk = new Clerk();

                clerk.setId(cursor.getInt(0));
                clerk.setName(cursor.getString(1));
                clerk.setFamily(cursor.getString(2));
                clerk.setPhone(cursor.getString(3));
                clerk.setAddress(cursor.getString(4));
                // Adding course to list
                clerkList.add(clerk);
            }
            while (cursor.moveToNext());
        }

        // return course list
        return clerkList;
    }

    @Override
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customerList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CustomerDAO.TABLE_CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor customerInfo = db.rawQuery(selectQuery, null);


        if (customerInfo.moveToFirst()) {
            do {
                // creating an instance of Customer
                Customer customer = new Customer();

                // setting properties
                customer.setId(customerInfo.getInt(0));
                customer.setName(customerInfo.getString(1));
                customer.setFamily(customerInfo.getString(2));
                customer.setPhone(customerInfo.getString(3));
                customer.setAddress(customerInfo.getString(4));

                // adding customer to list
                customerList.add(customer);
            }
            while (customerInfo.moveToNext());
        }

        // return customer list
        return customerList;
    }

    @Override
    public ArrayList<Driver> getAllDriver() {
        ArrayList<Driver> driverList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DriverDAO.TABLE_DRIVER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor customerInfo = db.rawQuery(selectQuery, null);


        if (customerInfo.moveToFirst()) {
            do {
                // creating an instance of Driver
                Driver driver = new Driver();

                // setting properties
                driver.setId(customerInfo.getInt(0));
                driver.setName(customerInfo.getString(1));
                driver.setFamily(customerInfo.getString(2));
                driver.setPhone(customerInfo.getString(3));
                driver.setAddress(customerInfo.getString(4));

                // adding driver to list
                driverList.add(driver);
            }
            while (customerInfo.moveToNext());
        }

        // return driver list
        return driverList;
    }

    @Override
    public ArrayList<Service> getAllService() {
        ArrayList<Service> serviceList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + ServiceDAO.TABLE_SERVICE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Service service = new Service();
                service.setId(cursor.getInt(0));
                service.setDriverId(cursor.getInt(1));
                service.setCustomerId(cursor.getInt(2));
                service.setSrcAddress(cursor.getString(3));
                service.setDstAddress(cursor.getString(4));
                service.setPrice(cursor.getInt(5));
                service.setTimeMiliSecond(cursor.getLong(6));
                // Adding service to list
                serviceList.add(service);
            }
            while (cursor.moveToNext());
        }

        // return service list
        return serviceList;
    }

    @Override
    public Admin getAdmin(Admin admin) {

        return null;
    }

    @Override
    public Clerk getClerk(Clerk admin) {

        return null;
    }

    @Override
    public Customer getCustomer(Customer customer) {

        return null;
    }

    @Override
    public Driver getDriver(Driver driver) {

        return null;
    }

    @Override
    public Service getService(Service service) {

        return null;
    }

    public int getLastRowId(String idColumnName , String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT MAX("
                + idColumnName
                + ") FROM "
                + tableName;

        int lastRowId = 0;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            lastRowId = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return lastRowId;
    }


}
