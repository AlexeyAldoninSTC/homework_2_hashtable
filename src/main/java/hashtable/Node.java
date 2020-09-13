package hashtable;

import java.util.Objects;

public class Node implements Comparable{

    private MyLinkedList pairList;

    Node() {
        pairList = new MyLinkedList();
    }

    Node(MyLinkedList linkedList) {
        this.pairList = linkedList;
    }

    int addPairToPairList(Pair pair) {
        if (pairList.getSize() == 0) {
            pairList.put(pair);
            return 1;
        }
        for (int i = 0; i < pairList.getSize(); i++) {
            Pair temp = (Pair) pairList.get(i);
            if (pair.getKey().equals(temp.getKey())){
                temp.fillPair(pair.getKey(), pair.getValue());
                return 0;
            }
        }
        pairList.put(pair);
        return 1;
    }

    MyLinkedList getPairList() {
        return pairList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(pairList, node.pairList);
    }

    @Override
    public int hashCode() {
        if (pairList.getSize() == 0) {
            return 0;
        }
        return pairList.get(0).hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return pairList.toString();
    }
}
