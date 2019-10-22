package AmazonOA.com;

import java.util.*;

public class SubstringsOfSizeKWithKDistinctChars {// size must be equal to k
    public static void main(String[] args) {
        SubstringsOfSizeKWithKDistinctChars main = new SubstringsOfSizeKWithKDistinctChars();

        System.out.println(main.kSubstringWithKDistinctChars("abcba", 2));

        //System.out.println(main.KSubstring("abcba", 2));
    }

    public List<String> kSubstringWithKDistinctChars(String s, int k){

        if (s.isEmpty() || k <= 0 || s.length() < k){
            return new ArrayList<>();
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        Set<String> resultString = new HashSet<>();
        //String currentString = "";
        char[] set = s.toCharArray();
        int l = 0, r = 0;

        while(r < k){
            if (!currentMap.containsKey(set[r])){
                currentMap.put(set[r],1);
            }else{
                currentMap.put(set[r],currentMap.get(set[r]) + 1);
            }
            r++;
            if (currentMap.size() == k){
                resultString.add(s.substring(0,k));
            }
        }

        while (r < s.length()){

            if (currentMap.get(set[l]) == 1){
                currentMap.remove(set[l]);
            }else{
                currentMap.put(set[l], currentMap.get(set[l]) - 1);
            }
            l++;


            if (!currentMap.containsKey(set[r])){
                currentMap.put(set[r],1);
            }else{
                currentMap.put(set[r],currentMap.get(set[r]) + 1);
            }
            //currentString += set[r];
            r++;
            if (currentMap.size() == k && !resultString.contains(s.substring(l,r))){
                resultString.add(s.substring(l,r));
            }

        }

        return new ArrayList<>(resultString);
    }



    public int KSubstring(String s, int k) {
        // Write your code here
        if (s.isEmpty() || k <= 0 || s.length() < k){
            return 0;
        }
        int [] currentInt = new int[5000];
        int currentCount = 0;
        Set<String> resultString = new HashSet<>();

        int l = 0, r = 0;
        while (r < k){
            if (currentInt[Integer.valueOf(s.charAt(r))] == 0){
                currentCount++;
            }
            currentInt[Integer.valueOf(s.charAt(r))]++;
            r++;
            if (currentCount == k){
                resultString.add(s.substring(0,k));
                System.out.println(currentCount);
                System.out.println(resultString);
            }


        }
        while(r < s.length()){

            currentInt[Integer.valueOf(s.charAt(l))]--;
            if (currentInt[Integer.valueOf(s.charAt(l))] == 0){
                currentCount--;
            }
            System.out.println(currentCount);
            l++;


            if (currentInt[Integer.valueOf(s.charAt(r))] == 0){
                currentCount++;
            }
            System.out.println(currentCount);

            currentInt[Integer.valueOf(s.charAt(r))]++;
            r++;
            if (currentCount == k && !resultString.contains(s.substring(l,r))){
                resultString.add(s.substring(l,r));
                System.out.println(resultString);
            }
        }
        return resultString.size();
    }
}
