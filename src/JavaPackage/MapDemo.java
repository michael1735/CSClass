package JavaPackage;

import java.util.*;

public class MapDemo {
    // ������Map:
    /*
    ͨ�õ�: HashMap, HashTable, LinkedHashMap, IdentityHashMap, TreeMap, WeakHashMap, ConcurrentHashMap
    ר�õ�: java.util.jar.Attributes��javax.print.attribute.standard.PrinterStateReasons...
    ����ʵ���Լ���Map�ĳ�����: AbstractMap

    ���õ���HashMap��TreeMap, ����Ϊ, TreeMap���ԶԼ������������
     */
    public static void main(String[] args) {
        // Map ��һ�ּ�ֵ�Լ���, Map�����е�ÿһ��Ԫ�ض�����һ���������һ��ֵ����
        // �����������ظ�, ֵ���������ظ�, �һ�������Map����

        // Map�ӿ���Ҫ������ʵ����, HashMap & TreeMap
        // HashMap����ϣ�㷨����ȡ������, ��TreeMap���ԶԼ������������
        HashMap<String, String> users = new HashMap<>();
        users.put("11", "dio");
        users.put("22", "lucia");
        users.put("33", "9s");
        users.put("44", "2b");
        users.put("55", "xxi");
        System.out.println("------ѧ���б�---------");
        Iterator<String> it = users.keySet().iterator();
        while (it.hasNext()) {
            // ����Map
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("ѧ��:" + key + " ����: " + val);
        }
        Scanner scan = new Scanner(System.in);
//        System.out.println("������Ҫɾ����ѧ��: ");
//        int num = scan.nextInt();
        int num = 10;
        if (users.containsKey(String.valueOf(num))) {
            users.remove(String.valueOf(num));
        } else {
            System.out.println("��ѧ��������!");
        }
        System.out.println("ѧ���б�: ");
        it = users.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("ѧ��: " + key + " ����: " + val);
        }
        System.out.println("Map elements: " + users);


        // HashMap

        // 1.constructors
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<Integer, String> hm1 = new HashMap<>(10);
        HashMap<String, String> hm2 = new HashMap<>(10, 0.75F); // Ĭ�ϵ���0.75
        // load factor = Ԫ�ظ��� / ɢ�б�ĳ���

        // 2.methods

        // 1. public V put(K key, V value)
        // ����һ����ֵ��. ���map���Ѿ��������key��Ӧ��value�Ļ�, �ɵ�value��������
        // return the previous value associated with the key�� or null if there was no mapping 4 the key(or previously
        // associated with null value)
        hashMap.put(1, "String1");
        hashMap.put(2, "String2");
        hashMap.put(3, "String3");
        System.out.println(hashMap);
        hm1.put(1, "hm1 element1");
        hm1.put(4, "hm1 element2");
        System.out.println(hm1);
        hm2.put("first", "A");
        hm2.put("second", "B");
        System.out.println(hm2);

        // 2. public void putAll(Map<? extends K, ? extends V> m) -> ��ֵ���ͱ�����ͬ
        // �Ѵ����Map�������ӳ�䶼���Ƶ����map��, ���Ҫ���Ƶ��Ǹ�map���к����map��ͬ��ӳ������滻���µ�ӳ���滻�ɵ�
        hashMap.putAll(hm1);
        System.out.println(hashMap);

        // 3. public V remove(Object key)
        // �Ƴ���Ӧmap���Ӧkey��ӳ��
        hashMap.remove(4);
        System.out.println(hashMap);

        // 4. pubic void clear()
        // �Ӵ�map���Ƴ�����Ԫ��
        hm2.clear();
        System.out.println(hm2);

        // 5. public boolean containsValue(Object value)
        // Returns true if this map maps one or more keys to the specified value.
        if (hashMap.containsValue("String1")) {
            System.out.println("The map contains the value String1");
        } else {
            System.out.println("The map doesn't contain the value String1");
        }

        // 6. containsKey()���������һ��
        if (hashMap.containsKey(1)) {
            System.out.println("The key 1 exists within hashMap");
        }

        // 7. public int size();
        // Returns the number of key-value mappings in this map.
        System.out.println(hashMap.size());

        // 8. public boolean isEmpty()
        System.out.println(hashMap.isEmpty());

        // 9. public V get(Object key)
        // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        /*
        A return value of null does not necessarily indicate that the map contains no mapping for the key;
        it's also possible that the map explicitly maps the key to null. The containsKey operation may be
        used to distinguish these two cases.
         */
        System.out.println(hashMap.get(1));

        // 9.public Object clone()
        // Returns a shallow copy of this HashMap instance: the keys and values themselves are not cloned.
        Object clone = hashMap.clone();
        System.out.println("The shallow copy of the HashMap Object is: " + clone);

        // (from Map interface)
        // default V putIfAbsent(K key, V value)
        // the previous value associated with the specified key, or null if there was no mapping for the key.
        // (A null return can also indicate that the map previously associated null with the key,
        // if the implementation supports null values.)

        // �����ǰ Map �����ڼ� key ���߸� key ������ֵΪ null����ô��ִ�� put(key, value)�����򣬱㲻ִ�� put ����
        // (java 8 new method)
        HashMap<String, Integer> map = new HashMap<>();
        map.put("demo1", 1);
        map.put("demo2", 2);
        System.out.println(map);
        map.putIfAbsent("demo1", 121);
        map.putIfAbsent("demo3", 133);
        System.out.println(map);
        System.out.println(map.putIfAbsent("demo1", 12)); // 1
        System.out.println(map.putIfAbsent("demo4", 123)); // null

        // compute, computeIfPresent, computeIfAbsent �ֽ׶��޷����...�´�һ��

        // Map����
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");

        // ��ǿforѭ������
        // keySet()
        for (String key : map1.keySet()) {
            System.out.println(key + " : " + map1.get(key));
        }
        // entrySet()
        // Map.Entry<K, V> (it's a nested class within the Map interface
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // ����������
        // keySet()
        Iterator<String> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " : " + map1.get(key));
        }
        // entrySet()
        Iterator<Map.Entry<String, String>> itr = map1.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> entry = itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        /*
        �ܽ�,
        ������ > forѭ��
        entrySet > keySet
         */

        // ����Ҫд�Ƚ���, Comparator

    }
}
