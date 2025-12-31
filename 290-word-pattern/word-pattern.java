class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordToPattern = new HashMap<>();
        Set<Character> usedPattern = new HashSet<>();
        
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        for(int i = 0; i < words.length; i++){
            String currWord = words[i];
            char currPatternChar = pattern.charAt(i);

            // char mappedValue = wordToPattern.getOrDefault(currWord, '\0');

            if((!wordToPattern.containsKey(currWord))){
                if(usedPattern.contains(currPatternChar)) return false;
                wordToPattern.put(currWord, currPatternChar);
                usedPattern.add(currPatternChar);
            }else{
                if(wordToPattern.get(currWord) != currPatternChar) return false;
            }
        }
    return true;
    }
}