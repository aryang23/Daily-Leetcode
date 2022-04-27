class Solution {
    public double angleClock(int hour, int minutes) {
        //Each hour is 360/ 12 = 30 degrees
		int hVal = hour == 12 ? 0 : hour * 30;
		
		//12 to 1 is 30 degrees / 5 minutes = 6. Each minute is 6 degrees.
        double mVal = (double) minutes * 6;
        
        //We need to subtract some value from the hour value to compensate for the minutes.
        //When minutes hand moves, hour hand also moves a certain degree. We need to calculate that.
        double sub = (double) 30 / ((double) 60 / minutes);
        
        //Subtract hourVal & sub from minVal to get answer
        double ans = (double) Math.abs(mVal - hVal - sub);
        
        //If ans is more than 180, we need to find angle anti-clockwise, else clockwise
        return ans > 180 ? (double) 360 - ans : ans;
    }
}
