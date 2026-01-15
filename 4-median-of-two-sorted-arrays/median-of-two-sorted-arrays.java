class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int mid = (m + n)/2;
        int m1 = -1, m2 = -1;
        int i = 0, j= 0;

        for(int count = 0; count <= mid; count++){
            m2 = m1;
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                    m1 = nums1[i++];
                }else{
                    m1 = nums2[j++];
            }
        }
        if((m+n)%2 == 0){
            return (double)(m1+m2)/2;
        }else{
            return m1;
        }

    }
}