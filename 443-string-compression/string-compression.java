class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;

        List<Character> list = new ArrayList<>();

        int count = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                list.add(chars[i - 1]);
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        list.add(c);
                    }
                }
                count = 1;
            }
        }


        int i = 0;
        for (char c : list) {
            chars[i++] = c;
        }

        return list.size();
    }
}