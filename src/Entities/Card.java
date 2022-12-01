package Entities;

public class Card {
    private String cardNumber;
    private Double savingAccount;

    public Card (){

    }
    public Card(String cardNumber, Double savingAccount) {
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

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", savingAccount=" + savingAccount +
                '}';
    }
}
