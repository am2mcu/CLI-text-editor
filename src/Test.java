import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        TextEditor textEditor = new TextEditor();

        textEditor.parse("note.txt");
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//        textEditor.nextPage();
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//        textEditor.nextPage();
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//
//        textEditor.previousPage();
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//
//        textEditor.show(1);
//        textEditor.nextPage();
//        textEditor.show(2);
//
//        textEditor.previousPage();
//        textEditor.append("Get better");
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//        textEditor.show(2);
//
//        textEditor.insert("trying...", 3);
//        textEditor.insert("take care", 2);
//        textEditor.show(4);
//        System.out.println("page " + textEditor.where() + ": " + textEditor.lines() + " lines");
//
//        textEditor.replace(3, "Go ahead");
//        textEditor.replace(4, "Judge me");
//        textEditor.replace(2, "Have a good day");
//        textEditor.show(4);
//
//        textEditor.swap(2, 3);
//        textEditor.swap(3, 4);
//        textEditor.show(4);
//
////        textEditor.remove(2);
////        textEditor.remove(3);
////        textEditor.remove(1);
////        textEditor.show(4);
//
//        textEditor.find("a");
//
//        textEditor.findAndReplace("a", "!!!!");
//        textEditor.show(4);
//
//        textEditor.undo();
//        textEditor.show(4);
//
//        textEditor.redo();
//        textEditor.show(4);
//
//        System.out.println("undo...");
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//
//        System.out.println("print !!!!!!!!!!");
//        textEditor.nextPage();
//        textEditor.show(4);
//        textEditor.nextPage();
//        textEditor.show(4);
//
//        textEditor.save("out.txt");

//        textEditor.show(4);
        textEditor.nextPage();
//        textEditor.show(4);
        textEditor.nextPage();
//        textEditor.show(4);

//        System.out.println("------starting--------------");
//        System.out.println("Page: " + textEditor.where());
//        textEditor.append("added this");
//        textEditor.swap(3, 4);
//        textEditor.show(4);
//
//        System.out.println("------starting undo---------");
//        textEditor.undo();
//        textEditor.show(4);
//        textEditor.undo();
//        textEditor.show(4);
//        System.out.println("------starting redo---------");
//        textEditor.redo();
//        textEditor.show(4);
//        textEditor.redo();
//        textEditor.show(4);
//
//        System.out.println("------find------------------");
//        textEditor.find("l");
//
//        textEditor.show(10);
//        System.out.println("------test insert-----------");
//        textEditor.insert("Now I'm the first", 1);
//        textEditor.insert("I see no god up here", 1);
//        textEditor.insert("second that", 2);
//        textEditor.insert("8th", 8);
//        textEditor.insert("end", 9);
//        textEditor.show(10);
//
//        System.out.println("------test swap-------------");
//        textEditor.swap(1, 2);
//        textEditor.swap(3, 1);
//        textEditor.show(10);
//
//        textEditor.save("out.txt");

        System.out.println("++++++++New Test++++++++++++");
        textEditor.show(10);
        System.out.println("----------------------------");
        textEditor.replace(1, "New line 1");
        textEditor.replace(2, "New line 2");
//        textEditor.replace(5, "New line 5");
        textEditor.show(10);
        textEditor.undo();
        System.out.println("----------undo1-------------");
        textEditor.show(10);
        textEditor.undo();
        System.out.println("----------undo2-------------");
        textEditor.show(10);
        textEditor.undo();
        System.out.println("----------undo3-------------");
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.redo();
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
        textEditor.undo();
        textEditor.show(10);
    }
}