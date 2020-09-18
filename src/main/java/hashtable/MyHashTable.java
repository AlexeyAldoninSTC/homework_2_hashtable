package hashtable;

import java.util.Arrays;
import java.util.Objects;

public class MyHashTable {

    Node[] nodes = new Node[16];
    private int fillFactor = 0;
    private int size = 0;
    double loadRange = (double) 3 / 4;

    /**
     * Method to put certain key and value into the map
     *
     * @param key   - unique key
     * @param value - value, associated with key
     */
    public void put(Object key, Object value) {
        Pair input = new Pair(key, value);
        int targetIndex = indexFor(key.hashCode(), nodes.length);
        if (nodes[targetIndex] == null) {
            nodes[targetIndex] = new Node();
        }
        if (nodes[targetIndex].hashCode() != input.hashCode() && nodes[targetIndex].hashCode() == 0) {
            nodes[targetIndex].getPairList().put(input);
            fillFactor++;
            size++;
            ensureNodesCapacity();
            return;
        }
        if (nodes[targetIndex].hashCode() == input.hashCode() &&
                nodes[targetIndex].addPairToPairList(input)) {
            size++;
        }
    }

    /**
     * Method to get value by curtain key
     *
     * @param key - key to search by
     * @return Value if key match found or "null" if not
     */
    public Object getValue(Object key) {
        if (size == 0) {
            return null;
        }
        int targetIndex = indexFor(key.hashCode(), nodes.length);
        if (nodes[targetIndex] != null &&
                nodes[targetIndex].hashCode() == key.hashCode()) {
            for (int j = 0; j < nodes[targetIndex].getPairList().getSize(); j++) {
                Pair pair = (Pair) nodes[targetIndex].getPairList().get(j);
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    private void ensureNodesCapacity() {
        if ((double) fillFactor / nodes.length >= loadRange) {
            Node[] result = new Node[nodes.length << 1];
            for (Node node : nodes) {
                if (node != null) {
                    result[indexFor(node.hashCode(), result.length)] = node;
                }
            }
            nodes = result;
        }
    }

    /**
     * Method to delete the pair matching curtain value
     *
     * @param key - key for the pair to be deleted
     * @return - true returned if deleted successfully
     */
    public boolean remove(Object key) {
        if (size == 0) {
            return false;
        }
        int targetIndex = indexFor(key.hashCode(), nodes.length);
        if (nodes[targetIndex] != null &&
                nodes[targetIndex].hashCode() == key.hashCode()) {
            for (int j = 0; j < nodes[targetIndex].getPairList().getSize(); j++) {
                Pair pair = (Pair) nodes[targetIndex].getPairList().get(j);
                if (pair.getKey().equals(key)) {
                    nodes[targetIndex].getPairList().delete(pair);
                    if (nodes[targetIndex].getPairList().getSize() == 0) {
                        nodes[targetIndex] = null;
                        fillFactor--;
                    }
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to check if currant table contains curtain key
     *
     * @param key - key to search
     * @return - true returned if key was found
     */
    public boolean containsKey(Object key) {
        int targetIndex = indexFor(key.hashCode(), nodes.length);
        return nodes[targetIndex] != null &&
                nodes[targetIndex].getPairList().contains(key);
    }

    public int getSize() {
        return size;
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashTable that = (MyHashTable) o;
        return size == that.size &&
                Arrays.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(nodes);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (Node node : nodes) {
            if (node != null) {
                builder.append(node).append(',');
            }
        }
        while (builder.charAt(builder.length() - 1) == ',') {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(']');
        return builder.toString();
    }
}
