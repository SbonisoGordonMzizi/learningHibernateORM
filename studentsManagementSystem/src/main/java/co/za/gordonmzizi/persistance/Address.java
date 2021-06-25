package co.za.gordonmzizi.persistance;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public  class Address {
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="province")
    private  String province;
    @Column(name="country")
    private  String country;
    @Column(name="zipcode")
    private Integer zipCode;

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public Integer getZipCode() {
        return zipCode;
    }
}
