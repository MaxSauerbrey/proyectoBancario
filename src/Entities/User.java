package Entities;

public class User {
    private String userName;
    private String password;
    private String cardNumber;
    private Double savingAccount;

    public User(){

    }
    public User(String userName, String password, String cardNumber, Double savingAccount) {
        this.userName=userName;
        this.password=userName;
        this.cardNumber = cardNumber;
        this.savingAccount = savingAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Double savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", savingAccount=" + savingAccount +
                '}';
    }
}
