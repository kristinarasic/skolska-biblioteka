package org.example.projekat.members;

public class member {
    private String memmerIndex;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String grade;
    private String age;

    public member() {
    }

    public member(String memmerIndex, String name, String lastname, String email, String phoneNumber, String grade, String age) {
        this.memmerIndex = memmerIndex;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
        this.age = age;
    }

    public String getMemmerIndex() {
        return memmerIndex;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getAge() {
        return age;
    }

    public void setMemmerIndex(String memmerIndex) {
        this.memmerIndex = memmerIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "member{" +
                "memmerIndex='" + memmerIndex + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", grade='" + grade + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
