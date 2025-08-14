import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {

        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        int time = 0;
        for (int i = piles[0]; i <= piles[piles.length - 1]; i++) {
            int minTime = 0;
            for (int j = 0; j < piles.length; j++) {
                int pile = piles[j];
                while (pile > 0) {
                    pile -= i;
                    minTime++;
                }
            }
            if (minTime == h) {
                time = i;
                break;
            }
        }
        return time;
    }

}
