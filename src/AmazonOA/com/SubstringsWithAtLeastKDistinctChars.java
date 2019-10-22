package AmazonOA.com;
import java.util.*;
public class SubstringsWithAtLeastKDistinctChars {// at least k distinct chars
    public static void main(String[] args) {
        int results1 = kDistinctChars("pqpqsp", 2);
        System.out.println(results1);
        int results2 = kDistinctChars("pqpqsp", 3);
        System.out.println(results2);
    }

    public static int kDistinctChars(String s, int k){
        char[] ch = s.toCharArray();
        //Set<Character> currentSet = new HashSet<>();
        //Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        //List<Character> currentList = new ArrayList<>();

        //List<List<Character>> results = new ArrayList<>();
        int l = 0, r = 0;
        int result = 0;
        while(l < ch.length && l <= r){
            while (r < ch.length && currentMap.size() < k){
                if(!currentMap.containsKey(ch[r])){
                    currentMap.put(ch[r], 1);
                }else{
                    currentMap.put(ch[r], currentMap.get(ch[r])+1);
                }
                r++;
            }

            if (currentMap.size() == k){
                result += ch.length- r + 1;
            }
            if(currentMap.get(ch[l]) == 1){
                currentMap.remove(ch[l]);
            }else{
                currentMap.put(ch[l], currentMap.get(ch[l])-1);
            }
            l++;
        }
        return result;
    }
}