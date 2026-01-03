class Solution {
    Map<Integer, List<String>> map;
    Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        map = new HashMap<>();
        solve(s, 0);
        return map.getOrDefault(0, new ArrayList<>());
    }
    public List<String> solve(String s, int start){
        if(map.containsKey(start)) return map.get(start);

        List<String> result = new ArrayList<>();

        if(start == s.length()){
            result.add("");
            return result;
        }

        for(int end = start+1; end <= s.length(); end++ ){
            String word = s.substring(start,end);
            if(dict.contains(word)){
                List<String> suffixes = solve(s, end);

                for(String suffix: suffixes){
                    String space = suffix.isEmpty() ? "" : " ";
                    result.add(word + space + suffix);
                }
            }
        }

        map.put(start, result);
        return result;
    }
}