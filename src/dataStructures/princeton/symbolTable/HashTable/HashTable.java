package dataStructures.princeton.symbolTable.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class HashTable {
    String key;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashTable)) return false;
        HashTable hashTable = (HashTable) o;
        return Objects.equals(key, hashTable.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
    }
}
