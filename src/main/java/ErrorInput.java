/* Exception для неправильного ввода

 */
public class ErrorInput extends Exception {
    private String text;

    public String getText() {
        return text;
    }

    public ErrorInput(String message, String text) {
        super(message);
        this.text = text;
    }
}
