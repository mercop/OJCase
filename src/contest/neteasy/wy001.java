package contest.neteasy;

import java.util.Scanner;

/**
 * Created by mercop on 2017/9/9.
 */


public class wy001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );
        int n = sc.nextInt();
        int num0, num1, num2, len = 0;
        int j;
        for (int i = 0; i < n; i++) {
            len = sc.nextInt();
            num0 = 0;
            num1 = 0;
            num2 = 0;
            for (j = 0; j < len; j++) {
                int num = sc.nextInt();
                if (num % 4 == 0) {
                    num2++;
                } else if (num % 2 == 0) {
                    num1++;
                } else {
                    num0++;
                }
            }
            if (num0 > num2 + 1) {
                System.out.println("No");
            } else if ((num1 == 1 && num0 == num2 + 1)) {
                System.out.println("No");
            } else
                System.out.println("Yes");
        }
    }
}