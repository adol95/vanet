package software.uok.vanet.model;

/**
 * Created by Mr648 on 4/30/2017.
 */
public class Service {

    private int id;
    private int driverId;
    private int customerId;
    private Driver driver;
    private Customer customer;
    private int freightId;
    private String srcAddress;
    private String dstAddress;
    private int price;
    private long timeMiliSecond;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        setDriverId(driver.getId());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        setCustomerId(customer.getId());
    }

    public int getFreightId() {
        return freightId;
    }

    public void setFreightId(int freightId) {
        this.freightId = freightId;
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress;
    }

    public String getDstAddress() {
        return dstAddress;
    }

    public void setDstAddress(String dstAddress) {
        this.dstAddress = dstAddress;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTimeMiliSecond() {
        return timeMiliSecond;
    }

    public void setTimeMiliSecond(long timeMiliSecond) {
        this.timeMiliSecond = timeMiliSecond;
    }
}
