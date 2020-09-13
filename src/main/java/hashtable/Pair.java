package hashtable;

import java.util.Arrays;

public class Pair {

    private final Object[] pairKeyValue = new Object[2];

    Pair(Object key, Object value) {
        pairKeyValue[0] = key;
        pairKeyValue[1] = value;
    }

    void fillPair(Object key, Object value) {
        if (key.equals(pairKeyValue[0])) {
            pairKeyValue[1] = value;
            return;
        }
        pairKeyValue[0] = key;
        pairKeyValue[1] = value;
    }

    Object getKey() {
        return pairKeyValue[0];
    }
    Object getValue() {
        return pairKeyValue[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair1 = (Pair) o;
        return Arrays.equals(pairKeyValue, pair1.pairKeyValue);
    }

    @Override
    public int hashCode() {
        if (pairKeyValue[0] == null) {
            return 0;
        }
        return pairKeyValue[0].hashCode();
    }

    @Override
    public String toString() {
        return Arrays.toString(pairKeyValue);
    }
}
