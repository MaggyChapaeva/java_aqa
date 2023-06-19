package ru.stqa.aqa.addressbook.model;

public class ContactData {
    private String firstname;
    private String lastname;
    private String nickname;
    private String mobile;
    private String email;
    private String group;

    public ContactData(String firstname, String lastname, String nickname, String mobile, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
