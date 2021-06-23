package co.za.gordonmzizi.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="phone")
public class Phone {
    @Id
    @Column(name="phone_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Integer phoneId;
    @Column(name="brand_name")
    private String brandName;
    @ManyToOne
    @JoinColumn(name="human_id")
    private Human human;

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }



    public Integer getPhoneId() {
        return phoneId;
    }

    public String getBrandName() {
        return brandName;
    }


}
