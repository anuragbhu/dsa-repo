public class ReverseBits {
    public long reverse(long a) {

        String str = "";
        while(a > 0) {
            long temp = (long) a % 2;
            str += Long.toString(temp);
            a /= 2;
        }

        int len = 32 - str.length();

        for(int i = 0; i < len; i++) {
            str += "0";
        }

        int pow = 31;
        long res = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            long y = ch - '0';
            res += y * Math.pow(2, pow);
            pow--;
        }

        return res;
    }

    public long reverse1(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;

    }
}
