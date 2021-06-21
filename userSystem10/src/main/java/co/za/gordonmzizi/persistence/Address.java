package co.za.gordonmzizi.persistence;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="zipcode")
    private Integer zipCode;


    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipcode(Integer zipcode) {
        this.zipCode = zipcode;
    }


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getZipcode() {
        return zipCode;
    }
}
