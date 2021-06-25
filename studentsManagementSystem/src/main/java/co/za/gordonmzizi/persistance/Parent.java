package co.za.gordonmzizi.persistance;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Parent extends Person {
    @Embedded
    private Address address;

    @Embedded
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
