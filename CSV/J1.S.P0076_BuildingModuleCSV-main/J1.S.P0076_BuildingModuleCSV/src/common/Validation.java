package common;

import java.io.File;
import java.util.Scanner;

public class Validation {
    
    public String inputString(String title){
        String s="";
        while(s.isBlank() || s.isEmpty()){
            System.out.print(title+ ": ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }
        return s;
    }
    public boolean checkFileExist(String pathname) {
        File file = new File(pathname);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }
}
