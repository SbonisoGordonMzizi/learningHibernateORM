package co.za.gordonmzizi.persistence;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy ="increment")
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ElementCollection
    @JoinTable(name = "address",joinColumns = @JoinColumn(name ="useridd"))
    @GenericGenerator(name = "increment",strategy = "increment")
    @CollectionId(columns = {@Column(name="address_id")},generator = "increment",type =@Type(type = "int"))
    private Collection<Address> addresses = new ArrayList<>();

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }
}
