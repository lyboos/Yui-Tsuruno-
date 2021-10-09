public class Solution {
    public boolean isPalindrome(String s) {
        return isP(transform(s),0);
    }

    public boolean isP(String s,int index) {
        int len=s.length();
        if(len==0)
            return true;
        if(index==len-1)
            return true;
        if(index<len-1){
            if(s.charAt(index)==s.charAt(len-1-index))
                return isP(s,index+1);
            else
                return false;
        }
        return false;
    }

    private String transform(String target){
        String result="";
        for (char c:target.toCharArray()
             ) {
            if(c<='z'&&c>='a'){
                result+=(char)c;
            }
            if(c<='Z'&&c>='A'){
                result+=(char)(c+'a'-'A');
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String s="0P";
        Solution sl=new Solution();
        System.out.println(sl.isPalindrome(s));
    }
}
