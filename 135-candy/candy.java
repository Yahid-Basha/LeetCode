class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            if(i > 0 && ratings[i] > ratings[i-1]){
                arr[i] = arr[i-1]+1;
            }else{
                arr[i] = 1;
            }
        }

        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                arr[i] = Math.max(arr[i+1]+1, arr[i]);
            }
        }

        for(int i : arr){
            System.out.print(i+" ");
        }

        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        return sum;
    }
}