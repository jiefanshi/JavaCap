package AmazonOA.com;

import java.util.*;

public class FindPairWithGivenSum {
    public static void main(String[] arg){
        //System.out.println(findPair(Arrays.asList(1, 10, 25, 35, 60), 90));
        //System.out.println(findPair(Arrays.asList(20, 50, 40, 25, 30, 10), 90));
        //System.out.println(findPair(Arrays.asList(5, 55, 40, 20, 30, 30), 90));
        System.out.println(findPair(Arrays.asList(30, 30, 30, 30, 30, 30, 30), 90));
        System.out.println(findPair(new ArrayList<>(),10));

    }

    public static List<Integer> findPair(List<Integer> nums, int target){

        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        if(nums.isEmpty() || nums.size() == 0){
            return new ArrayList<>();
        }

        int largestIndex = 0;

        for (int i = 0; i < nums.size(); i++){
            int complement = target - nums.get(i);
            if (map.containsKey(complement) && map.get(complement) != i){
                if(largestIndex <= i){
                    results = Arrays.asList(map.get(complement), i);
                }
                //List<Integer> currentList = new ArrayList<>();
                //currentList.add(map.get(complement));
                //currentList.add(i);
                //results.add(currentList);

            }
            //System.out.println(results);
            //System.out.println(map);
            map.put(nums.get(i), i);
            //System.out.println(map);
        }
        if (results.isEmpty()){
            throw new IllegalArgumentException("No such results");
        }

        return results;//.get(results.size() -1);
    }

}
