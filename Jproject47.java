import java.util.Arrays;

public class Solution { 

public boolean isPerfectSquare(int num) {
        int left=0,right=num-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;
            int t=num/mid;
            if(t==mid){
                if(num%mid==0)
                return true;
                left=mid+1;
            }
            else if(t>mid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        Arrays.sort(arr2);
        for(int t:arr1){
            int left=0,right=arr2.length-1,mid;
            while(left<right){
                if (arr2[right] < t) {
                    left=right+1;
                    break;
                }
                mid=left+(right-left)/2;
                if(arr2[mid]<t) {
                    left=mid+1;
                }
                else {
                    right=mid;
                }
            }
            int p=left;
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - t > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= t - arr2[p - 1] > d;
            }
            count += ok ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Student_lombok student_lombok=new Student_lombok();
        label1:{
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 23; j++) {
                System.out.println("trigger");
                break label1;
            }
        }
        }
        student_lombok.setName(String.valueOf('e'));
        student_lombok.setSid(163);
        student_lombok.setSex("none");
        System.out.println(student_lombok);
    }
}
