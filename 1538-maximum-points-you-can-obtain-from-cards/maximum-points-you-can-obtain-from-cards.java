class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+cardPoints[i];
        }
        int max=sum;
        for(int i=1;i<=k;i++){
            sum=sum-cardPoints[k-i]+cardPoints[n-i];
            max=Math.max(max,sum);
        }
        return max;
    }
}