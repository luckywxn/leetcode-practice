import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exercise_020 {
    public static void main(String[] args){
        System.out.println(new Exercise_020().isValid("([}}])"));
    }

    public boolean isValid(String s){
        if(s.length() % 2 != 0) return false;
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("[")){
                list.add(arr[i]);
            }
            if(arr[i].equals(")") || arr[i].equals("}") || arr[i].equals("]")){
                if(list.size() == 0) return false;
                String last = list.get(list.size() - 1);
                if(arr[i].equals(")") && last.equals("(")){
                    list.remove(list.size() - 1);
                }else if(arr[i].equals(")") && !last.equals("(")){
                    return false;
                }
                if(arr[i].equals("}") && last.equals("{")){
                    list.remove(list.size() - 1);
                }else if(arr[i].equals("}") && !last.equals("{")){
                    return false;
                }
                if(arr[i].equals("]") && last.equals("[")){
                    list.remove(list.size() - 1);
                }else if(arr[i].equals("]") && !last.equals("[")){
                    return false;
                }
            }
        }
        return list.size() == 0;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if ((c == ')' && stack.peek() != '(') ||
                    (c == '}' && stack.peek() != '{') ||
                    (c == ']' && stack.peek() != '[')) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
