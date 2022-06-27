class Solution {
    public int minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}
