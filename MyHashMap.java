import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> extends AbstractMap<K, V> {

    private Set<MyEntry<K, V>> myEntrySet;

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public Set<MyEntry<K, V>> myEntrySet() {
        return myEntrySet == null ? (this.myEntrySet = new HashSet<>()) : myEntrySet;
    }

    @Override
    public V put(K key, V value) {
        MyEntry<K, V> myEntry = new MyEntry<>(key, value);
        if (myEntrySet == null) {
            this.myEntrySet = new HashSet<>();
        }
        myEntrySet.add(myEntry);
        return value;
    }

    @Override
    public V get(Object key) {
        if (myEntrySet == null) {
            return null;
        }
        Iterator<MyEntry<K, V>> i = this.myEntrySet().iterator();
        MyEntry<K, V> e;
        if (key == null) {
            while (i.hasNext()) {
                e = i.next();
                if (e == null) {
                    return e.getValue();
                }
            }
        } else {
            while (i.hasNext()) {
                e = i.next();
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        }
        return null;
    }

    public static class MyEntry<K, V> implements Entry<K, V> {

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K key;
        private V value;

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }
}
