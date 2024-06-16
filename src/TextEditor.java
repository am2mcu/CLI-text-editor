import java.io.*;
import java.util.Scanner;

public class TextEditor {
    Page pages = new Page();
    PageNode currentPage;
    Stack undo = new Stack();
    Stack redo = new Stack();

    static final String PAGE_SEPARATOR = "\\$";
    private boolean undoMode = false;

    public void parse(String address) throws FileNotFoundException {
        File file = new File(address);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            Line lines = new Line();
            while (!scanner.hasNext(PAGE_SEPARATOR) && scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            pages.add(lines);
            scanner.nextLine();
        }
        currentPage = pages.first;
    }

    public void save(String address) throws IOException {
        FileWriter fileWriter = new FileWriter(address);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PageNode iterator = pages.first;
        while (iterator != null) {
            LineNode lineIterator = iterator.line.first;
            while (lineIterator != null) {
                bufferedWriter.write(lineIterator.str + "\n");

                lineIterator = lineIterator.next;
            }
            bufferedWriter.write("$\n");
            iterator = iterator.next;
        }
        bufferedWriter.close();
        fileWriter.close();

        // clear undo & redo stacks
        undo = new Stack();
        redo = new Stack();
    }

    public int where() {
        int pageNumber = 1;
        PageNode iterator = pages.first;
        while (iterator != null && iterator != currentPage) {
            iterator = iterator.next;
            pageNumber++;
        }
        return pageNumber;
    }

    public void nextPage() {
        currentPage = currentPage.next;

        if (!undoMode)
            undo.push(new String[]{"8"});
    }

    public void previousPage() {
        PageNode iterator = pages.first;
        while (iterator != null && iterator.next != null && iterator.next != currentPage) {
            iterator = iterator.next;
        }
        currentPage = iterator;

        if (!undoMode)
            undo.push(new String[]{"9"});
    }

    public int lines() {
        int numOfLines = 0;
        LineNode iterator = currentPage.line.first;
        while (iterator != null) {
            iterator = iterator.next;
            numOfLines++;
        }
        return numOfLines;
    }

    public void show(int n) {
        LineNode iterator = currentPage.line.first;
        while (iterator != null && n != 0) {
            System.out.println(iterator.str);
            iterator = iterator.next;
            n--;
        }
    }

    public void append(String s) {
        int lines = 0;
        Scanner scanner = new Scanner(s);
        while (scanner.hasNext()) {
            currentPage.line.add(scanner.nextLine());
            lines++;
        }

        if (!undoMode)
            undo.push(new String[]{"1", s, ""+lines});
    }

    public void insert(String s, int n) {
        if (n > lines() + 1)
            n = lines() + 1;
        else if (n < 1)
            n = 1;

        int tmpN = n;

        if (n == 1) {
            LineNode line = new LineNode();
            line.str = s;
            line.next = currentPage.line.first;
            currentPage.line.first = line;
            return;
        }

        LineNode iterator = currentPage.line.first;
        while (iterator != null && n != 2) { // we need previous line
            iterator = iterator.next;
            n--;
        }
        LineNode line = new LineNode();
        line.str = s;
        line.next = iterator.next;
        iterator.next = line;

        if (!undoMode)
            undo.push(new String[]{"2", tmpN + "", s});
    }

    public void remove(int n) {
        int tmpN = n;

        LineNode iterator = currentPage.line.first;

        if (n == 1) {
            if (!undoMode)
                undo.push(new String[]{"3", currentPage.line.first.str, tmpN + ""});

            currentPage.line.first = currentPage.line.first.next;
        } else {
            while (iterator != null && n != 2) { // we need previous line
                iterator = iterator.next;
                n--;
            }

            if (!undoMode)
                undo.push(new String[]{"3", iterator.next.str, tmpN + ""});

            iterator.next = iterator.next.next;
        }
    }

    public void replace(int n, String s) {
        int tmpN = n;

        LineNode iterator = currentPage.line.first;
        while (iterator != null && n != 1) {
            iterator = iterator.next;
            n--;
        }

        if (!undoMode)
            undo.push(new String[]{"4", tmpN + "", iterator.str, s});

        iterator.str = s;
    }

