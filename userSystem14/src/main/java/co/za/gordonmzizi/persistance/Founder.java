package co.za.gordonmzizi.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="founder")
public class Founder {
    @Id
    @Column(name="founder_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer founderId;
    @Column(name = "founder_name")
    private String founderName;
    @ManyToMany(mappedBy = "founders",cascade = CascadeType.PERSIST)
    private Collection<Business> businesses = new ArrayList<>();

    public void setBusinesses(Collection<Business> businesses) {
        this.businesses = businesses;
    }

    public Collection<Business> getBusinesses() {
        return businesses;
    }

    public void setFounderId(Integer founderId) {
        this.founderId = founderId;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public Integer getFounderId() {
        return founderId;
    }

    public String getFounderName() {
        return founderName;
    }
}
