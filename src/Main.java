import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankTerminal terminal = FileWork.readBankTerminal();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Card> cardList = FileWork.readCardList();
        System.out.println("Введите номер карты: ");
        String pattern_cardNumber = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";
        String cardNumber = scanner.nextLine();
        while (!cardNumber.matches(pattern_cardNumber)) {
            System.out.println("Неправильный формат номера карты.");
            cardNumber = scanner.nextLine();
        }
        Card card = null;
        for (int i = 0; i < cardList.size(); i++){
            if (Objects.equals(cardList.get(i).getCardNumber(), cardNumber)) {
                card = cardList.get(i);
            }
        }
        if(card != null && terminal.getCard(card))
        {
            if (terminal.cardOperations()){
                FileWork.writeCardList(cardList);
                FileWork.writeBankTerminal(terminal.getMoney());
            }
        }

    }
}