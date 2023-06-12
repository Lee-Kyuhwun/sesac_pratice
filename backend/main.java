package backend;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String str1 = "Java Study";

        System.out.println("str1.toLowerCase() = " + str1.toLowerCase());
        System.out.println("str1.toUpperCase() = " + str1.toUpperCase());

        System.out.println("str1.replace(\"Study\",\"\") = " + str1.replace("Study","공부"));

        System.out.println("str1.substring(0,5) = " + str1.substring(0,5));

        String[] strArray = "abc/def-ghi jkl".split("/|-| ");
        System.out.println(Arrays.toString(strArray)); //[abc, def, ghi, jkl]
        System.out.println("str1.trim() = " + str1.trim());
    }
}