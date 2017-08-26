package datastruct;

/**
 * Created by mercop on 2017/8/23.
 * 二元组
 */
public class Pair<K,V> {
    private K key;
    public K getKey() {
        return key;
    }
    private V value;
    public V getValue() {
        return value;
    }
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
