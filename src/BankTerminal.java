import java.util.Objects;
import java.util.Scanner;

public class BankTerminal {
    private Card card;
    private double moneyAmount;
    Scanner sc = new Scanner(System.in);

    BankTerminal(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoney() {
        return moneyAmount;
    }

    public boolean getCard(Card card) {
        System.out.println("Введите ПИН-код: ");
        String pin = sc.nextLine();
        if (Objects.equals(pin, card.getPinCode())) {
            System.out.println("Верно!");
            this.card = card;
            return true;
        } else {
            System.out.println("Неверный пин-код.");
            return false;
        }
    }

    public boolean cardOperations() {
        if (card == null) {
            return false;
        }
        while (true) {
            System.out.println("Список операций: \n 1.Пополнить баланс \n 2.Снять деньги со счета \n 3.Проверить баланс \n 4.Выход.");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    try {
                        System.out.println("Введите сумму пополнения:");
                        String sum = sc.nextLine();
                        deposit(Double.parseDouble(sum));
                    } catch (Exception e) {
                        System.out.println("Введена неверная сумма");
                    }
                    break;
                }
                case "2": {
                    try {
                        System.out.println("Введите сумму снятия:");
                        String sum = sc.nextLine();
                        if (Double.parseDouble(sum) < moneyAmount) {
                            withdrawal(Double.parseDouble(sum));
                        } else {
                            System.out.println("Недостаточно наличных в данном банкомате для выдачи.");
                        }
                    } catch (Exception e) {
                        System.out.println("Введена неверная сумма");
                    }
                    break;
                }
                case "3": {
                    checkBalance();
                    break;
                }
                case "4": {
                    card = null;
                    return true;
                }
                default: {
                    System.out.println("Такой операции не существует.");
                    break;
                }
            }
        }

    }

    public void deposit(double sum) {
        if (sum > 0 && sum <= 1000000) {
            card.setAddBalance(sum);
            System.out.println("Баланс успешно пополнен на " + sum + " руб.");
        } else {
            System.out.println("Ошибка пополнения: некорректная сумма.");
        }
        moneyAmount += sum;
    }

    public void withdrawal(double sum) {
        if (sum > 0 && sum <= card.getBalance()) {
            card.setSubBalance(sum);
            System.out.println("Вы успешно сняли " + sum + " руб.");
        } else {
            System.out.println("Ошибка снятия: некорректная сумма или недостаточное количество средств на счету.");
        }
        moneyAmount -= sum;
    }

    public void checkBalance() {
        System.out.println("Баланс карты: " + card.getBalance() + " руб.");
    }
}
