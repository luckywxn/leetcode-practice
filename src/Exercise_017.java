import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_017 {
    public static void main(String[] args){
        Exercise_017 ex = new Exercise_017();
        System.out.println(ex.letterCombinations("23"));

    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        String[] digitsArray = digits.split("");
        String[] digMap = {"2", "3", "4", "5", "6", "7", "8", "9"};
        String[][] strMap = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u","v"}, {"w", "x", "y", "z"}};

        List<String> result = new ArrayList<>();
        int index = Arrays.binarySearch(digMap, digitsArray[0]);
        for (int j = 0; j < strMap[index].length; j++){
            result.add(strMap[index][j]);
        }
        if (digitsArray.length == 1){
            return result;
        }

        for (int i = 1; i < digitsArray.length; i++){
            index = Arrays.binarySearch(digMap, digitsArray[i]);
            List<String> current = new ArrayList<>();
            for (int j = 0; j < strMap[index].length; j++){
                for (String item : result ) {
                    current.add(item + strMap[index][j]);
                }
            }
            result = current;
        }
        return result;
    }
}
