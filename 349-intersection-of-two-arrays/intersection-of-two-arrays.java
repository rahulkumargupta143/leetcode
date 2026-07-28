class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length];
        int k=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    boolean duplicate=false;
                    for(int x=0;x<k;x++){
                        if(nums3[x]==nums1[i]){
                            duplicate=true;
                            break;
                        }
                    }
                    if(!duplicate){
                        nums3[k]=nums1[i];
                        k++;
                    }
                    break;
                }
            }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=nums3[i];
        } 
        return ans;
    }
}