package software.uok.vanet.database;

import java.util.ArrayList;

import software.uok.vanet.model.Admin;
import software.uok.vanet.model.Clerk;
import software.uok.vanet.model.Customer;
import software.uok.vanet.model.Driver;
import software.uok.vanet.model.Service;

/**
 * Created by Mr648 on 5/3/2017.
 */
public interface DatabaseOperations {

    boolean addAdmin(Admin admin);
    boolean removeAdmin(Admin admin);
    boolean updateAdmin(Admin current , Admin updated);
    ArrayList<Admin> getAllAdmin();
    Admin getAdmin(Admin admin);

    boolean addClerk(Clerk clerk);
    boolean removeClerk(Clerk clerk);
    boolean updateClerk(Clerk current , Clerk updated);
    ArrayList<Clerk> getAllClerk();
    Clerk getClerk(Clerk clerk);

    boolean addCustomer(Customer customer);
    boolean removeCustomer(Customer customer);
    boolean updateCustomer(Customer current , Customer updated);
    ArrayList<Customer> getAllCustomer();
    Customer getCustomer(Customer customer);

    boolean addDriver(Driver driver);
    boolean removeDriver(Driver driver);
    boolean updateDriver(Driver current , Driver updated);
    ArrayList<Driver> getAllDriver();
    Driver getDriver(Driver driver);

    boolean addService(Service service);
    boolean removeService(Service service);
    boolean updateService(Service current , Service updated);
    ArrayList<Service> getAllService();
    Service getService(Service service);

//    boolean addLogin(LoginInfo loginInfo);
//    boolean removeLogin(LoginInfo loginInfo);
//    ArrayList<LoginInfo> getAllLogin();
//    LoginInfo getLogin(LoginInfo loginInfo);



}
