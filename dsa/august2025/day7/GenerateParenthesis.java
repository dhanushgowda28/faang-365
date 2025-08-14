import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        formPar(0, 0, "", n, res);
        return res;
    }

    public static void formPar(int open, int closed, String s, int n, List<String> res) {

        if (open == closed && s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (open < n) {
            formPar(open + 1, closed, s + "(", n, res);
        }

        if (closed < open) {
            formPar(open, closed + 1, s + ")", n, res);
        }

    }

}
