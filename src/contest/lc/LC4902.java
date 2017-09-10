package contest.lc;

/**
 * Created by mercop on 2017/9/10.
 */
public class LC4902 {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode","hallo"});
        System.out.println(magicDictionary.search("leetcodd"));
    }
}

class MagicDictionary {

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trieTree = new TrieTree();
    }

    TrieTree trieTree;

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (int i = 0; i < dict.length; i++) {
            trieTree.insert(dict[i]);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return trieTree.hasMagicString(word);
    }

    static class TrieTree {

        private int SIZE = 26;
        private TrieNode root;//字典树的根
        private int level;

        TrieTree() //初始化字典树
        {
            root = new TrieNode();
        }

        private class TrieNode //字典树节点
        {
            private TrieNode[] son;//所有的儿子节点
            private boolean isEnd;//是不是最后一个节点
            private char val;//节点的值

            TrieNode() {
                son = new TrieNode[SIZE];
                isEnd = false;
            }
        }

        //建立字典树
        public void insert(String str) //在字典树中插入一个单词
        {
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode node = root;
            char[] letters = str.toCharArray();
            level = Integer.max(level, letters.length);
            for (int i = 0, len = str.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                    node.son[pos].val = letters[i];
                }
                node = node.son[pos];
            }
            node.isEnd = true;
        }


        //在字典树中查找一个完全匹配的单词.
        public boolean hasMagicString(String str) {
            if (str == null || str.length() == 0 || str.length() > level) {
                return false;
            }
            TrieNode node = root;
            char[] letters = str.toCharArray();
            int n = letters.length;
            for (int i = 0, len = str.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                for (int j = 0; j < 26; j++) {
                    if (node.son[j] != null && j != pos) {
                        if(i == len -1) return node.son[j].isEnd;
                        if (has(node.son[j], str.substring(i + 1, n)))
                            return true;
                    }
                }
                if (node.son[pos] != null) {

                    node = node.son[pos];
                }
            }
            return false;
        }

        public boolean has(TrieNode node, String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            char[] letters = str.toCharArray();
            for (int i = 0, len = str.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] != null) {
                    node = node.son[pos];
                } else {
                    return false;
                }
            }
            return node.isEnd;
        }
    }
}



