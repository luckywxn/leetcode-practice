import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_022 {
    public static void main(String[] args){
        Exercise_022 ex = new Exercise_022();
        System.out.println(ex.generateParenthesis(3));
    }

    public List<String> generateParenthesis2(int n) {
        Character[] arr1 = new Character[n];
        Character[] arr2 = new Character[n];
        Arrays.fill(arr1, '(');
        Arrays.fill(arr2, ')');
        Character[] arr = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(Character[]::new);
        List<List<Character>> permutations = permute(arr);
        permutations = permutations.stream().filter(list -> isValid(list)).distinct().collect(Collectors.toList());
        List<String> result = permutations.stream().map(list -> joinCharacters(list)).collect(Collectors.toList());
        return result;
    }

    public static List<List<Character>> permute(Character[] nums) {
        List<List<Character>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            Character removedNum = nums[i];
            Character[] remaining = new Character[nums.length - 1];
            System.arraycopy(nums, 0, remaining, 0, i);
            System.arraycopy(nums, i + 1, remaining, i, nums.length - i - 1);

            List<List<Character>> subPermutations = permute(remaining);
            for (List<Character> subPerm : subPermutations) {
                subPerm.add(0, removedNum);
                result.add(subPerm);
            }
        }
        return result;
    }

    public static boolean isValid(List<Character> characterList) {
        Stack<Character> stack = new Stack<>();
        for (char c : characterList) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() != '(') {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static String joinCharacters(List<Character> characters) {
        List<String> strings = characters.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        return String.join("", strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 如果当前已经生成了max对括号，加入结果集
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 如果当前左括号数量小于max，可以继续添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 如果当前右括号数量小于左括号数量，可以继续添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
