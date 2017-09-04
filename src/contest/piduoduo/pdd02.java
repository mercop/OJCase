package contest.piduoduo;

import java.io.File;
import java.util.Scanner;
/**
 * Created by mercop on 2017/9/2.
 */

public class pdd02 {
    public static int depth = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String path = cin.nextLine();
        File dir = new File(path);
        dfs(dir,false);
    }

    public static void dfs(File parentDir,boolean isEnd) {
        depth ++;
        if(parentDir.isDirectory()) {
            print(parentDir,isEnd);
            File[] fileArr = parentDir.listFiles();
            int i = 0;
            for(; i < fileArr.length -1; i ++){
                dfs(fileArr[i],false);
            }
            dfs(fileArr[i],true);
        } else print(parentDir,isEnd);
        depth--;
    }

    public static void print(File f,boolean isEnd){
        for(int i=1; i<depth; i++) {
            System.out.print("   ");
        }
        if(isEnd){
            System.out.println("`--" + f.getName());
        } else System.out.println("|--" + f.getName());
    }
}