package JavaPackage;

import java.util.*;

public class MapDemo {
    // 有三种Map:
    /*
    通用的: HashMap, HashTable, LinkedHashMap, IdentityHashMap, TreeMap, WeakHashMap, ConcurrentHashMap
    专用的: java.util.jar.Attributes、javax.print.attribute.standard.PrinterStateReasons...
    用于实现自己的Map的抽象类: AbstractMap

    常用的有HashMap和TreeMap, 区别为, TreeMap可以对键对象进行排序
     */
    public static void main(String[] args) {
        // Map 是一种键值对集合, Map集合中的每一个元素都包含一个键对象和一个值对象
        // 键对象允许重复, 值对象不允许重复, 且还可以是Map类型

        // Map接口主要有两个实现类, HashMap & TreeMap
        // HashMap按哈希算法来存取键对象, 而TreeMap可以对键对象进行排序
        HashMap<String, String> users = new HashMap<>();
        users.put("11", "dio");
        users.put("22", "lucia");
        users.put("33", "9s");
        users.put("44", "2b");
        users.put("55", "xxi");
        System.out.println("------学生列表---------");
        Iterator<String> it = users.keySet().iterator();
        while (it.hasNext()) {
            // 遍历Map
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("学号:" + key + " 姓名: " + val);
        }
        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入要删除的学号: ");
//        int num = scan.nextInt();
        int num = 10;
        if (users.containsKey(String.valueOf(num))) {
            users.remove(String.valueOf(num));
        } else {
            System.out.println("该学生不存在!");
        }
        System.out.println("学生列表: ");
        it = users.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object val = users.get(key);
            System.out.println("学号: " + key + " 姓名: " + val);
        }
        System.out.println("Map elements: " + users);


        // HashMap

        // 1.constructors
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<Integer, String> hm1 = new HashMap<>(10);
        HashMap<String, String> hm2 = new HashMap<>(10, 0.75F); // 默认的是0.75
        // load factor = 元素个数 / 散列表的长度

        // 2.methods

        // 1. public V put(K key, V value)
        // 加入一个键值对. 如果map里已经有了这个key对应的value的话, 旧的value将被覆盖
        // return the previous value associated with the key， or null if there was no mapping 4 the key(or previously
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

        // 2. public void putAll(Map<? extends K, ? extends V> m) -> 键值类型必须相同
        // 把传入的Map里的所有映射都复制到这个map里, 如果要复制的那个map里有和这个map相同的映射则会替换用新的映射替换旧的
        hashMap.putAll(hm1);
        System.out.println(hashMap);

        // 3. public V remove(Object key)
        // 移除对应map里对应key的映射
        hashMap.remove(4);
        System.out.println(hashMap);

        // 4. pubic void clear()
        // 从此map中移除所有元素
        hm2.clear();
        System.out.println(hm2);

        // 5. public boolean containsValue(Object value)
        // Returns true if this map maps one or more keys to the specified value.
        if (hashMap.containsValue("String1")) {
            System.out.println("The map contains the value String1");
        } else {
            System.out.println("The map doesn't contain the value String1");
        }

        // 6. containsKey()方法和这个一样
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

        // 如果当前 Map 不存在键 key 或者该 key 关联的值为 null，那么就执行 put(key, value)；否则，便不执行 put 操作
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

        // compute, computeIfPresent, computeIfAbsent 现阶段无法理解...下次一定

        // Map遍历
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");

        // 增强for循环遍历
        // keySet()
        for (String key : map1.keySet()) {
            System.out.println(key + " : " + map1.get(key));
        }
        // entrySet()
        // Map.Entry<K, V> (it's a nested class within the Map interface
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 迭代器遍历
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
        总结,
        迭代器 > for循环
        entrySet > keySet
         */

        // 排序要写比较器, Comparator

    }
}
