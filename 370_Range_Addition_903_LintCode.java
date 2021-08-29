//Good Algo
public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] queries) {
        int[] res = new int[length];

        //Provides impact to res
        for(int q=0;q<queries.length;q++)
        {
            int st = queries[q][0];
            int end = queries[q][1];
            int inc = queries[q][2];

            res[st]+=inc;
            if(end+1<length)
            {
                res[end+1]-=inc;
            }
        }

        //prefix sum
        int sum = 0;
        for(int i=0;i<length;i++)
        {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
