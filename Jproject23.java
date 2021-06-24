public class warmup {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new warmup().maxSubArray1(nums));
        System.out.println(new warmup().maxSubArray2(nums));
    }

    public int maxSubArray1(int[] nums) {
        int sum=0;
        if(nums==null||nums.length==0)
            return 0;
        int res=nums[0];
        for (int num:nums
             ) {
            if(sum>0)
                sum+=num;
            else
                sum=num;
            res=Math.max(sum,res);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int sum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>0)
                nums[i]+=nums[i-1];
        }
        for (int num:
             nums) {
            if(num>sum)
                sum=num;
        }
        return sum;
    }

}
