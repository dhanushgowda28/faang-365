public class Largest3SameDigitNumberinString {

    public static void main(String[] args) {
        String num = "4818042931906802860005960222213336669500011846936171709111";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int l = num.length();
        int res = 0;
        if (l < 3)
            return "";

        boolean b = false;
        for (int i = 0; i < l - 2; i++) {
            char c = num.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < l && c == num.charAt(j)) {
                count++;
                if (count == 3) {
                    res = Math.max(c - '0', res);
                    i = i+2;
                    b = true;
                    break;
                }
                j++;
            }

        }
        String str = String.valueOf(res);
        return b ? str + str + str : "";
    }

}