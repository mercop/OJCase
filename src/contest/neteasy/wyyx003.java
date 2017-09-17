package contest.neteasy;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mercop on 2017/9/16.
 */
public class wyyx003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str =sc.next();
        if(n == 1) {
            System.out.println(str);
            return;
        }
        getAllCombinations(str,"");
        for(String res :hashSet)
            System.out.println(res);
    }
    static HashSet<String> hashSet = new HashSet<>();
    public static void getAllCombinations(String str, String res){
        String newStr = str.substring(1,str.length()) ;
        res = str.charAt(0) + res;
        String setStr = newStr + res;
        if(hashSet.contains(setStr)) return;
        else hashSet.add(setStr);
        getAllCombinations(newStr,res);
    }
}
