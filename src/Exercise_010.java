import java.util.regex.Pattern;

public class Exercise_010 {
    public static void main(String[] args){
        Exercise_010 ex = new Exercise_010();
        String s = "abc";
        String p = "a***abc";
        System.out.println(ex.isMatch(s, p));
    }

    public boolean isMatch(String s, String p){
        p = p.replaceAll("\\*+", "*");
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
