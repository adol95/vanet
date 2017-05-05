package software.uok.vanet.model;

import software.uok.vanet.data.FreightWeight;

/**
 * Created by Mr648 on 4/30/2017.
 */
public class Freight {
    private long id;
    private FreightWeight freightWeight;
    private String typeDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FreightWeight getFreightWeight() {
        return freightWeight;
    }

    public void setFreightWeight(FreightWeight freightWeight) {
        this.freightWeight = freightWeight;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
