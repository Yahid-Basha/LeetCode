class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generator(new StringBuilder(), n, n, list);
        return list;

    }
    public void generator(StringBuilder sb, int open_left, int close_left, List<String> list){
        if(open_left == 0 && close_left == 0){
            list.add(sb.toString());
            return;
        }
        if(open_left > 0){
            generator(sb.append('('), open_left-1, close_left, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(open_left < close_left){
            generator(sb.append(')'), open_left, close_left-1, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}