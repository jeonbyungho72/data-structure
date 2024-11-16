package learn.list;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}

public class LinearLinkedList<T> {

    private Node<T> root;
    private int size = 0;
    private boolean changeSize;

    public int getSize() {
        if (!this.changeSize) {
            return this.size;
        }

        int size = 0;
        Node<T> countNode = this.root;

        if (countNode == null)
            return 0;

        while (countNode.getNext() != null) {
            countNode = countNode.getNext();
            size++;
        }

        this.size = size;
        changeSize = false;
        return this.size;
    }

    public void insert(T data) {
        Node<T> currentNode = this.root;
        Node<T> newNode = new Node<T>(data);

        if (currentNode == null) {
            this.root = newNode;
            size++;
            return;
        }

        while (currentNode.getNext() != null)
            currentNode = currentNode.getNext();
        currentNode.setNext(newNode);
        size++;
    }

    public void insert(T data, int index) {
        Node<T> prevNode = this.root;
        Node<T> newNode = new Node<T>(data);
        if (prevNode == null || index > getSize() - 1)
            throw new RuntimeException();

        if (index == 0) {
            newNode.setNext(prevNode);
            this.root = newNode;
            changeSize = true;
            return;
        }

        for (int i = 1; i < index; i++)
            prevNode = prevNode.getNext();

        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
        changeSize = true;

    }

    public T get(int index) {
        Node<T> searchNode = this.root;

        if (searchNode == null || index > getSize() - 1)
            return null;

        for (int i = 0; i < index; i++)
            searchNode = searchNode.getNext();

        return searchNode.getData();
    }

    public T search(T data) {
        Node<T> searchNode = this.root;

        if (searchNode == null)
            return null;

        do {
            T searchData = searchNode.getData();

            if (searchData.equals(data))
                return searchData;

            searchNode = searchNode.getNext();
        } while (searchNode != null);

        return null;
    }

    public int index(T data) {
        int index = 0;
        Node<T> searchNode = this.root;

        if (searchNode == null)
            return -1;

        do {
            T searchData = searchNode.getData();

            if (searchData.equals(data))
                return index;

            searchNode = searchNode.getNext();
            index++;
        } while (searchNode != null);

        return -1;
    }

    public void remove(int index) {
        Node<T> prevNode = this.root;

        if (prevNode == null || index > getSize() - 1)
            throw new RuntimeException();

        if (index == 0) {
            this.root = prevNode.getNext();
            changeSize = true;
            return;
        }

        for (int i = 1; i < index; i++)
            prevNode = prevNode.getNext();

        Node<T> beyondNode = prevNode.getNext().getNext();
        prevNode.setNext(beyondNode);
        changeSize = true;
    }

    public void remove() {
        remove(getSize() - 1);
    }

    public void clear() {
        this.root = null;
        this.changeSize = true;
    }
}
