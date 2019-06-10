public class TrapWater {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int left=0;int right=0;
        int sum=0;
        while(i<j) {
            if(height[i] <= height[j]) {
                int gain = left - height[i];
                if(gain > 0) sum+=gain;
                left = Math.max(left, height[i]);
                i++;
            } else {
                int gain = right - height[j];
                if(gain>0) sum+=gain;
                right = Math.max(right, height[j]);
                j--;
             }
        }
        return sum;
    }
}
