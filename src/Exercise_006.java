import java.util.Arrays;

public class Exercise_006 {
    public static void main(String[] args) {
        Exercise_006 exercise006 = new Exercise_006();
        System.out.println(exercise006.convert("AB",1));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr,"");
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            arr[curRow] += c;
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        return String.join("", arr);
    }

}