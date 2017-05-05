package software.uok.vanet.model;

/**
 * Created by Mr648 on 5/4/2017.
 */
public class RealPerson extends Person{
    protected long nationalCode;

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }
}
