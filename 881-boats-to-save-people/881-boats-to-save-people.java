class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left =0;
        int right = people.length-1;

        Arrays.sort(people);

        int count = 0;
        while(right>=left){
            if(people[right] +  people[left] <=limit) left++;

            count++; 
            right--;
        }

        return count;
    }
}

