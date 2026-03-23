class Twitter {
    Map<Integer, List<int[]>> posts;
    Map<Integer, Set<Integer>> followMap;
    int time;
    public Twitter() {
        time = 0;
        posts = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!posts.containsKey(userId)){
            posts.put(userId, new ArrayList<>());
        }
        posts.get(userId).add(new int[]{time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Set<Integer> users = followMap.getOrDefault(userId, new HashSet<>());
        users.add(userId);
        for(int user: users){
            for(int[] tweet: posts.getOrDefault(user, new ArrayList<>())){
                pq.offer(tweet);
                if(pq.size() > 10) pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */