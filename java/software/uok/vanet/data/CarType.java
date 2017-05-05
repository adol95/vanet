package software.uok.vanet.data;

/**
 * Created by Mr648 on 5/1/2017.
 */
public enum CarType {

    VANET("انت"),
    VANET_PAYKAN("وانت پیکان"),
    VANET_NEISSAN("وانت نیسان");

    private String type;
    private CarType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
