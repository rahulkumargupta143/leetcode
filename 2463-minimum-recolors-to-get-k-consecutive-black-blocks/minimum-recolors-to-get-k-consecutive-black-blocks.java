class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0, ans = k;
        
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') w++;
            
            if (i >= k && blocks.charAt(i - k) == 'W') w--;
            
            if (i >= k - 1) ans = Math.min(ans, w);
        }
        
        return ans;
    }
}