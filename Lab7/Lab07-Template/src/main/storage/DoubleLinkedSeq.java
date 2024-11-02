package storage;

public class DoubleLinkedSeq implements Cloneable{

    private int manyNodes;
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode precursor;
    private DoubleNode cursor;


    public DoubleLinkedSeq() {
        manyNodes = 0;
        head = null;
        tail = null;
        precursor = null;
        cursor = null;

    }

    public int size()
    {
        return manyNodes;

    }
    public void addAfter(double data)
    {
        DoubleNode newNode = new DoubleNode(data, null);
    
        if (cursor != null) {
            newNode.setLink(cursor.getLink());
            cursor.setLink(newNode);
            cursor = newNode;
            if (cursor.getLink() == null) {
                tail = cursor;
            }
        } else {
            // If cursor is null, insert at the end
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setLink(newNode);
                tail = newNode;
            }
            cursor = newNode;
            tail = newNode; // Update the tail
        }
    
        manyNodes++;
    }
    
    public void addBefore(double data) 
    {
        DoubleNode newNode = new DoubleNode(data, null);
    
    if (cursor != null) {
        if (cursor == head) {
            // Insert at the head
            newNode.setLink(head);
            head = newNode;
        } else {
            // Insert before the cursor
            DoubleNode temp = head;
            while (temp.getLink() != cursor) {
                temp = temp.getLink();
            }
            newNode.setLink(cursor);
            temp.setLink(newNode);
        }
        cursor = newNode;
    } else {
        // If cursor is null, insert at the head
        newNode.setLink(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        cursor = newNode;
    }
    
    manyNodes++;
}

    public void addAll(DoubleLinkedSeq addend)
    {
        if (addend == null) {
            throw new NullPointerException("addend cannot be null");
        }

        if (addend.manyNodes == 0) {
            return; // Nothing to add
        }
        // Check if the addend is the same as the current sequence
        if (this == addend) {
            // Create a copy of the addend to avoid infinite loop
            addend = addend.clone();
        }

        DoubleNode originalCursor = cursor;
        DoubleNode originalPrecursor = precursor;

        // If the current sequence is empty, just copy the addend sequence
        if (head == null) {
            head = addend.head;
            tail = addend.tail;
            cursor = head;
        } else {
            // Append addend at the end of the current sequence
            tail.setLink(addend.head);
            tail = addend.tail;
        }

        // Update the number of nodes
        manyNodes += addend.manyNodes;
    }

    public boolean isCurrent()
    {
        return cursor != null;
    }
    

    public void start()
    {
        cursor = head;
    }

    public void advance()
    {
        if (cursor == null) {
            throw new IllegalStateException("No cursor element exists.");
        }
        
        precursor = cursor;
        cursor = cursor.getLink();
    }

    public double getCurrent()
    {
        if (cursor == null)
        {
            throw new IllegalStateException("The cursor is null.");
        }
    
        return cursor.getData();
    
    }

    public void removeCurrent()
    {
        if (cursor == null) {
            throw new IllegalStateException("No cursor element exists.");
        }
        
        if (cursor == head) {
            head = cursor.getLink();
            if (head == null) {
                tail = null;
            }
        } else {
            precursor.setLink(cursor.getLink());
            if (cursor.getLink() == null) {
                tail = precursor; // Cursor was at the tail
            }
        }
                      
        cursor = cursor.getLink();
        manyNodes--;
    }


    @Override
    public DoubleLinkedSeq clone()
    {
        DoubleLinkedSeq clone = new DoubleLinkedSeq();
        if (head == null) {
            return clone; // Return an empty clone if the original sequence is empty
        }

        clone.manyNodes = manyNodes;

        // Clone the head node
        clone.head = new DoubleNode(head.getData());
        DoubleNode current = head.getLink();
        DoubleNode cloneCurrent = clone.head;

        // Clone the rest of the nodes
        while (current != null) {
            DoubleNode newNode = new DoubleNode(current.getData());
            cloneCurrent.setLink(newNode);
            cloneCurrent = newNode;
            current = current.getLink();
        }
        clone.tail = cloneCurrent;

        // Set the cursor and precursor in the clone
        if (cursor != null) {
            current = head;
            cloneCurrent = clone.head;
            while (current != cursor) {
                current = current.getLink();
                cloneCurrent = cloneCurrent.getLink();
            }
            clone.cursor = cloneCurrent;

            // Set the precursor in the clone
            if (precursor != null) {
                current = head;
                cloneCurrent = clone.head;
                while (current != precursor) {
                    current = current.getLink();
                    cloneCurrent = cloneCurrent.getLink();
                }
                clone.precursor = cloneCurrent;
            }
        }

        return clone;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        DoubleNode current = head;
        while (current != null) {
            if (current == cursor) {
                sb.append("[");
                sb.append(current.getData());
                sb.append("]");
            } else {
                sb.append(current.getData());
            }
            if (current.getLink() != null) {
                sb.append(", ");
            }
            current = current.getLink();
        }
        sb.append(">");
        
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DoubleLinkedSeq other = (DoubleLinkedSeq) obj;
        if (this.manyNodes != other.manyNodes) {
            return false;
        }
        DoubleNode thisNode = this.head;
        DoubleNode otherNode = other.head;
        while (thisNode != null) {
            if (Double.compare(thisNode.getData(), otherNode.getData()) != 0) {
                return false;
            }
            thisNode = thisNode.getLink();
            otherNode = otherNode.getLink();
        }
        // Check if the cursor positions are the same
        if (this.cursor == null && other.cursor != null) {
            return false;
        }
        if (this.cursor != null && other.cursor == null) {
            return false;
        }
        if (this.cursor != null && other.cursor != null) {
            if (Double.compare(this.cursor.getData(), other.cursor.getData()) != 0) {
                return false;
            }
        }
        return true;
    }
        
    
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
    {
        if (s1 == null || s2 == null) {
            throw new NullPointerException("One or both of the sequences are null.");
        }

        DoubleLinkedSeq result = new DoubleLinkedSeq();

        // Traverse the first sequence and add each element to the result
        DoubleNode current = s1.head;
        while (current != null) {
            result.addAfter(current.getData());
            current = current.getLink();
        }

        // Traverse the second sequence and add each element to the result
        current = s2.head;
        while (current != null) {
            result.addAfter(current.getData());
            current = current.getLink();
        }

        // Ensure the new sequence has no current element
        result.cursor = null;
        result.precursor = null;

        return result;
    }

}