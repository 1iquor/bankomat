import java.util.Scanner;

public class Card {
 private String cardNumber;
 private String pinCode;
 private double balance = 0;

    public Card(String cardNumber, String pinCode, double balance) {
        Scanner scanner = new Scanner(System.in);
        String pattern_cardNumber = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";
        String pattern_pinCode = "\\d{4}";
        while (!cardNumber.matches(pattern_cardNumber)) {
           System.out.println("Неправильный формат номера карты. Попробуйте ввести номер снова.");
            cardNumber = scanner.nextLine();
        }
        this.cardNumber = cardNumber;
        while (!pinCode.matches(pattern_pinCode)) {
            System.out.println("Пин-код должен содержать 4 цифры. Введите пин снова.");
            pinCode = scanner.nextLine();
        }
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setAddBalance(double sum) {
        balance += sum;
    }

    public void setSubBalance(double sum) {
        balance -= sum;
    }

}