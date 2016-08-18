package lrucache;

public class LRUCache {

    private CacheEntry first = null;
    private CacheEntry last = null;
    private final int capacity;
    private int used = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = (getEntry(key) == null ? -1 : getEntry(key).getValue());
        return value;
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        CacheEntry cacheEntry = getEntry(key);

        if (cacheEntry != null) {
            cacheEntry.setValue(value);
            return;
        }
        cacheEntry = new CacheEntry(key, value);
        cacheEntry.setPrevious(null);
        cacheEntry.setNext(first);
        if (used > 0) {
            first.setPrevious(cacheEntry);
        } else {
            last = cacheEntry;
        }
        first = cacheEntry;

        if (used == capacity) {
            if (last.hasPrevious()) {
                last.getPrevious().setNext(null);
                last = last.getPrevious();
            }
        } else {
            used++;
        }
    }

    /* *************** */
    /* PRIVATE METHODS */
    /* *************** */
    private void refresh(CacheEntry cacheEntry) {
        if (cacheEntry!=first) {
            if (cacheEntry.hasPrevious()) {
                cacheEntry.getPrevious().setNext(cacheEntry.getNext());
            }
            if (cacheEntry.hasNext()) {
                cacheEntry.getNext().setPrevious(cacheEntry.getPrevious());
            }
            if (used > 1) {
                if (cacheEntry==last && last.hasPrevious()) {
                    last = last.getPrevious();
                }
                cacheEntry.setNext(first);
                first.setPrevious(cacheEntry);
            }
            cacheEntry.setPrevious(null);
            first = cacheEntry;
        }
    }

    private CacheEntry getEntry(int key) {
        CacheEntry cacheEntry = null;
        if (used > 0) {
            do {
                if (cacheEntry == null) {
                    cacheEntry = first;
                } else {
                    cacheEntry = cacheEntry.getNext();
                }
                if (cacheEntry.getKey() == key) {
                    refresh(cacheEntry);
                    return cacheEntry;
                }

            } while (cacheEntry.hasNext());
        }
        return null;
    }

    /* ************************* */
    /* CACHE ENTRY PRIVATE CLASS */
    /* ************************* */
    private class CacheEntry {

        private final int key;
        private int value;
        private CacheEntry next = null;
        private CacheEntry previous = null;

        public CacheEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public CacheEntry getNext() {
            return next;
        }

        public void setNext(CacheEntry next) {
            this.next = next;
        }

        public CacheEntry getPrevious() {
            return previous;
        }

        public void setPrevious(CacheEntry previous) {
            this.previous = previous;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 67 * hash + this.key;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final CacheEntry other = (CacheEntry) obj;
            if (this.key != other.key) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "CacheEntry{" + "key=" + key + ", value=" + value + ", hasNext=" + hasNext() + ", hasPrevious=" + hasPrevious() + '}';
        }

    }
}
