// --== CS400 File Header Information ==--
// Name: Weijie Zhou
// Email: wzhou226@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: csLab username: weijie

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    private final int defaultInitialCapacity = 10;
    private final double loadFactor = 0.8;
    public int capacity;
    public int hashTableMapSize;
    private int threshold;
    private Entry[] table; //Hash table


    /**
    * @Description: This is a class created for storing each key-value pair
    * @Param: none
    * @return: none
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    static class Entry<KeyType, ValueType> {
        KeyType key;
        ValueType value;
        Entry<KeyType, ValueType> next;

        public Entry(KeyType k, ValueType v, Entry<KeyType, ValueType> next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }
    }


    public HashTableMap() {
        this.capacity = defaultInitialCapacity;
        this.hashTableMapSize = 0;
        this.threshold = (int) (capacity * loadFactor);
        table = new Entry[defaultInitialCapacity];
    }

    public HashTableMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.hashTableMapSize = 0;
        this.threshold = (int) (capacity * loadFactor);
        table = new Entry[initialCapacity];
    }

    /**
    * @Description: This is a function created for auto-organizing the capacity of array
    * @Param: [newTable]
    * @return: void
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    public void autoOrganize(Entry<KeyType, ValueType>[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry<KeyType, ValueType> entry = src[j];
            if (entry != null) {
                src[j] = null;
                do {
                    Entry<KeyType, ValueType> next = entry.next;
                    int index = findIndex(Math.abs(entry.key.hashCode()), newCapacity);
                    entry.next = newTable[index];
                    newTable[index] = entry;
                    entry = next;
                } while (entry != null);
            }
        }
        return;
    }

    /**
    * @Description: This is a function created for checking the threshold of the program and call the autoOrganize()
    * @Param: [newCapacity]
    * @return: void
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    private void resize(int newCapacity) {
        Entry<KeyType, ValueType>[] newTable = new Entry[newCapacity];
        autoOrganize(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
        return;
    }

    /**
    * @Description: This is a function created for finding the exact index of the Entry(key-value pair)
    * @Param: [hash, capacity]
    * @return: int
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    private int findIndex(int hash, int capacity) {
        return hash % capacity;
    }

    /**
    * @Description: This is a function created for adding an entry with key and value and checking if the function is performed
    * @Param: [key, value]
    * @return: boolean
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public boolean put(KeyType key, ValueType value) {
        //key cannot be null
        if (key == null) {
            return false;
        }

        int hash = Math.abs(key.hashCode()); //find hash value of key
        int index = findIndex(hash, capacity);
        Entry<KeyType, ValueType> element = table[index];

        //check if the key exist in hash table
        if(containsKey(key)) {
            return false;
        }

        if (element == null) {
            table[index] = new Entry<>(key, value, null);
        } else {
            table[index] = new Entry<>(key, value, element);
        }
        hashTableMapSize++;
        if (hashTableMapSize >= capacity * loadFactor) {
            resize(capacity * 2);
            this.capacity = capacity * 2;
        }
        return true;

    }

    /**
    * @Description: This is a function for getting the value of an entry by entered key
    * @Param: [key]
    * @return: ValueType
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        //key cannot be null;
        if (key == null) {
            throw new NoSuchElementException("key cannot be null");
        }

        int hash = Math.abs(key.hashCode());
        for (Entry<KeyType, ValueType> entry = table[findIndex(hash, table.length)]; entry != null; entry = entry.next) {
            Object k;
            if (Math.abs(entry.key.hashCode()) == hash && ((k = entry.key) == key || key.equals(k))) {
                return entry.value;
            }
        }
        throw new NoSuchElementException("Not found!");
    }


    /**
    * @Description: This is a function created for returning the size of the Entry array
    * @Param: []
    * @return: int
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public int size() {
        return hashTableMapSize;
    }

    /**
    * @Description: This is a function created for getting the whole Entry by entered key
    * @Param: [key]
    * @return: HashTableMap.Entry<KeyType,ValueType>
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    private Entry<KeyType, ValueType> getEntry(Object key) {
        int hash = Math.abs(key.hashCode());
        for (Entry<KeyType, ValueType> entry = table[findIndex(hash, table.length)]; entry != null; entry = entry.next) {
            Object k;
            if (Math.abs(entry.key.hashCode()) == hash && ((k = entry.key) == key || (key != null && key.equals(k)))) {
                return entry;
            }
        }
        return null;
    }


    /**
    * @Description: This is a function that checks if an array contains a key
    * @Param: [key]
    * @return: boolean
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public boolean containsKey(KeyType key) {
        if (key == null) {
            return true;
        }
        return getEntry(key) != null;
    }

    /**
    * @Description: This is a function created for doing the actual removement of entered key
    * @Param: [key]
    * @return: HashTableMap.Entry<KeyType,ValueType>
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    private Entry<KeyType, ValueType> removeEntry(Object key) {
        int hash = (key == null) ? 0 : Math.abs(key.hashCode());
        int index = findIndex(hash, table.length);
        Entry<KeyType, ValueType> prev = table[index];
        Entry<KeyType,ValueType> entry = prev;

        while (entry != null) {
            Entry<KeyType,ValueType> next = entry.next;
            Object k;
            if (Math.abs(entry.key.hashCode()) == hash && ((k = entry.key) == key || (key != null && key.equals(k)))) {
                hashTableMapSize--;
                if (prev == entry)
                    table[index] = next;
                else
                    prev.next = next;
                return entry;
            }
            prev = entry;
            entry = next;
        }

        return entry;
    }

    /**
    * @Description: This is a function created for removing a certain entry in terms of entering key by calling the real remove function(removeEntry)
    * @Param: [key]
    * @return: ValueType
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public ValueType remove(KeyType key) {
        if (key == null) {
            System.exit(-1);
        }
        Entry<KeyType, ValueType> entry = removeEntry(key);
        return (entry == null ? null : entry.value);
    }

    /**
    * @Description: This is a function created for clearing the whole Entry array
    * @Param: []
    * @return: void
    * @Author: Weijie Zhou
    * @Date: 2020/9/20
    */
    @Override
    public void clear() {
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        hashTableMapSize = 0;
    }
}
