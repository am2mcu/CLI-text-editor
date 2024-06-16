import java.io.FileNotFoundException;

public class Testcase2 {
    public static void main(String[] args) throws FileNotFoundException {
        TextEditor textEditor = new TextEditor();

        textEditor.parse("testCase2.txt");
        textEditor.show(5);
        textEditor.nextPage();
        textEditor.show(5);
        textEditor.undo();
        textEditor.show(5);
    }
}
