package in.indekode.collegebuddy;

public class UserProfile {
    public String username1;
    public String email1;
    public String rno;
    public String password1;
    public String year;
    public String branch;
    public String division;
    public String name1;
    public UserProfile() {

    }

    public UserProfile( String username1, String email1, String Rollno, String password1, String year, String branch, String division, String name1) {
        this.username1 = username1;
        this.email1 = email1;
        this.rno = Rollno;
        this.password1 = password1;
        this.year = year;
        this.branch=branch;
        this.division = division;
        this.name1 = name1;
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

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }


    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }


}
