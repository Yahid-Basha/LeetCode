class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right){
            int area = ( right - left ) * ( ( height[right] > height[left] ) ? height[left] : height[right] );
            if(area > max) max = area;
            if(height[right] > height[left]){
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}