class Solution {
    public int[] sortArray(int[] nums) {
        int l = 0, r = nums.length-1;
        mergeSort(nums, l, r);
        return nums;
    }
    public void mergeSort(int[] nums, int l, int r){
        if(l >=r ) return;
        int mid = l + (r-l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }
    public void merge(int[] nums, int l, int mid, int r){
        if(l < r){
            int n1 = mid-l+1;
            int n2 = r-mid;

            int arr1[] = new int[n1];
            int arr2[] = new int[n2];

            for(int i = 0; i < n1; i++){
                arr1[i] = nums[l+i];
            }
            for(int i = 0; i < n2; i++){
                arr2[i] = nums[mid+1+i];
            }

            int i =0, j = 0;
            while(i < n1 && j < n2){
                if(arr1[i] < arr2[j]){
                    nums[l] = arr1[i];
                    l++;
                    i++;
                }else{
                    nums[l] = arr2[j];
                    l++;
                    j++;
                }
            }
            while (i < n1){
                nums[l++] = arr1[i++];
            }
            while(j < n2){
                nums[l++] = arr2[j++];
            }

        }
    }
}