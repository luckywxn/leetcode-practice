public class Exercise_029 {
    public static void main(String[] args) {
//        int dividend = 10, divisor = 3;
//        int dividend = -2147483648, divisor = -1;
        int dividend = -1010369383, divisor = -2147483648;
        long startTime = System.currentTimeMillis();
        System.out.println(new Exercise_029().divide(dividend, divisor));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public int divide2(long dividend, int divisor) {
        long res = 0;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1 ){
            return trueResult(dividend);
        }else if (divisor == -1){
            return trueResult(-dividend);
        }
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor){
            dividend -= divisor;
            res++;
        }
        return trueResult( isNegative ? -res : res);
    }

    public static int trueResult(long result) {
        if (result > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }else if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int quotient = 0;
        while (dividend <= divisor) {
            int currentDivisor = divisor;
            int currentQuotient = 1;
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && dividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                currentQuotient <<= 1;
            }
            quotient += currentQuotient;
            dividend -= currentDivisor;
        }
        return sign ? quotient : -quotient;
    }
}
