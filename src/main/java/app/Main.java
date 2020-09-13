package app;

import com.sun.xml.internal.ws.encoding.ImageDataContentHandler;
import hashtable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put(10, 0);
        myHashTable.put(20, 6);
        myHashTable.put(10, 5);
        System.out.println("myHashTable.getSize() = " + myHashTable.getSize());
        System.out.println("myHashTable = " + myHashTable);
        System.out.println("myHashTable.getValue(20) = " + myHashTable.getValue(20));
        System.out.println("myHashTable.containsKey(10) = " + myHashTable.containsKey(10));
        System.out.println("myHashTable.containsKey(20) = " + myHashTable.containsKey(20));
        System.out.println("myHashTable.containsKey(5) = " + myHashTable.containsKey(5));
        System.out.println("myHashTable.remove(5) = " + myHashTable.remove(5));
        System.out.println("myHashTable.getSize() = " + myHashTable.getSize());
        System.out.println("myHashTable.remove(10) = " + myHashTable.remove(10));
        System.out.println("myHashTable.getSize() = " + myHashTable.getSize());
        System.out.println("myHashTable.toString() = " + myHashTable.toString());
        System.out.println("myHashTable.remove(20) = " + myHashTable.remove(20));
        System.out.println("myHashTable.getSize() = " + myHashTable.getSize());
        System.out.println("myHashTable.remove(10) = " + myHashTable.remove(10));
        System.out.println("myHashTable.getSize() = " + myHashTable.getSize());
        System.out.println("myHashTable.remove(5) = " + myHashTable.remove(5));
        System.out.println("myHashTable = " + myHashTable);
    }
}
