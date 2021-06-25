package co.za.gordonmzizi.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @Column(name="person_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer personId;
    @Column(name="firstname")
    private String firstName;
    @Column(name="secondname")
    private String secondName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="age")
    private Integer age;
    @Column(name="gender")
    private String gender;
    @Column(name="persontype")
    private String personType;

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
