/**
 * Address MUST BE clonable if we want to clone person with address
 * and clone() method must be overridden
 */

public class Address implements Cloneable {
    private String addressStr;

    public Address(String addressStr) {
        this.addressStr = addressStr;
    }

    @Override // Only call super.clone() because Address class has only primitive types fields
    protected Address clone()  {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressStr='" + addressStr + '\'' +
                '}';
    }

}
