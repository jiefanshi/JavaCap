package AmazonOA.com;
import java.util.*;
public class SubstringsWithExactlyKDistinctChars {// size can be greater than k
    public static void main(String[] args) {
        int results1 = kDistinctChars("pqpqsp", 2);
        System.out.println(results1);
        int results2 = kDistinctChars("pqpqsp", 3);
        System.out.println(results2);
        int results3 = kDistinctChars("abcbaa", 3);
        System.out.println(results3);


        int results4 = atLeastK("pqpqsp", 3) - atLeastK("pqpqsp", 4);
        System.out.println(results4);

    }

    public static int kDistinctChars(String s, int k){//brute force O(n2)
        char[] ch = s.toCharArray();
        Set<Character> currentSet = new HashSet<>();
        int l = 0, r = 0;
        int result = 0;
        while(l < ch.length && l <= r){
            while (r < ch.length && currentSet.size() <= k){
                if(!currentSet.contains(ch[r])){
                    currentSet.add(ch[r]);
                }
                if (currentSet.size() == k){
                    result ++;
                }
                r++;
            }
            l++;
            r = l;
            currentSet = new HashSet<>();
        }
        return result;
    }

    public static int atLeastK(String s, int K){//O(n)
        char [] A = s.toCharArray();
        int result = 0;
        int l = 0, r = 0;
        int len = s.length();
        Map<Character, Integer> currentMap = new HashMap<>();
        while(l <= r && l < len){
            while(r < len && currentMap.size() < K){
                if (!currentMap.containsKey(A[r])){
                    currentMap.put(A[r], 1);
                }else{
                    currentMap.put(A[r], currentMap.get(A[r]) + 1);
                }
                r++;
            }
            if (currentMap.size() == K){
                result += len - r + 1;
            }
            if (currentMap.get(A[l]) == 1){
                currentMap.remove(A[l]);
            }else{
                currentMap.put(A[l], currentMap.get(A[l]) - 1);
            }
            l++;
        }
        return result;
    }
}