public class Exercise_008 {
    public static void main(String[] args){
        Exercise_008 ex = new Exercise_008();
        String s = "   +0 123";
        System.out.println(ex.myAtoi(s));
    }
    public int myAtoi(String s) {
        boolean isNegative = false;
        int intresult = 0;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' && builder.length() == 0){
                continue;
            }
            if((s.charAt(i) == '-' || s.charAt(i) == '+') && builder.length() == 0){
                builder.append(s.charAt(i));
                continue;
            }
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                builder.append(s.charAt(i));
            }else {
                break;
            }
        }
        if(builder.length() > 0){
            if(builder.charAt(0) == '-'){
                isNegative = true;
            }
            if(builder.charAt(0) == '+'){
                isNegative = false;
            }
            if(builder.charAt(0) == '-' || builder.charAt(0) == '+'){
                builder.deleteCharAt(0);
            }
            if(builder.length() > 0){
                try {
                    intresult = Integer.parseInt(builder.toString());
                } catch (NumberFormatException e) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }

        if(isNegative){
            if(- intresult < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return -intresult;
            }
        }else{
            if(intresult > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return intresult;
            }
        }
    }
}
