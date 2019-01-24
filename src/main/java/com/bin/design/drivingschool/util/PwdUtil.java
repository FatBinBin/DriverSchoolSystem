package com.bin.design.drivingschool.util;

public class PwdUtil {
    public static String getPassword(){
        String pwd = "";
        for (int j = 0; j < 6; j++) {
            double rand = Math.random();
            double randTri = Math.random() * 3;
            if (randTri >= 0 && randTri < 1) {
                pwd = pwd + (char) (rand * ('9' - '0') + '0');
                //System.out.print((char) (rand * ('9' - '0') + '0'));
            } else if (randTri >= 1 && randTri < 2) {
                pwd = pwd + (char) (rand * ('Z' - 'A') + 'A');
                //System.out.print((char) (rand * ('Z' - 'A') + 'A'));
            } else {
                pwd = pwd + (char) (rand * ('z' - 'a') + 'a');
                //System.out.print((char) (rand * ('z' - 'a') + 'a'));
            }
        }
        return pwd;
    }
}
