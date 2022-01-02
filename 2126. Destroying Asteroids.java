class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long masss = mass;
        for(int asteroid:asteroids)
        {
            if((long) asteroid > masss)
                return false;
            masss += asteroid;
        }
        return true;
    }
}
