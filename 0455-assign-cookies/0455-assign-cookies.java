class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int now = 0;
        int cookieIndex = 0;
        
        while (cookieIndex < s.length && now < g.length) {
            if (s[cookieIndex] >= g[now]) {
                now++;
            }
            cookieIndex++;
        }
        return now;
    }

}