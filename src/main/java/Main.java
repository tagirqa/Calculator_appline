import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static String text;

    public static void main(String[] args) throws ErrorInput {
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