    public void swap(int n, int m) {
        int tmpN = n, tmpM = m;

        if (n == m || n > lines() || m > lines())
            return;

        LineNode firstLinePrev = currentPage.line.first;
        while (firstLinePrev != null && n > 2) { // we need previous line
            firstLinePrev = firstLinePrev.next;
            n--;
        }
        LineNode secondLinePrev = currentPage.line.first;
        while (secondLinePrev != null && m > 2) { // we need previous line
            secondLinePrev = secondLinePrev.next;
            m--;
        }

        if (n == 1) {
            String temp = currentPage.line.first.str;
            currentPage.line.first.str = secondLinePrev.next.str;
            secondLinePrev.next.str = temp;
            return;
        } else if (m == 1) {
            String temp = currentPage.line.first.str;
            currentPage.line.first.str = firstLinePrev.next.str;
            firstLinePrev.next.str = temp;
            return;
        }

        LineNode temp = firstLinePrev.next;
        firstLinePrev.next = secondLinePrev.next;
        secondLinePrev.next = temp;

        temp = firstLinePrev.next.next;
        firstLinePrev.next.next = secondLinePrev.next.next;
        secondLinePrev.next.next = temp;

        if (!undoMode)
            undo.push(new String[]{"5", tmpM + "", tmpN + ""});
    }

    public void find(String s) {
        PageNode pageIterator = pages.first;
        int pageNumber = 1;
        while (pageIterator != null) {
            LineNode lineIterator = pageIterator.line.first;
            int lineNumber = 1;
            while (lineIterator != null) {
                if (lineIterator.str.contains(s)) {
                    System.out.println(pageNumber + ") " + lineNumber + ". " + lineIterator.str);
                }

                lineIterator = lineIterator.next;
                lineNumber++;
            }
            pageIterator = pageIterator.next;
            pageNumber++;
        }
    }

    public void findAndReplace(String s, String t) {
        PageNode pageIterator = pages.first;
        while (pageIterator != null) {
            LineNode lineIterator = pageIterator.line.first;
            while (lineIterator != null) {
                lineIterator.str = lineIterator.str.replaceAll(s, t);

                lineIterator = lineIterator.next;
            }
            pageIterator = pageIterator.next;
        }

        if (!undoMode)
            undo.push(new String[]{"7", t, s});
    }

    public void undo() {
        String[] function = undo.pop();
        if (Integer.parseInt(function[0]) != 6)
            redo.push(function);

        switch (Integer.parseInt(function[0])) {
            case 1:
                undoMode = true;
                int lines = Integer.parseInt(function[2]);
                while (lines != 0) {
                    remove(lines());
                    lines--;
                }
                undoMode = false;
                break;
            case 2:
                undoMode = true;
                remove(Integer.parseInt(function[1]));
                undoMode = false;
                break;
            case 3:
                undoMode = true;
                insert(function[1], Integer.parseInt(function[2]));
                undoMode = false;
                break;
            case 4:
                undoMode = true;
                replace(Integer.parseInt(function[1]), function[2]);
                undoMode = false;
                break;
            case 5:
                undoMode = true;
                swap(Integer.parseInt(function[1]), Integer.parseInt(function[2]));
                undoMode = false;
                break;
            case 6:
                break;
            case 7:
                undoMode = true;
                findAndReplace(function[1], function[2]);
                undoMode = false;
                break;
            case 8:
                undoMode = true;
                previousPage();
                undoMode = false;
                break;
            case 9:
                undoMode = true;
                nextPage();
                undoMode = false;
                break;
        }
    }

    public void redo() {
        String[] function = redo.pop();

        switch (Integer.parseInt(function[0])) {
            case 1:
                append(function[1]);
                break;
            case 2:
                insert(function[2], Integer.parseInt(function[1]));
                break;
            case 3:
                remove(Integer.parseInt(function[2]));
                break;
            case 4:
                replace(Integer.parseInt(function[1]), function[3]);
                break;
            case 5:
                swap(Integer.parseInt(function[2]), Integer.parseInt(function[1]));
                break;
            case 6:
                break;
            case 7:
                findAndReplace(function[2], function[1]);
                break;
            case 8:
                nextPage();
                break;
            case 9:
                previousPage();
        }
    }
}