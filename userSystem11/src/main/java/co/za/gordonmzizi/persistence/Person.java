package co.za.gordonmzizi.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name="person_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer personId;
    @Column(name="firstname")
    private String firstName;

    @OneToOne
    @JoinColumn(name="person_id")
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
