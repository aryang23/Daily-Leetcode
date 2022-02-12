class Solution {
public:

void make_set(vector<int>& parent,vector<int>& size ,int v){
    parent[v] = v;
    size[v] = 1;
}
int find_set(vector<int>&parent,int v){
    if(v == parent[v])
        return v;
    return parent[v] = find_set(parent,parent[v]);
}

void union_set(vector<int>& parent,vector<int>& size, int a, int b){
    a = find_set(parent,a);
    b = find_set(parent,b);
    
    if(a!=b){
        if(size[a]<size[b])
            swap(a,b);
        parent[b] = a;
        size[a]+=size[b];
    }
}
int findCircleNum(vector<vector<int>>& arr) {
    int n = arr.size();
    int default_value = -1;
    vector<int> parent(n,default_value);
    vector<int> size(n, default_value);
    
    for(int i = 0;i<n;i++)
        make_set(parent,size,i);
    
    for(int i = 0;i<n;i++){
        for(int j =0;j<n;j++)
            if(arr[i][j])
                union_set(parent,size,i,j);
    }
    set<int> s;
    for(int i =0;i<n;i++)
        s.insert(find_set(parent,i));
    
    return s.size();
}
};
