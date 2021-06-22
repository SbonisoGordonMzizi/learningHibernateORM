package co.za.gordonmzizi.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @Column(name="car_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
   private Integer carId;
    @Column(name="car_name")
   private String carName;

    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }
}
