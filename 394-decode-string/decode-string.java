class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        int k = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k * 10 + (ch-'0');
            }else if(ch == '['){
                countStack.push(k);
                resStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                int count = countStack.pop();
                StringBuilder decodingString = curr;
                curr = resStack.pop();
                while(count-- != 0){
                    curr.append(decodingString);
                }
            }else{
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}