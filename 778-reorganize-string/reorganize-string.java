class Solution {
    class Node{
        char c;
        int freq;

        Node(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(b.freq-a.freq));
        Queue<Node> que = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c: map.keySet()){
            pq.offer(new Node(c, map.get(c)));
        }

        while(!pq.isEmpty() || !que.isEmpty()){
            if(pq.isEmpty()) return "";
            boolean hadQueue = !que.isEmpty();
            Node node = pq.poll();
            sb.append(node.c);
            node.freq--;
            if(node.freq > 0) que.offer(node);
            if(hadQueue) pq.offer(que.poll());
        }
        return sb.toString();
    }
}