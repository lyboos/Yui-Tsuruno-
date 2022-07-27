import lombok.*;
@Getter
@Setter
@AllArgsConstructor
{
    public int searchInsert(int[] nums, int target) {
        Student_lombok student_lombok=new Student_lombok(1,"ly","e");
        student_lombok.setName("sds");
        int left=0,right=nums.length-1;
        int pos=0;
        while (left<=right){
            pos=left+((right-left)/2);
            if(nums[pos]==target)
                return pos;
            else if(nums[pos]>target){
                right=pos-1;
            }
            else if(nums[pos]<target){
                left=pos+1;
            }
        }
        return right+1;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-2;
        int pos=0;
        while(left<right){
            pos=left+((right-left)/2);
            if(arr[pos]>arr[pos+1]&&arr[pos]>arr[pos-1]){
                return pos;
            }
            else if(arr[pos]>arr[pos+1]){
                right=pos;
            }
            else if(arr[pos]<arr[pos+1])
            {
                left=pos;
            }
        }
        return pos;
    }
  
    public class Student_lombok {

        private Integer sid;
        private String name;
        private String sex;
}
}


