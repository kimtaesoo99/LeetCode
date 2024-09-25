class TrieNode {

    TrieNode[] next = new TrieNode[26];
    int cnt = 0;
}

class Solution {

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node.next[c - 'a'].cnt++;
            node = node.next[c - 'a'];
        }
    }

    int count(String s) {
        TrieNode node = root;
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += node.next[c - 'a'].cnt;
            node = node.next[c - 'a'];
        }
        return ans;
    }

    public int[] sumPrefixScores(String[] words) {
        int N = words.length;
        for (int i = 0; i < N; i++) {
            insert(words[i]);
        }
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = count(words[i]);
        }
        return scores;
    }
}