class Solution { 
   Integer[][] dp; 
   int len, m; 
   public int minCost(int n, int[] cuts) { 
       len = n; 
       m = cuts.length; 
       Arrays.sort(cuts); 
       dp = new Integer[m + 1][m + 1]; 
       return dfs(cuts, 0, m);  
   } 
   private int dfs(int[] cuts, int l, int r) { 
       if (dp[l][r] != null) return dp[l][r]; 
       if (l >= r) return 0;  
       int cost = (r == m ? len : cuts[r]) - (l == 0 ? 0 : cuts[l - 1]); 
       dp[l][r] = Integer.MAX_VALUE; 
       for(int i = l; i < r; i++) {  
           dp[l][r] = Math.min(dp[l][r], dfs(cuts, l, i) + dfs(cuts, i + 1, r) 
+ cost); 
       } 
       return dp[l][r]; 
   } 
}
