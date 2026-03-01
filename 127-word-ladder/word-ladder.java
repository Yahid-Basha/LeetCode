class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        if(!wordsSet.contains(endWord)) return 0;
        
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: wordList){
            for(int i = 0; i < s.length(); i++){
                String key = s.substring(0,i)+"*"+s.substring(i+1);
                if(!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                String s = queue.poll();
                for(int i = 0; i < s.length(); i++){
                    String key = s.substring(0,i)+"*"+s.substring(i+1);
                    if(!map.containsKey(key)) continue;
                    for(String node: map.get(key)){
                        if(node.equals(endWord)) return level+1;
                        if(!visited.contains(node)){
                            visited.add(s);
                            queue.offer(node);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}