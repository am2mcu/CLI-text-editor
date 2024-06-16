public class Line {
    LineNode first;
    public void add(String str) {
        LineNode temp = new LineNode();
        temp.str = str;

        if (first == null) {
            first = temp;
        }
        else {
            LineNode current = first;

            while (current.next != null) {
                current = current.next;
            }

            current.next = temp;
        }
    }
}
