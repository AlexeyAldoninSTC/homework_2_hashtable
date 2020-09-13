package hashtable;

import java.util.Objects;

public class MyLinkedList {
    private int size;
    private ListNode firstNode;
    private ListNode lastNode;

    public int getSize() {
        return size;
    }

    public ListNode getFirstNode() {
        return firstNode;
    }

    public ListNode getLastNode() {
        return lastNode;
    }

    /**
     * Method to put new Object in the end of the list
     * @param value - Object value to be inserted
     */
    public void put(Object value) {
        if (firstNode == null) {
            firstNode = new ListNode(value);
            lastNode = firstNode;
            size++;
            return;
        }
        lastNode.next = new ListNode(value, lastNode);
        lastNode = lastNode.next;
        size++;
    }

    /**
     * Method to search value via its index position.
     * If index exceeds list half size, search runs from its last node
     * @param index - index number of position
     * @return - value of node with required index
     */
    public Object get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index value exceeds list size");
        }
        ListNode temp;
        int counter = 0;
        if (size / 2 >= index) {
            temp = firstNode;
            while (counter < index) {
                temp = temp.next;
                counter++;
            }
        } else {
            temp = lastNode;
            counter = size - 1;
            while (counter > index) {
                temp = temp.previous;
                counter--;
            }
        }
        return temp.value;
    }

    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        ListNode node = firstNode;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(value)){
                if (i == 0) {
                    if (node.next != null) {
                        firstNode = node.next;
                        firstNode.previous = null;
                    } else {
                        firstNode = null;
                    }
                    size--;
                    if (size == 0) {
                        firstNode = null;
                        lastNode = null;
                    }
                    return true;
                }
                if (lastNode != null && lastNode.value.equals(value)) {
                    lastNode = null;
                    size--;
                    return true;
                }
                node.previous.next = node.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    boolean contains(Object value) {
        if (size == 0) {
            return false;
        }
        ListNode tempNode = firstNode;
        while (tempNode != null) {
            Pair pair = (Pair) tempNode.value;
            if (pair.getKey().equals(value)){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList that = (MyLinkedList) o;
        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (this.get(i) != that.get(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (size == 0) return 0;
        int result = 1;
        if (firstNode != null) {
            ListNode temp = firstNode;
            while (temp.next != null) {
                result = 31 * result + temp.hashCode();
                temp = temp.next;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (firstNode != null) {
            ListNode temp = firstNode;
            builder.append(temp.value).append(", ");
            while (temp.next != null) {
                temp = temp.next;
                builder.append(temp.value).append(", ");
            }
        }
        if (builder.length() >= 2) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.toString();
    }

    class ListNode {

        private Object value;
        private ListNode previous;
        private ListNode next;

        public ListNode(Object value) {
            this.value = value;
            previous = null;
            next = null;
        }

        public ListNode(Object value, ListNode previous) {
            this.value = value;
            this.previous = previous;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ListNode that = (ListNode) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
