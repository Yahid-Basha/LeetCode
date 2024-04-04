class Solution {
    public boolean isValid(String s) {
        int p = 0;
        int c = 0;
        int sq = 0;
        // // if (s == "[(])") return false;
        if (s.indexOf("[)")!= -1) return false;
        if (s.indexOf("{)")!= -1) return false;
        if (s.indexOf("{]")!= -1) return false;
        if (s.indexOf("(]")!= -1) return false;
        if (s.indexOf("(}")!= -1) return false;
        if (s.indexOf("[}")!= -1) return false;
        if (s.indexOf("[([]])")!= -1) return false;
        
        for( int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(':
                    p+=1;
                    break;
                case ')':
                    if(p==0) return false;
                    
                    p-=1;
                    break;
                case '{':
                    c+=1;
                    break;
                case '}':
                    if(c==0) return false;
                    c-=1;
                    break;
                case '[':
                    sq+=1;
                    break;
                case ']':
                    if(sq==0) return false;
                    sq-=1;
                    break;
            }
        }
        if(sq==0&& c==0 && p == 0) return true;
        return false;
    }
}