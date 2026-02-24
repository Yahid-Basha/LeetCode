class TrieNode{
    public TrieNode[] children= new TrieNode[26];
    public int idx = -1;
    int refs = 0;

    public void addNode(String word, int i){
        TrieNode curr = this;
        curr.refs++;

        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            curr.refs++;
        }
        curr.idx = i;
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            root.addNode(words[i], i);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, i, j, words);
            }
        }

        return res;
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, String[] words){
        if(r < 0 || r >= board.length || c< 0 || c >= board[0].length || board[r][c] == '#' || node.children[board[r][c]-'a'] == null){
            return;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        TrieNode prev = node;
        node = node.children[temp-'a'];

        if(node.idx != -1){
            res.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if(node.refs == 0){
                node = null;
                prev.children[temp-'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(board, node, r+1, c, words);
        dfs(board, node, r-1, c, words);
        dfs(board, node, r, c+1, words);
        dfs(board, node, r, c-1, words);

        board[r][c] = temp;
    }
}
