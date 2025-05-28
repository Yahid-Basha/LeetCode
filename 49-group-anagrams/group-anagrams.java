class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            String key = hashString(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }

    public String hashString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String s = new String("");
        for(char i: arr){
            s+=i;
        }
        return s;
    }
}