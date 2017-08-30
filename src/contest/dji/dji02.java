package contest.dji;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class dji02 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Date[] dateStr = new Date[n];
        SimpleDateFormat timeFormat = new SimpleDateFormat("MM.dd hh:mm:SSS");
        SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm:SSS");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd");
        String startOfDate = "03:00:00";
        //Date startOfDate = timeFormat2.parse("03:00:00");
        //System.out.println(startOfDate);
//        startOfDate.setMonth(8);
//        startOfDate.setDate(10);
//        System.out.println(startOfDate);
        String endOfDate = "02:59:59";

        for (int i = 0; i < n; i++) {
            dateStr[i] = timeFormat.parse(sc.nextLine());
        }

        HashMap<String,Long> map = new HashMap<>();


        Arrays.sort(dateStr);
        for (int i = 0; i < n; i++){
            map.put(dateFormat.format(dateStr[i]),0L);
        }
        int start;
        int end;
        for(int i = 0; i < n; i ++){
            String dataStr = dateFormat.format(dateStr[i]);
            while(dataStr ==null);

            dateStr[i].after(timeFormat.parse(dataStr +" " + startOfDate));


            dateStr[i].before(timeFormat.parse(dataStr +" " + endOfDate));
        }
    }
}
