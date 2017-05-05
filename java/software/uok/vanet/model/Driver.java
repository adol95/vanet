package software.uok.vanet.model;

import software.uok.vanet.data.CarType;

/**
 * Created by Mr648 on 4/30/2017.
 */
public class Driver extends RealPerson {

    private CarType carType;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

}
