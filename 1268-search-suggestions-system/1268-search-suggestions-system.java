class Solution 
{
    class TrieNode
    {
        TrieNode links[]=new TrieNode[26];
        boolean end=false;
    }
    
    class Trie
    {
        TrieNode root;
        
        Trie()
        {
            root=new TrieNode();
        }
        
        public void insert(String word)
        {
            TrieNode temp=root;
            for(int i=0;i<word.length();i++)
            {
                if(temp.links[word.charAt(i)-'a']==null)
                temp.links[word.charAt(i)-'a']=new TrieNode();
                
                temp=temp.links[word.charAt(i)-'a'];
            }
            temp.end=true;
        }
        
        public List<String> prefix(String word)
        {
            TrieNode temp=root;
            List<String> ans=new ArrayList<>();
            String s="";
            
            for(int i=0;i<word.length();i++)
            {
                if(temp.links[word.charAt(i)-'a']==null)
                return ans;
                
                temp=temp.links[word.charAt(i)-'a'];
                s+=Character.toString(word.charAt(i));
            }
            
            if(temp.end==true)
            ans.add(s);
            
            for(int i=0;i<26;i++)
            {
                if(temp.links[i]!=null)
                {
                    getWords(temp.links[i],ans,s+Character.toString((char)(i+'a')));
                    if(ans.size()>=3)
                    return ans;
                }
            }
            
            return ans;
        }
        
        public void getWords(TrieNode head,List<String> ans,String s)
        {
            if(head.end==true)
            {
                ans.add(s);
            }
            
            if(ans.size()>=3)
            return;
            
            for(int i=0;i<26;i++)
            {
                if(head.links[i]!=null)
                {
                    getWords(head.links[i],ans,s+Character.toString((char)(i+'a')));
                    
                    if(ans.size()>=3)
                    return;
                }
            }
            
            return;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        List<List<String>> ans=new ArrayList<>();
        Trie trie=new Trie();
        
        for(int i=0;i<products.length;i++)
        {
            trie.insert(products[i]);
        }
        
        String s="";
        for(int i=0;i<searchWord.length();i++)
        {
            s+=Character.toString(searchWord.charAt(i));
            List<String> temp=trie.prefix(s);
            ans.add(temp);
        }
        
        return ans;
    }
}