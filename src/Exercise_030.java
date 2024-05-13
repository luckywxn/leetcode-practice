import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise_030 {
    public static void main(String[] args) {
        Exercise_030 exercise_030 = new Exercise_030();
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","good"};
//        String s = "aaaaaaaaaaaaaa";
//        String[] words = new String[]{"aa","aa"};
        String s = "ababaab";
        String[] words = new String[]{"ab","ba","ba"};
        System.out.println(exercise_030.findSubstring(s, words));
    }

    /**
     * String s = "ababaab";
     * String[] words = new String[]{"ab","ba","ba"};
     * 此测试用例通不过
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return result;
        }
        int deleteLength = 0;
        int wordsLength = words[0].length() * words.length;
        while (s.length() > 0){
            int count = 0;
            int min = Integer.MAX_VALUE;
            int currentIndex;
            if (s.length() < wordsLength){
                break;
            }
            String leftStr = s.substring(0, wordsLength);
            for (String word : words) {
                currentIndex = leftStr.indexOf(word);
                if (currentIndex >= 0){
                    count ++;
                    leftStr = leftStr.substring(0,currentIndex) + leftStr.substring(currentIndex + word.length());
                }
                if (currentIndex < min && currentIndex != -1){
                    min = currentIndex;
                }
            }
            if (count == words.length){
                result.add(deleteLength + min);
            }
            s = s.substring(1);
            deleteLength ++;
        }
        return result;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.merge(w, 1, Integer::sum);
        }
        int m = s.length(), n = words.length;
        int k = words[0].length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            Map<String, Integer> cnt1 = new HashMap<>();
            int l = i, r = i;
            int t = 0;
            while (r + k <= m) {
                String w = s.substring(r, r + k);
                r += k;
                if (!cnt.containsKey(w)) {
                    cnt1.clear();
                    l = r;
                    t = 0;
                    continue;
                }
                cnt1.merge(w, 1, Integer::sum);
                ++t;
                while (cnt1.get(w) > cnt.get(w)) {
                    String remove = s.substring(l, l + k);
                    l += k;
                    cnt1.merge(remove, -1, Integer::sum);
                    --t;
                }
                if (t == n) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}
