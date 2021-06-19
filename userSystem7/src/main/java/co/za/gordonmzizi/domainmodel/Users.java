package co.za.gordonmzizi.domainmodel;

public class Users {
    private Integer userid;
    private String firstname;
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
