import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *  A simple mapping from string names to string values backed by an array.
 *  Supports only A-Z for the first character of the key name. Values can be
 *  any valid string.
 *
 *  @author You
 */
public class SimpleNameMap implements Map61BL<String, String> {


    LinkedList<Entry>[] buckets;
    int bucketsSize;

    private class SimpleNameMapIterator implements Iterator<Entry> {

        int currentBucket;
        int currentIndex;
        LinkedList<Entry>[] trackedBuckets = buckets;

        public SimpleNameMapIterator() {
            this.trackedBuckets = buckets;
            this.currentBucket = 0;
            this.currentIndex = 0;
        }

        public Entry next() {
            if (this.currentBucket == this.trackedBuckets.length) {
                throw new NoSuchElementException();
            } else if (this.trackedBuckets[currentBucket].size() == this.currentIndex) {
                this.currentBucket++;
                this.currentIndex = 0;
                return this.next();
            } else {
                return this.trackedBuckets[this.currentBucket].get(this.currentIndex);
            }
        }

        public boolean hasNext() {
            return this.currentBucket < this.trackedBuckets.length
                    && this.currentIndex < this.trackedBuckets[this.currentBucket].size();
        }
    }

    public Iterator iterator() {

        return new SimpleNameMapIterator();
    }

    public SimpleNameMap() {
        this.buckets = new LinkedList[10];
    }

    /** A wrapper class for holding each (KEY, VALUE) pair. */
    private static class Entry {


        /** The key used for lookup. */
        private String _key;
        /** The associated value. */
        private String _value;

        /** Create a new (KEY, VALUE) pair. */
        public Entry(String key, String value) {
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
        this.buckets = new LinkedList[10];
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(String key) {
        LinkedList<Entry> bucket = this.buckets[(key.hashCode() % 10) & 0x7FFFFFFF];
        for (Entry entry : bucket) {
            if (entry._key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String get(String key) {
        LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF) % 10];
        for (Entry entry : bucket) {
            if (entry._key.equals(key)) {
                return entry._value;
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        if (!this.containsKey(key)) {
            LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF) % 10];
            bucket.add(new Entry(key, value));
        }
    }

    @Override
    public String remove(String key) {
        if (this.containsKey(key)) {
            LinkedList<Entry> bucket = this.buckets[(key.hashCode() & 0x7FFFFFFF)
                    % 10];
            for (Entry entry : bucket) {
                if (entry._key.equals(key)) {
                    bucket.remove(entry);
                    return entry._value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<Entry> bucket : this.buckets) {
            size += bucket.size();
        }
        return size;
    }

    @Override
    public boolean remove(String key, String value) {
        throw new UnsupportedOperationException();
    }

    public void resize() {
        LinkedList<Entry>[] newBuckets = new LinkedList[this.bucketsSize * 2];

    }

    /** Returns true if the given KEY is a valid name that starts with A-Z. */
    private static boolean isValidName(String key) {
        return 'A' <= key.charAt(0) && key.charAt(0) <= 'Z';
    }


}