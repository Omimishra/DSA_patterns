package Two_pointers;
public class trapping_rainwater {
    public int trap(int[] height){
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }
    public static void main(String[] args) {
        trapping_rainwater tr = new trapping_rainwater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(tr.trap(height)); // Output: 6
    }
}
