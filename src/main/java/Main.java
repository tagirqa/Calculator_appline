import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static String choice;
    private static String text;
    private static String strValue;

    public static void main(String[] args) throws ErrorInput {
        System.out.println("Введите номер задания (1 или 2): ");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            choice = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (choice.equals("1")) calculate();
        else if (choice.equals("2")) maxLengthWord();
        else System.out.println("Не правильный ввод!");
    }

    private static void maxLengthWord() {
        System.out.println("Введите слова через пробел: ");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            text = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        ListWord listWord = new ListWord(text);
        strValue = listWord.doIt().size() > 1 ? "Слова с максимальной длинной:" : "Слово с максимальной длинной:";
        System.out.println(strValue);
        listWord.getArrayList().forEach(word -> System.out.println(word));
    }

    private static void calculate() throws ErrorInput {
        System.out.println("Введите выражение: ");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            text = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        Expression expression = new Expression(text);
        expression.checkText();
        System.out.printf("Ответ: %.4f %n", expression.doIt());
    }

}
