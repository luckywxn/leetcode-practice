public class Exercise_011 {
    public static void main(String[] args){
        Exercise_011 Ex = new Exercise_011();
        System.out.println(Ex.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea2(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int area = (j-i)*Math.min(height[i], height[j]);
                max = Math.max(max,area);
            }
        }
        return max;
    }


    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int t = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(ans, t);
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }

}
