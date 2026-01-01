class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        if(end == 0) return 0;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            // Check if mid is the peak
            // (Handle boundaries by ensuring mid-1 or mid+1 exist)
            boolean leftSmaller = (mid == 0) || arr[mid-1] < arr[mid];
            boolean rightSmaller = (mid == arr.length-1) || arr[mid+1] < arr[mid];
            
            if(leftSmaller && rightSmaller){
                return mid;
            }
            // always check forward with mid and mid+1 for error free and robust code
            if(mid < arr.length - 1 && arr[mid] < arr[mid + 1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return -1;
    }
}