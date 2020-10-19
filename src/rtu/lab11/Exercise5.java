package rtu.lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Exercise5 {
    @SafeVarargs
    public final <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, elements);

        return arrayList;
    }

    @SafeVarargs
    public final <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();
        Collections.addAll(hashSet, elements);

        return hashSet;
    }

    @SafeVarargs
    public final <K, V> HashMap<K, V> newHashMap(V[] values, K... keys) {
        HashMap<K, V> hashMap = new HashMap<>();
        for (int i = 0; i < keys.length && i < values.length; i++)
            hashMap.put(keys[i], values[i]);

        return hashMap;
    }
}
