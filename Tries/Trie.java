public class Trie {

    TrieNode root;

    Trie(){
        root=new TrieNode();
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        TrieNode(){
            this.children=new TrieNode[26];
        }
    }

    void insert(String word){
        TrieNode current=root;

        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            int index=ch-'a';

            if(current.children[index]==null){
                TrieNode node=new TrieNode();
                current.children[index]=node;
                current=node;
            }else{
                current=current.children[index];
            }
        }
        current.isWord=true;
    }

    public  boolean search(String word) {
        TrieNode curr = root;
  
        for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
  
          if (curr.children[ch - 'a'] == null)return false;
          curr = curr.children[ch - 'a'];
        }
  
        return curr.isWord;
      }

      public boolean startsWith(String prefix) {
        TrieNode curr = root;
  
        for (int i = 0; i < prefix.length(); i++) {
          char ch = prefix.charAt(i);
  
          if (curr.children[ch - 'a'] == null)return false;
          curr = curr.children[ch - 'a'];
        }
  
        return true;
      }
    
  
    public static void main(String[] args) {
        Trie trie = new Trie();
	trie.insert("cat");
	trie.insert("cab");
	trie.insert("son");
	trie.insert("so");
	System.out.println("Values inserted successfully !!!");
    System.out.println(trie.startsWith("so"));
    }
}
