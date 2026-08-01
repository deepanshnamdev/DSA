class Node{
    Node []array=new Node[26];
    boolean flag=false;
    boolean contain(char ch){
        return array[ch-'a']!=null;
    }
    void put(char ch, Node node){
        array[ch-'a']=node;
    }
    Node get(char ch){
        return array[ch-'a'];
    }
    void end(){
        flag=true;
    }
    boolean isend(){
        return flag;
    }

}
class Trie {
    public Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contain(ch)){
                node.put(ch,new Node());
            }
            node =node.get(ch);
        }
        node.end();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contain(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return node.isend();
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.contain(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */