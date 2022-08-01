import java.util.*;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        Student_lombok student_lombok=new Student_lombok();
        //student_lombok.setName("sds");
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
    static class Student {
        private final String name;
        private final String type;
        private final int score;

        public Student(String name, String type, int score) {
            this.name = name;
            this.type = type;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public String getType() {
            return type;
        }
    }

    public int mySqrt(int x) {
        int left=0,right=x,mid;
        while(right-left>1){
            mid=left+(right-left)/2;
            int i=x/mid;
            if(i==mid) return mid;
            if(i<mid){
                right=mid;
            }
            else
                left=mid;
        }
        return left;
    }

    boolean isBadVersion(int x){
        if(x==1) return true;
        else return false;
    }

    public int firstBadVersion1(int n) {
        int left=1,right=n,mid;
        while(right-left>1){
            mid=left+(right-left)/2;
            if(isBadVersion(mid))
                right=mid;
            else
                left=mid+1;
        }
        if(isBadVersion(left))
        return left;
        else return right;
    }

    public int firstBadVersion2(int n) {
        int left=1,right=n,mid;
        while(right>left){
            mid=left+(right-left)/2;
            if(isBadVersion(mid))
                right=mid;
            else
                left=mid+1;
        }
        return right;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left=0,right=letters.length-1,mid;
        while(right-left>1){
            mid=(left+(right-left)/2);
            int i=letters[mid]-target;
            if(i>0)
                right=mid;
            else
                left=mid;
        }
        return letters[left];
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res={-1,-1};
        int pos=-1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                pos=mid;
                break;
            }
        }
        if(pos!=-1){
            int i=-1;
            for (i = pos; i >=0 ; i--) {
                if(nums[i]!=target){
                    res[0]=i+1;
                    break;
                }
                if(i==0) res[0]=0;
            }
            for (i = pos; i <nums.length ; i++) {
                if(nums[i]!=target){
                    res[1]=i-1;
                    break;
                }
                if(i==nums.length-1) res[1]=nums.length-1;
            }
        }


        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int pos=-1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<=target){
                left=mid+1;
                res[1]=left;
            }
        }
        left=0;right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid-1;
                res[0]=right;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
        }
        if(res[0]==-2||res[1]==-2){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        else if(res[1]-res[0]>1){
            return new int[]{res[0]+1,res[1]-1};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("yoni", "English", 80),
                new Student("yoni", "Chiness", 98),
                new Student("yoni", "Math", 95),
                new Student("taohai.wang", "English", 50),
                new Student("taohai.wang", "Chiness", 72),
                new Student("taohai.wang", "Math", 41),
                new Student("Seely", "English", 88),
                new Student("Seely", "Chiness", 89),
                new Student("Seely", "Math", 92)
        );
        Map<String, Integer> scoreMap = new HashMap<>();
        students.forEach(student -> scoreMap.merge(student.getName(), student.getScore(), Integer::sum));
        scoreMap.forEach((k, v) -> System.out.println("key:" + k + "总分" + "value:" + v));
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "A");
//        map.put(2, "B");
//        map.compute(1, (k, v) -> {   //compute会将指定Key的值进行重新计算，若Key不存在，v会返回null
//            return v+"M";     //这里返回原来的value+M
//        });
//        map.computeIfPresent(1, (k, v) -> {   //当Key存在时存在则计算并赋予新的值
//            return v+"M";     //这里返回原来的value+M
//        });
//        map.computeIfAbsent(0, (k) -> {   //若不存在则计算并插入新的值
//            return "M";     //这里返回M
//        });
//        System.out.println(map);
//        List<Integer> list=new LinkedList<>();
//        list.add(19);
//        list.add(1);
//        list.add(10);
//        list.add(100);
//        list.sort((a,b)->{
//            return a-b;
//        });
//        System.out.println(list);
//        Iterator<Integer> iterator=list.iterator();
//        while(iterator.hasNext()){
//            Integer i=iterator.next();
//            System.out.println(i);
//        }
//        byte b = 105;
//        b = (byte) (b + 1);   //报错！
//        System.out.println(b);
//        Student_lombok student_lombok=new Student_lombok();
//        label1:{
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 23; j++) {
//                System.out.println("trigger");
//                break label1;
//            }
//        }
//        }
//        student_lombok.setName(String.valueOf('e'));
//        student_lombok.setSid(163);
//        student_lombok.setSex("none");
//        System.out.println(student_lombok);
    }
}
