package storage;

import java.util.*;

public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T> {
    private Node<T> head;
    private int length;

    public SortedLinkedList() {
        // constructor body
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.getData()) < 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            Node<T> previous = null;

            while (current != null && data.compareTo(current.getData()) > 0) {
                previous = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            previous.setNext(newNode);
        }

        length++;
    }

    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> current = head;
        Node<T> previous = null;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        length--;
        return current.getData();
    }

    public void clear() {
        head = null;
        length = 0;
    }

    public T getEntry(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public int getPosition(T entry) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(entry)) {
                return index;
            }

            current = current.getNext();
            index++;
        }

        throw new IllegalArgumentException("Element not found in the list.");
    }

    public boolean contains(T entry) {
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(entry)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        // Node<T> current = head;

        // while (current != null) {
        //     System.out.print(current.getData() + " ");
        //     current = current.getNext();
        // }

        // System.out.println();
    }

    // @Override
    public Iterator<T> iterator() {
        return new SLLIterator(head);
    }

    private Node<T> getPrevious(T entry) {
        // Node<T> current = head;
        // Node<T> previous = null;

        // while (current != null && entry.compareTo(current.getData()) > 0) {
        //     previous = current;
        //     current = current.getNext();
        // }

        // return previous;
        return null;
    }

    // private class Node<T> {
    //     private T data;
    //     private Node<T> next;

    //     public Node(T data) {
    //         this.data = data;
    //         this.next = null;
    //     }

    //     public T getData() {
    //         return data;
    //     }

    //     public void setData(T data) {
    //         this.data = data;
    //     }

    //     public Node<T> getNext() {
    //         return next;
    //     }

    //     public void setNext(Node<T> next) {
    //         this.next = next;
    //     }
    // }

    private class SLLIterator implements Iterator<T> {
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;



        public SLLIterator(Node<T> firstNode) {
            firstNode = head;
        }

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = currNode.getData();
            // currNode = currNode.getNext();
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }

    
}



