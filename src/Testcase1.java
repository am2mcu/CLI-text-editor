import java.io.FileNotFoundException;

public class Testcase1 {
    public static void main(String[] args) throws FileNotFoundException {
        TextEditor textEditor = new TextEditor();

        textEditor.parse("testCase1.txt");
        textEditor.show(5);
        textEditor.nextPage();
        textEditor.show(5);
    }
}
