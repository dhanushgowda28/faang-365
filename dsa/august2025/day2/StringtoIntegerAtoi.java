public class StringtoIntegerAtoi {

    public static void main(String[] args) {

        String str = "    -042";
        System.out.println(myAtio(str));
    }

    public static int myAtio(String str) {
        int l = str.length();

        if (l == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) != ' ') {
                j = i;
                break;
            }
        }
        boolean b = false;
        if (str.charAt(j) == '-') {
            j++;
            b = true;
        }
        int res = 0;
        for (int i = j; i < l; i++) {
            char c = str.charAt(i);
            int temp = c - '0';

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return Integer.MAX_VALUE;

            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return Integer.MIN_VALUE;

            }
            if (c >= '0' && c <= '9') {
                res = res * 10 + temp;
            } else {
                break;
            }
        }
        if (res == 0)
            return 0;

        return b ? -res : res;

    }
}