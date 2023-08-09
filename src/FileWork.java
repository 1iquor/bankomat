import java.io.*;
import java.util.ArrayList;

public class FileWork {
    public static void writeCardList(ArrayList<Card> list) {
        try {
            FileWriter fileWriter = new FileWriter("cards.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Card element : list) {
                bufferedWriter.write(element.getCardNumber() + " " + element.getPinCode() + " " + element.getBalance());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Успешная запись файла.");

        } catch (IOException e) {
            System.out.println("Возникла ошибка.");
        }
    }

    public static ArrayList<Card> readCardList() {
        ArrayList<Card> readList = new ArrayList<>();
        try {
            File file = new File("cards.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine;

            while ((fileLine = bufferedReader.readLine()) != null) {
                //readList.add(line);
                String[] values = fileLine.split(" ");
                readList.add(new Card(values[0], values[1], Double.parseDouble(values[2])));
            }

            bufferedReader.close();
            fileReader.close();
            System.out.println("Успешное чтение списка карт.");
            return readList;

        } catch (IOException e) {
            System.out.println("Возникла ошибка.");
            return null;
        }


    }

    public static BankTerminal readBankTerminal() {
        try {
            File file = new File("terminal.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            bufferedReader.close();
            fileReader.close();
            System.out.println("Данные о количестве наличных рублей получены.");
            return new BankTerminal(Double.parseDouble(line));
        } catch (IOException e) {
            System.out.println("Возникла ошибка.");
            return null;
        }
    }

    public static void writeBankTerminal(double cash) {
        try {
            FileWriter fileWriter = new FileWriter("terminal.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(Double.toString(cash));

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Данные о количестве наличных рублей записаны.");
        } catch (IOException e) {
            System.out.println("Возникла ошибка.");
        }
    }
}
