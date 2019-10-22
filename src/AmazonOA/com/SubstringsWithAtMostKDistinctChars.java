package AmazonOA.com;

import java.util.*;
public class SubstringsWithAtMostKDistinctChars {
    public static void main(String[] args) {
        SubstringsWithAtMostKDistinctChars main = new SubstringsWithAtMostKDistinctChars();
        System.out.println(main.atMostK("aabaac", 3));
        System.out.println(main.atMostK2("aabaac", 2));
        System.out.println(main.atMostK3("aabaac", 2));

    }
    public int atMostK(String str, int K){
        if (str == null || str.length() == 0 || K <= 0){
            return 0;
        }
        char[] chr =str.toCharArray();
        int l = 0, r = 0;
        int len = str.length();
        List<String> result = new ArrayList<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        int count = 0;
        while(l <= r && l < len){
            while (r < len && currentMap.size() <= K){
                if (!currentMap.containsKey(chr[r])){
                    currentMap.put(chr[r], 1);
                } else{
                    currentMap.put(chr[r], currentMap.get(chr[r]) + 1);
                }
                if (currentMap.size() > K){
                    currentMap.remove(chr[r]);
                    break;
                }
                r++;
            }
            //System.out.println(currentMap.size());
            count += r - l;
            int k = l;
            while (k < r){
                result.add(str.substring(l,k + 1));
                k++;
            }
            if (currentMap.get(chr[l]) == 1){
                currentMap.remove(chr[l]);
            }else{
                currentMap.put(chr[l], currentMap.get(chr[l]) - 1);
            }
            l++;
        }
        return count;
    }

    public List<String> atMostK3(String str, int K){//with string
        if (str == null || str.length() == 0 || K <= 0){
            return null;
        }
        char[] chr =str.toCharArray();
        int l = 0, r = 0;
        int len = str.length();
        List<String> result = new ArrayList<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        //int count = 0;
        while(l <= r && l < len){
            while (r < len && currentMap.size() <= K){
                if (!currentMap.containsKey(chr[r])){
                    currentMap.put(chr[r], 1);
                } else{
                    currentMap.put(chr[r], currentMap.get(chr[r]) + 1);
                }
                if (currentMap.size() > K){
                    currentMap.remove(chr[r]);
                    break;
                }
                r++;
            }
            //System.out.println(currentMap.size());
            //count += r - l;
            int k = l;
            while (k < r){
                result.add(str.substring(l,k + 1));
                k++;
            }
            if (currentMap.get(chr[l]) == 1){
                currentMap.remove(chr[l]);
            }else{
                currentMap.put(chr[l], currentMap.get(chr[l]) - 1);
            }
            l++;
        }
        System.out.println(result.size());
        return result;
    }



    public int atMostK2(String str, int K) {
        char[] A = str.toCharArray();
        int i = 0, res = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}