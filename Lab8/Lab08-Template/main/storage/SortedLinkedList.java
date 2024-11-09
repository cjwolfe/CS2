package storage;

import java.util.*;

public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T> {
    private Node<T> head;
    private int length;
    

    public SortedLinkedList() {
        head = null;
        length = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.getData()) < 0) {
            newNode.setLink(head);
            head = newNode;
        } else {
            Node<T> current = head;
            Node<T> previous = null;

            while (current != null && data.compareTo(current.getData()) > 0) {
                previous = current;
                current = current.getLink();
            }

            newNode.setLink(current);
            previous.setLink(newNode);
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
            current = current.getLink();
        }

        if (previous == null) {
            head = current.getLink();
        } else {
            previous.setLink(current.getLink());
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
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            T removedData = head.getData();
            head = head.getLink();
            length--;
            return removedData;
        }

        Node<T> previous = getNodeAtIndex(index - 1);
        Node<T> current = previous.getLink();
        T removedData = current.getData();
        previous.setLink(current.getLink());
        length--;
        return removedData;

    }

    public int getPosition(T entry) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(entry)) {
                return index;
            }

            // current = current.getNext();
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

            // current = current.getNext();
        }

        return false;
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getLink();
        }

        return current;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        Node<T> current = head;

        // while (current != null) {
        //     System.out.print(current.getData() + " ");
        //     current = current.getNext();
        // }

        // System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new SLLIterator(head);
    }


    private Node<T> getPrevious(T entry) {
        Node<T> current = head;
        Node<T> previous = null;
    
        while (current != null && entry.compareTo(current.getData()) > 0) {
            previous = current;
            current = current.getLink();
        }
    
        return previous;
        //return null;
    }

    private class SLLIterator implements Iterator<T> {
        private boolean calledNext = false;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        public SLLIterator(Node<T> firstNode) {
            this.currNode = firstNode;
            this.nextNode = firstNode != null ? firstNode.getLink() : null;
            this.calledNext = false;
            this.prevNode = null;
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
            prevNode = currNode;
            currNode = currNode.getLink();
            calledNext = true;
            return data;
        }

        @Override
        public void remove() {
            if (!calledNext) {
                throw new IllegalStateException("remove() called without a previous call to next()");
            }

            if (prevNode == null) {
                // Removing the first node
                head = currNode.getLink();
            } else {
                prevNode.setLink(currNode.getLink());
            }

            currNode = prevNode;
            calledNext = false;
            length--;
        }
    }
    

    
}



