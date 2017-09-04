package datastruct;

/**
 * Created by mercop on 2017/9/3.
 */
public class Triple<K,V,T>{

    public K first;
    public V secend;
    public T third;
    Triple(K first,V secend,T third){
        this.first = first;
        this.secend = secend;
        this.third = third;
    }
}