package co.za.gordonmzizi.persistance;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {
    @Column(name = "cell_no")
    private String cellNo;
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="email")
    private String email;

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}
