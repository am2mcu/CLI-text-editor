public class Page {
    PageNode first;
    public void add(Line line) {
        PageNode temp = new PageNode();
        temp.line = line;

        if (first == null) {
            first = temp;
        }
        else {
            PageNode current = first;

            while (current.next != null) {
                current = current.next;
            }

            current.next = temp;
        }
    }
}
