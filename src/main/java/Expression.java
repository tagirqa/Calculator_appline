import java.util.Arrays;

public class Expression {
    private String text;
    private String[] signs = new String[] {"+", "-", "*", "/"};
    private float value1;
    private float value2;
    private String sign;


    public Expression(String text) {
        this.text = text;
    }

    /* Функция выполняют операцию взависимости от полученного знака

     */

    public float doIt() {
        switch (sign) {
            case "+":
                return addition(value1, value2);
            case  "-":
                return subtraction(value1, value2);
            case "*":
                return multiply(value1,value2);
            case "/":
                return division(value1, value2);
        }
        return 0;
    }

    /* Базовые операции с числами

     */

    private static float addition(float x, float y) {
        return x + y;
    }

    private static float subtraction(float x, float y) {
        return x - y;
    }

    private static float multiply(float x, float y) {
        return x * y;
    }

    private static float division(float x, float y) {
        return x / y;
    }

    /* Разбиваем полученную строку по символам

     */

    private static  String[] convertText(String text){
        return text.split(" ");
    }

    /* Проверка входящей строки - если получаем ошибку то вызывается Exception ErrorInput

     */
    public void checkText() throws ErrorInput {
        String[] str = convertText(text);
        if (str.length != 3) throw new ErrorInput("Неправильный ввод", text);
        if (Arrays.stream(signs).noneMatch(str[1]::equals)) throw new ErrorInput("Неправильный ввод", text);
        try {
            value1 = Float.parseFloat(str[0]);
            value2 = Float.parseFloat(str[2]);
            sign = str[1];
        } catch (Exception e) {
            throw new ErrorInput("Неправильный ввод чисел", value1 + " " + value2);
        }
    }
}
