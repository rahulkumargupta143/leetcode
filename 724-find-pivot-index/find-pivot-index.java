class Solution {
    public int pivotIndex(int[] arr) {
        int totalsum=0;
        for(int num : arr){
            totalsum+=num;
        }
        int leftsum=0;
        for(int i=0;i<arr.length;i++){
            int rightsum=totalsum-leftsum-arr[i];
            if(leftsum == rightsum){
                return i;
            }
            leftsum+=arr[i];
        }
        return -1;
    }
}