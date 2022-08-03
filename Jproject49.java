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

    public int findKthPositive(int[] arr, int k) {
        int i = 0, j = arr.length - 1;
        while(i <= j){
            int m = i + ((j - i) >> 1);
            // sum 为arr[m] 之前缺失的正整数数量
            int sum = arr[m] - m - 1;
            if(sum >= k)
                j = m - 1;
            else
                i = m + 1;
        }
        // return arr[i] - (arr[i] - i - 1 - k + 1);
        return i + k;
    }
