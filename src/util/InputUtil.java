package util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new java.util.Scanner(System.in);

    public static String input(String info){
        System.out.print(info);
        var data = scanner.nextLine();
        return data;
    }
}