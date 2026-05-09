class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m= s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        int cookies=0;
        while(child<n && cookies<m){
            if (s[cookies] >= g[child]) {
                child++;
            }
            cookies++;
        }
        return child;
    }
}