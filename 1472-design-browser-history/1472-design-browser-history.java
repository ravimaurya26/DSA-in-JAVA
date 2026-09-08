class BrowserHistory {

    class Node {
        String val;
        Node back;
        Node forward;

        Node(String val) {
            this.val = val;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);

        // Connect current page to new page
        current.forward = newNode;
        newNode.back = current;

        // Move to new page
        current = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && current.back != null) {
            current = current.back;
            steps--;
        }

        return current.val;
    }

    public String forward(int steps) {
        while (steps > 0 && current.forward != null) {
            current = current.forward;
            steps--;
        }

        return current.val;
    }
}