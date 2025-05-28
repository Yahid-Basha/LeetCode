class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String k = Arrays.toString(count);
            if(map.containsKey(k)){
                map.get(k).add(s);
            } else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(k, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
