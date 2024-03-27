class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i,j,k;
       i = j = k = 0;
       int Arr[] = new int[m+n];

       while(i<m && j<n){
           if(nums1[i]<nums2[j]){
               Arr[k++] = nums1[i++];
           } else {
               Arr[k++] = nums2[j++];
           }
       }
       while(i<m){
           Arr[k++]=nums1[i++];
       }
       while(j<n){
           Arr[k++]=nums2[j++];
       }
        for(i=0;i<m+n;i++){
            nums1[i]=Arr[i];
        }

    }
}