import java.util.*;

public class ArrayMap<K,V> {

    public class ArrayMapEntry<K,V> implements Map.Entry<K,V> {

        private K key;
        private V value;
        //Map.Entry<K,V> maps;
        ArrayMapEntry(K key){
            this.key = key;
        }
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
            this.value = (V)value;
            return value;
        }

        public String toString()
        {
            String s = "";
            s = s + this.getKey() + " " + this.getValue();
            return s;
        }

        public boolean equals(Object o)
        {
            ArrayMapEntry<K,V> e2 = (ArrayMapEntry<K, V>)o;
            ArrayMapEntry<K,V> e1 = this;

            if((e1.getKey()==null ?
                    e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &&
                    (e1.getValue()==null ?
                            e2.getValue()==null : e1.getValue().equals(e2.getValue())))
                return true;
            return false;
        }

        public int hashCode() {
            return (this.getKey()==null   ? 0 : this.getKey().hashCode()) ^
                    (this.getValue()==null ? 0 : this.getValue().hashCode());
        }
    }

    ArrayList<ArrayMapEntry<K,V>> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public V put(K key, V value)
    {
        ArrayMapEntry<K,V> elem = new ArrayMapEntry<K,V>(key);
        elem.setValue(value);
        for (int i = 0; i < list.size();i++){
            if(list.get(i).equals(elem)) {
                list.get(i).setValue(value);
                return value;
            }
        }
        list.add(elem);
        return value;
    }

    public boolean containsKey(Object key)
    {
        for (ArrayMapEntry elem:list) {
            if(elem.getKey() == (K)key)
            {
                return true;
            }
        }
        return false;
    }

    public V get(Object key)
    {
        if(!this.containsKey(key))
            return null;
        for (ArrayMapEntry elem: list) {
            if(elem.getKey() == (K)key)
            {
                return (V)elem.getValue();
            }
        }
        return null;
    }


    public Set<Map.Entry<K,V>> entrySet()
    {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        entries.addAll(list);
        return entries;
    }

}
