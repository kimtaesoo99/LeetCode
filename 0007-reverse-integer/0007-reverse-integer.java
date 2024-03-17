class Solution {
    public int reverse(int x) {
        long res = 0;
        if (x < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(x).substring(1));
            sb.reverse();
            res = Long.parseLong(sb.toString()) * -1;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            sb.reverse();
            res = Long.parseLong(sb.toString());
        }
        
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) res;       
    }
}