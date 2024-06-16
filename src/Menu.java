import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.run();
    }

    public void run() throws IOException {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        TextEditor textEditor = new TextEditor();

        while (!exit) {
            System.out.println("[ 1] parse\n" +
                    "[ 2] save\n" +
                    "[ 3] where\n" +
                    "[ 4] next page\n" +
                    "[ 5] previous page\n" +
                    "[ 6] lines\n" +
                    "[ 7] show\n" +
                    "[ 8] append\n" +
                    "[ 9] insert\n" +
                    "[10] remove\n" +
                    "[11] replace\n" +
                    "[12] swap\n" +
                    "[13] find\n" +
                    "[14] find and replace\n" +
                    "[15] undo\n" +
                    "[16] redo\n" +
                    "[17] exit\n" +
                    "+++++++++++++++++++++");

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.print("Enter path: ");
                    textEditor.parse(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter path: ");
                    textEditor.save(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Page " + textEditor.where());
                    break;
                case 4:
                    textEditor.nextPage();
                    break;
                case 5:
                    textEditor.previousPage();
                    break;
                case 6:
                    System.out.println("Lines: " + textEditor.lines());
                    break;
                case 7:
                    System.out.print("Enter lines: ");
                    textEditor.show(Integer.parseInt(scanner.nextLine()));
                    break;
                case 8:
                    System.out.print("Enter text: ");
                    textEditor.append(scanner.nextLine());
                    break;
                case 9:
                    System.out.print("Enter text: ");
                    String str = scanner.nextLine();
                    System.out.print("Enter line: ");
                    textEditor.insert(str, Integer.parseInt(scanner.nextLine()));
                    break;
                case 10:
                    System.out.print("Enter line: ");
                    textEditor.remove(Integer.parseInt(scanner.nextLine()));
                    break;
                case 11:
                    System.out.print("Enter line: ");
                    int line = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter text: ");
                    textEditor.replace(line, scanner.nextLine());
                    break;
                case 12:
                    System.out.print("Enter first line: ");
                    int firstLine = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter second line: ");
                    textEditor.swap(firstLine, Integer.parseInt(scanner.nextLine()));
                    break;
                case 13:
                    System.out.print("Enter text: ");
                    textEditor.find(scanner.nextLine());
                    break;
                case 14:
                    System.out.print("Enter text: ");
                    str = scanner.nextLine();
                    System.out.print("Enter replacement: ");
                    textEditor.findAndReplace(str, scanner.nextLine());
                    break;
                case 15:
                    textEditor.undo();
                    break;
                case 16:
                    textEditor.redo();
                    break;
                case 17:
                    exit = true;
            }
        }
    }
}