class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        
        for(String str: strs){
            String key = createKey(str);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
    public String createKey(String str){
        int arr[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        return Arrays.toString(arr);
    }
}