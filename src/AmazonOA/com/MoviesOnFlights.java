package AmazonOA.com;

import java.util.*;


public class MoviesOnFlights {
    public static void main(String[] args) {
        MoviesOnFlights main = new MoviesOnFlights();
        List<Integer> list1 = Arrays.asList(110, 105, 105, 140, 110, 80, 90, 130);
        System.out.println(main.longestMoviePair(list1, 250));
        //List<Integer> list2 = new ArrayList<>();
        //System.out.println(main.longestMoviePair(list2, 250));
    }

    public List<Integer> longestMoviePair(List<Integer> movieDurations, int target){

        target -= 30;

        List<Integer> result = new ArrayList<>();

        if (target <= 0){
            return result;
        }
        if (movieDurations.size() < 2 || movieDurations == null){
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < movieDurations.size(); i++){
            map.put(i, movieDurations.get(i));
        }

        Collections.sort(movieDurations);

        int leftIndex = 0, rightIndex = movieDurations.size() - 1;
        int maxSum = Integer.MIN_VALUE;
        int maxLeft = -1, maxRight = -1;

        while (leftIndex < rightIndex){
            int sum = movieDurations.get(leftIndex) + movieDurations.get(rightIndex);
            if (sum > target){
                rightIndex--;
            }else{
                if (sum > maxSum){
                    maxSum = sum;
                    maxLeft = movieDurations.get(leftIndex);
                    maxRight = movieDurations.get(rightIndex);
                }
                leftIndex++;
            }
        }

        int temp = -1;
        int leftResult = -1, rightResult = -1;
        for (int i = 0; i < movieDurations.size(); i++){
            if (maxLeft != maxRight){
                if (map.get(i) == maxLeft){
                    leftResult = i;
                }
                if (map.get(i) == maxRight){
                    rightResult = i;
                }
            }else{
                if (map.get(i) == maxRight){
                    rightResult = i;
                    if (temp < i){
                        leftResult = temp;
                    }
                    temp = i;
                }
            }


        }
        if (leftResult >= 0 && rightResult >= 0){
            result.add(Math.min(leftResult,rightResult));
            result.add(Math.max(leftResult,rightResult));
        }

        return result;

    }
}
