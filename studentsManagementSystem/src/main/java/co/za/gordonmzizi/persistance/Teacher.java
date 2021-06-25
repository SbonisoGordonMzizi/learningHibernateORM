package co.za.gordonmzizi.persistance;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Teacher extends Person{
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
