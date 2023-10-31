class Solution {
    public int[] findArray(int[] pre) {
        int n = pre.length;
        int[] arr = new int[n];
        
        arr[0] = pre[0];
        for (int i = 1; i < n; i++) {
            arr[i] = pre[i] ^ pre[i - 1];
        }

        return arr;
    }
}
