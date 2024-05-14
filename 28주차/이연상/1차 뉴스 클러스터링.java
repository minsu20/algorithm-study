// [PRG] [1차] 뉴스 클러스터링

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        double a = 0;
        double b = 0;
        
        for(int i = 0; i < str1.length(); i++) {
            if(i == str1.length() - 1)
                break;
            String temp = str1.substring(i, i + 2);
            if(!temp.matches("^[a-z]+$"))
                continue;
            
            if(mapA.containsKey(temp))
               mapA.put(temp, mapA.get(temp) + 1); 
            else
                mapA.put(temp, 1);
        }
        
        for(int i = 0; i < str2.length(); i++) {
            if(i == str2.length() - 1) 
                break;
            String temp = str2.substring(i, i + 2); 
            if(!temp.matches("^[a-z]+$"))
                continue;
            
            if(mapB.containsKey(temp))
                mapB.put(temp, mapB.get(temp) + 1); 
            else
                mapB.put(temp, 1);
        }
        
        if(mapA.size() == 0 && mapB.size() == 0)
            return 65536;
        
        for(String key : mapA.keySet()) {
            if(mapB.containsKey(key)) {
                a += Math.min(mapA.get(key), mapB.get(key));
                b += Math.max(mapA.get(key), mapB.get(key));
                mapB.remove(key);
            }
            else {
                b += mapA.get(key);
            }
        }
        
        for(String key : mapB.keySet()) {
                b += mapB.get(key);
        }
        answer = (int) Math.floor((a / b) * 65536);
        return answer;
    }
}