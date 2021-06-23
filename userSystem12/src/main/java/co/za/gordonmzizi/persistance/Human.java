package co.za.gordonmzizi.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="human")
public class Human {
    @Id
    @Column(name="human_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer humanId;
    @Column(name="firstname")
    private String firstName;
    @OneToMany(mappedBy = "human")
    private Collection<Phone> phones = new ArrayList<>();
    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }



    public void setHumanId(Integer humanId) {
        this.humanId = humanId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public Integer getHumanId() {
        return humanId;
    }

    public String getFirstName() {
        return firstName;
    }


}
