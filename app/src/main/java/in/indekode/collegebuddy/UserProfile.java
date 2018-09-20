package in.indekode.collegebuddy;

public class UserProfile {
    public String username1;
    public String email1;

    public UserProfile() {

    }

    public UserProfile( String username1, String email1) {
        this.username1 = username1;
        this.email1 = email1;
    }


    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }
}
