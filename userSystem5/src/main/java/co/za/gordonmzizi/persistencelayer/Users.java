package co.za.gordonmzizi.persistencelayer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name = "userid")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name="incrementor", strategy="increment")
    private Integer userid;

    @Column(name="firstname")
    private String firstname;
    @Column(name ="lastname")
    private String lastname;

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
