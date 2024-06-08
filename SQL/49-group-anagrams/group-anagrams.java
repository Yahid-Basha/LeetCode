import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if(strs == null){
            return output;
        }
        for(String s: strs){
            if (s == null) {
                continue;
            }
            char tempArr[] = s.toCharArray();
            Arrays.sort(tempArr);
            String temp = new String(tempArr);
            if(map.containsKey(temp)){
                map.get(temp).add(s);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp, list);
            }
        }
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            output.add(e.getValue());
        }
        return output;
    }
}