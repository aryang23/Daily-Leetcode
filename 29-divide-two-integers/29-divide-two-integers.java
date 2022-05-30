class Solution {
    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int neg = 2;
        if(dividend > 0) {
            neg--;
            dividend = -dividend;
        }
        if(divisor > 0) {
            neg--;
            divisor = -divisor;
        }
        
        int quotient = 0;
        while(dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }
        
        if(neg != 1) {
            quotient = -quotient;
        }
        return quotient;
    }
    
    public int divide3(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
    }
    int negatives = 2;
    if (dividend > 0) {
        negatives--;
        dividend = -dividend;
    }
    if (divisor > 0) {
        negatives--;
        divisor = -divisor;
    }
    int quotient = 0;
    while (dividend - divisor <= 0) {
        quotient--;
        dividend -= divisor;
    }
    if (negatives != 1) {
        quotient = -quotient;
    }
    return quotient;
}
    
    private static int HALF_INT_MIN = -1073741824;

    public int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            quotient += powerOfTwo;
            dividend -= value;
        }
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}