package Entities;

public class User {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String user;
    private String password;
    private Card card;

    public User() {
    }

    public User(String name, String surname, String phone, String email, String user, String password, Card card) {
        this.name = name;
        this.surname = name;
        this.phone = name;
        this.email = email;
        this.user = user;
        this.password = password;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", card=" + card +
                '}';
    }
}
