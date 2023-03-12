package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){  //�ѽ�ȫ����ѡ���������������������������ݹ�
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // �Ѿ�ѡ����������ѡ
                tempList.add(nums[i]);  //ѡ��ǰ�ڵ�
                backtracking(list, tempList, nums);  //�ݹ�
                tempList.remove(tempList.size() - 1); //���ݵ���һ����ȥ����ǰ�ڵ�
            }
        }
    }
}
