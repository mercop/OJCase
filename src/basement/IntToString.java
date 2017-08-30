package basement;

/**
 * Created by mercop on 2017/8/13.
 *
 * int 转 String
 */

public class IntToString {

    //判断位数
    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

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
