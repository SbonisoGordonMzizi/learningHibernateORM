package co.za.gordonmzizi.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="business")
public class Business {
    @Id
    @Column(name="bs_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer businessId;
    @Column(name="bs_name")
    private String businessName;
    @ManyToMany
    @JoinTable(name = "founder_business",joinColumns = @JoinColumn(name = "bs_id"),inverseJoinColumns = @JoinColumn(name ="founder_id" ))
    private Collection<Founder> founders = new ArrayList<>();

    public Collection<Founder> getFounders() {
        return founders;
    }

    public void setFounders(Collection<Founder> founders) {
        this.founders = founders;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public String getBusinessName() {
        return businessName;
    }
}
