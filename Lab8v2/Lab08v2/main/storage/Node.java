package storage;


public class Node<T> {
    private T data;
    private Node<T> link;


    public Node(T data, Node<T> link) {
        this.data = data;
        this.link = link;
    }


    public Node(T data) {
        this.data = data;
        this.link = null;
    }
    

    public Node(String param1, String param2, boolean param3, boolean param4, boolean param5, String[] param6) {
        // constructor implementation
        this.data = null;
        this.link = null;
    }


    public Node() {
        this.data = null;
        this.link = null;
    }


    public Node<T> getLink() {
        return link;
    }


    public T getData() {
        return data;
    }


    public void setLink(Node<T> link) {
        this.link = link;
    }


    public void setData(T data) {
        this.data = data;
    }
}
