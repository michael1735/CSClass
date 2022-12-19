package ACSL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListObjToIntegerTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
