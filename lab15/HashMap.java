
/**
 * Part of lab15
 * Created by Ray on 7/20/2017.
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Map61BL<K, V> {


    LinkedList<Entry>[] buckets;
    int bucketsSize;
    float loadFactor;
    int size;

    public int capacity() {
        return this.bucketsSize;
    }

    /** Create a new hash map with a default array of size 16 and load factor of 0.75. */
    HashMap() {
        this(16, 0.75f);
    }

    /** Create a new hash map with an array of size INITIALCAPACITY and default load factor of 0.75. */
    HashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    /** Create a new hash map with INITIALCAPACITY and LOADFACTOR. */

    HashMap(int capacity, float factor) {
        this.bucketsSize = capacity;
        this.loadFactor = factor;
        this.size = 0;
        this.buckets = new LinkedList[this.bucketsSize];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private class HashMapIterator implements Iterator<K> {

        int currentBucket;
        int currentIndex;
        LinkedList<Entry>[] trackedBuckets = buckets;

        public HashMapIterator() {
            this.trackedBuckets = buckets;
            this.currentBucket = 0;
            this.currentIndex = 0;
        }

        public K next() {

            if (currentIndex == capacity()) {
                throw new NoSuchElementException();
            } else if (currentIndex == trackedBuckets[currentBucket].size()) {
                currentIndex = 0;
                currentBucket++;
                System.out.println(trackedBuckets[currentBucket]);
                return this.next();
            } else {
                K toReturn = (K) trackedBuckets[currentBucket].get(currentIndex)._key;
                currentIndex++;
                //System.out.println("return " + toReturn.toString());
                return toReturn;
            }
        }

        public boolean hasNext() {
            return this.currentBucket +  2 < this.trackedBuckets.length;
        }
    }

    public Iterator<K> iterator() {

        return new HashMapIterator();
    }

    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry<K, V> {


        /** The key used for lookup. */
        private K _key;
        /** The associated value. */
        private V _value;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(K key, V value) {
            _key = key;
            _value = value;
        }

        /** Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return _key.equals(other._key);
        }

        /** Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry &&
                    _key.equals(((Entry) other)._key) &&
                    _value.equals(((Entry) other)._value));
        }

    }

    @Override
    public void clear() {
        this.size = 0;
        this.buckets = new LinkedList[this.bucketsSize];
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF) % this.bucketsSize];
        if (bucket == null) {
            return false;
        }
        for (Entry entry : bucket) {
            if (entry._key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public V get(K key) {
        LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF) % this.bucketsSize];
        for (Entry entry : bucket) {
            if (entry._key.equals(key)) {
                return (V) entry._value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {


        int counter = (key.hashCode() & 0x7FFFFFFF) % this.bucketsSize;

        double resizefactor = ((this.size+1)*1.0)/this.capacity();



        if (this.buckets[counter] != null){
            if (this.loadFactor < (resizefactor)) {
                this.resize();

            }
            if (this.containsKey(key)) {
                this.remove(key);

            }

            this.size++;
            LinkedList<Entry> newbucket = new LinkedList<>();
            newbucket.add(new Entry(key, value));
            counter = (key.hashCode() & 0x7FFFFFFF) % this.bucketsSize;
            this.buckets[counter]= newbucket;
        }


    }

    @Override
    public V remove(K key) {
        if (this.containsKey(key)) {
            LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF)
                    % this.bucketsSize];
            for (Entry entry : bucket) {
                if (entry._key.equals(key)) {
                    bucket.remove(entry);
                    this.size--;
                    return (V) entry._value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public void resize() {
        LinkedList<Entry>[] oldbuckets = new LinkedList[this.bucketsSize];
        for(int i = 0; i < bucketsSize; i ++) {
            if (this.buckets[i] == null) {
                oldbuckets[i] = null;
            } oldbuckets[i] = this.buckets[i];
        }

        bucketsSize *= 2;
        this.buckets = new LinkedList[capacity()];
        for (LinkedList<Entry> bucket : oldbuckets) {
            if (bucket != null) {
                for (Entry<K,V> singleEntry : bucket) {
                    this.put(singleEntry._key, singleEntry._value);
                }
            }

        }


    }

    /** Returns true if the given KEY is a valid name that starts with A-Z. */
    private static boolean isValidName(String key) {
        return 'A' <= key.charAt(0) && key.charAt(0) <= 'Z';
    }
    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap<String, String>(2);
        h.put("key", "value");
        h.put("key2", "value2");
        h.put("key3", "value3");
        for (String name : h) {
            System.out.println("contains " + name);
        }
    }
}