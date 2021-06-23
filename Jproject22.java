public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        OUT:
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break OUT;
                }
            }
        }
        return result;
    }


public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String str= Integer.toString(x);
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }

  public String longestCommonPrefix(String[] strs) {
        StringBuffer sb=new StringBuffer();
        int min=9999999,mn=0;
        for (int i = 0; i < strs.length; i++) {
            if(min>strs[i].length())
            {
                min=strs[i].length();
               mn=i;
            }
        }
        sb.append(strs[mn]);
        for (String str:strs) {
            for (int i = 0; i < (Math.min(sb.length(), str.length())); i++) {
                if(sb.charAt(i)!=str.charAt(i)) {
                    sb.delete(i,sb.length());
                }
            }
        }
        return sb.toString();
    }
  
  
  
}

