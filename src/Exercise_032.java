import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Exercise_032 {
    public static void main(String[] args) {
        Exercise_032 exercise_032 = new Exercise_032();
//        String s = "(()";
//        String s = ")()())";
        String s = ")(())))(())())";
        System.out.println(exercise_032.longestValidParentheses2(s));
    }

    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int max = 0;
        while (s.length() >= 2){
            String currentStr = s;
            while (currentStr.length() >= 2 ) {
                if (isValid(currentStr)) {
                    max = Math.max(max, currentStr.length());
                    break;
                }
                currentStr = currentStr.substring(0,currentStr.length() - 1);
            }
            s = s.substring(1);
        }
        return max;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if ((c == ')' && stack.peek() != '(')) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
