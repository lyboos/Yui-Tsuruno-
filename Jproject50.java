//    1、读入字符串并丢弃无用的前导空格
//    2、检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
//    确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//    3、读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//    4、将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
//    如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//    5、如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，
//    需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
//    大于 231 − 1 的整数应该被固定为 231 − 1 。
//    6、返回整数作为最终结果。

    public int myAtoi(String s) {
        boolean isNeg=false;
        int pos=0;
        while (pos<s.length()&&s.charAt(pos)==' '){
            pos++;
        }
        if(pos==s.length()) return 0;
        if(s.charAt(pos)=='+'){
            isNeg=false;
            pos++;
        }
        else if(s.charAt(pos)=='-'){
            isNeg=true;
            pos++;
        }
        else if(!(s.charAt(pos)-'0'>=0&&s.charAt(pos)-'0'<=9)){
            return 0;
        }
        int res=0;
        while (pos<s.length()&&(s.charAt(pos)-'0'>=0&&s.charAt(pos)-'0'<=9)){
            int temp_num=s.charAt(pos)-'0';
            if(res>(Integer.MAX_VALUE-temp_num)/10){
                return isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res=res*10+temp_num;
            pos++;
        }
        return isNeg?-res:res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            //if(i>0&&nums[i]==nums[i-1]) continue;
            int low=i+1,high=nums.length-1;
            while (low<high){
                List<Integer> temp=new ArrayList<>();
                int sum=nums[i]+nums[low]+nums[high];
                if(sum==0){
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
//                    while (low < high && nums[low] == nums[low + 1])    //去重nums[low]
//                        low++;
//                    while (low < high && nums[high] == nums[high - 1])  //去重nums[high]
//                        high--;
                    //res.add(temp);
                    if (!res.contains(temp))      //第二种去重：通过list去重
                        res.add(temp);
                    low++;
                    high--;
                }
                else if (sum < 0) low++;
                else high--;
            }
        }
        return res;
    }
