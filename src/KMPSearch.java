
import java.util.*;
public class KMPSearch {
    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) return matches;
        if (text == null || text.length() < pattern.length()) return matches;
        int[] lps = computeLPS(pattern);
        int n = text.length(), m = pattern.length();
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == m) {
                    matches.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return matches;
    }
    private static String listToString(List<Integer> list) {
        return list.toString();
    }
    public static void main(String[] args) {
        System.out.println("KMP Search Demo\n================\n");

        String textShort = "abacaba";
        String patternShort = "aba";
        long t0 = System.nanoTime();
        List<Integer> matchShort = kmpSearch(textShort, patternShort);
        long t1 = System.nanoTime();
        System.out.println("Short test:");
        System.out.println("  Text:    \"" + textShort + "\"");
        System.out.println("  Pattern: \"" + patternShort + "\"");
        System.out.println("  Matches at indices: " + listToString(matchShort));
        System.out.printf("  Time: %.3f ms\n\n", (t1 - t0) / 1e6);

        StringBuilder sbMed = new StringBuilder();
        for (int i = 0; i < 50; i++) sbMed.append("abcxabcdabxabcdabcdabcy");
        String textMed = sbMed.toString();
        String patternMed = "abcdabcy";
        t0 = System.nanoTime();
        List<Integer> matchMed = kmpSearch(textMed, patternMed);
        t1 = System.nanoTime();
        System.out.println("Medium test:");
        System.out.println("  Text length:    " + textMed.length());
        System.out.println("  Pattern:        \"" + patternMed + "\"");
        System.out.println("  Number of matches found: " + matchMed.size());
        System.out.println("  First matches (up to 10): " +
            matchMed.subList(0, Math.min(10, matchMed.size())));
        System.out.printf("  Time: %.3f ms\n\n", (t1 - t0) / 1e6);

        StringBuilder sbLong = new StringBuilder();
        for (int i = 0; i < 5000; i++)
            sbLong.append("thequickbrownfoxjumpsoverthelazydog");
        String textLong = sbLong.toString();
        String patternLong = "brownfox";
        t0 = System.nanoTime();
        List<Integer> matchLong = kmpSearch(textLong, patternLong);
        t1 = System.nanoTime();
        System.out.println("Long test:");
        System.out.println("  Text length:    " + textLong.length());
        System.out.println("  Pattern:        \"" + patternLong + "\"");
        System.out.println("  Number of matches found: " + matchLong.size());
        if (!matchLong.isEmpty())
            System.out.println("  First match index: " + matchLong.get(0));
        System.out.printf("  Time: %.3f ms\n\n", (t1 - t0) / 1e6);

        System.out.println("End of demo.");
    }
}
