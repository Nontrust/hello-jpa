package hellojpa.valueType;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String address;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return address;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(city, address1.city) && Objects.equals(street, address1.street) && Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, address);
    }
}
