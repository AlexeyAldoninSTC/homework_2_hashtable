package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {

    MyHashTable myHashTable = new MyHashTable();

    @Test
    public void put() {
        myHashTable.put(10, 0);
        int actualSize1 = myHashTable.getSize();
        assertEquals(1, actualSize1);
        myHashTable.put(20, 0);
        int actualSize2 = myHashTable.getSize();
        assertEquals(2, actualSize2);
        myHashTable.put(10, 5);
        int actualSize3 = myHashTable.getSize();
        assertEquals(2, actualSize3);
        myHashTable = new MyHashTable();
        for (int i = 0; i < 100; i++) {
            myHashTable.put(i, i * 10);
        }
        assertEquals(100, myHashTable.getSize());
        assertEquals(10, myHashTable.getValue(1));
        for (int i = 0; i < 10000; i++) {
            myHashTable.put(i, i * 10);
        }
        assertEquals(10000, myHashTable.getSize());
        assertEquals(10, myHashTable.getValue(1));
    }

    @Test
    public void getValue() {
        myHashTable.put(10, 1);
        myHashTable.put(20, 2);
        Object actual = myHashTable.getValue(10);
        assertEquals(1, actual);
        assertNull(myHashTable.getValue(30));
    }

    @Test
    public void remove() {
        myHashTable.put(1, 10);
        assertEquals(1, myHashTable.getSize());
        assertEquals(10, myHashTable.getValue(1));
        assertFalse(myHashTable.remove(0));
        assertEquals(1, myHashTable.getSize());
        assertTrue(myHashTable.remove(1));
        assertEquals(0, myHashTable.getSize());
    }

    @Test
    public void containsKey() {
        myHashTable.put(1, 1);
        assertTrue(myHashTable.containsKey(1));
        assertFalse(myHashTable.containsKey(2));
    }

    @Test
    public void getSize() {
        assertEquals(0, myHashTable.getSize());
        myHashTable.put(1, 1);
        assertEquals(1,myHashTable.getSize());
    }
}