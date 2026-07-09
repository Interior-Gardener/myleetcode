
class Solution {

    public static int trap(int[] height) {
        int ans = 0;
        int leftmax = 0;
        int rightmax = 0;
        int  i = 0 ;
        int j = height.length -1;

        while(i<j){
            leftmax = Math.max(leftmax,height[i]);
            rightmax = Math.max(rightmax , height[j]);

            if(leftmax<rightmax) {
                ans+=(leftmax-height[i]);
                i++;
            }
            else {
                ans+=(rightmax-height[j]);
                j--;
            }
        }
        return ans;
    }
    // public static int trap(int[] height) {

    //     int[] leftmax = new int[height.length];
    //     int[] rightmax = new int[height.length];

    //     leftmax[0] = height[0];
    //     rightmax[height.length -1] = height[height.length -1];

    //     for(int  i = 1 ; i < height.length ; i++){
    //         leftmax[i] = Math.max(leftmax[i-1],height[i]);
    //     }

    //     for(int i = height.length-2 ; i>=0 ; i--){
    //         rightmax[i] = Math.max(rightmax[i+1],height[i]);
    //     }
    //     // System.out.println(Arrays.toString(leftmax));
    //     // System.out.println(Arrays.toString(rightmax));
    //     int[] trap = new int[height.length];
    //     for (int i = 0; i < height.length; i++) {
    //         trap[i] = Math.min(leftmax[i], rightmax[i]) - height[i];
    //     }
    //     int result = 0;
    //     for (int i = 0; i < trap.length; i++) {
    //         result += trap[i];
    //     }
    //     return result;
    // }

    // public static int leftmax(int[] height, int i) {
    //     int leftmax = 0;
    //     for (int j = 0; j <= i; j++) {
    //         if (leftmax < height[j]) {
    //             leftmax = height[j];
    //         }
    //     }
    //     return leftmax;
    // }

    // public static int rightmax(int[] height, int i) {
    //     int rightmax = 0;
    //     for (int j = height.length - 1; j >= i; j--) {
    //         if (rightmax < height[j]) {
    //             rightmax = height[j];
    //         }
    //     }
    //     return rightmax;
    // }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};

        int res = trap(height);
        System.out.println(res);
    }
}
