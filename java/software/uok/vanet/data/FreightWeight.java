package software.uok.vanet.data;

/**
 * Created by Mr648 on 4/30/2017.
 */
public enum FreightWeight {

    HIGH(1),
    NORMAL(0),
    LOW(-1);

    private int weight;

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private FreightWeight(int weight){
        this.weight = weight;
    }
}
