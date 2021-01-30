import java.util.ArrayList;

public class ListWord {
    private String text;
    private String[] str;
    private String maxWord;
    private ArrayList<String> arrayList = new ArrayList<>();

    public ListWord(String text) {
        this.text = text;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    private void checkEqualsLength() {
        for (String word : str) {
            if (word.length() == maxWord.length()) {
                arrayList.add(word);
            }
        }
    }

    public ArrayList<String> doIt() {
        str = text.split(" ");
        maxWord = str[0];
        for (int i = 1; i < str.length; i++) {
            if (maxWord.length() < str[i].length()) {
                maxWord = str[i];
            }
        }
        checkEqualsLength();
        return arrayList;
    }
}