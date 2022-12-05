package Entities;

import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private User user;

    public Client() {
    }

    public Client(String name, String surname, String phone, String email, User user) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (!getPhone().equals(client.getPhone())) return false;
        if (!getEmail().equals(client.getEmail())) return false;
        return getUser().equals(client.getUser());
    }

    @Override
    public int hashCode() {
        int result = getPhone().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
