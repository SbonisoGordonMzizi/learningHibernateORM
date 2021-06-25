package co.za.gordonmzizi.persistance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Student extends Person{
    @Embedded
    private Address Address;

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }
}
