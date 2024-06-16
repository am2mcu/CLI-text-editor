public class Stack {
    StackNode top;

    public Stack() {
        this.top = null;
    }

    void push(String[] data) {
        StackNode temp = new StackNode();
        temp.data = data;

        if (top != null) {
            temp.prev = top;
        }
        top = temp;
    }

    String[] pop() {
        if (isEmpty())
            return new String[]{"6"};

        String[] out = top.data;
        top = top.prev;
        return out;
    }

    boolean isEmpty() {
        return top == null;
    }
}
