package basement;

/**
 * Created by mercop on 2017/8/13.
 *
 * int 转 String
 */

public class IntToString {

    public static void main(String[] args) {

        int num = 10022039;
        String result = "";
        while(num > 0){
            int digit =  num % 10;
            result += String.valueOf(digit);
            num /= 10;
        }

        System.out.println(result = reverse(result));
    }

    public static String reverse(String originStr){
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
