package com.test.javalearningapp;

public class Conversion {

    public static String DecToHex(int dec){
        return Integer.toHexString(dec);
    }

    public static String DecToOct(int dec){
        return Integer.toOctalString(dec);
    }

    public static String DecToBin(int dec){
        return Integer.toBinaryString(dec);
    }


    public static String HexToDec(String hex){
        int dec = Integer.parseInt(hex, 16);
        return String.valueOf(dec);
    }

    public static String HexToOct(String hex){
        int dec = Integer.parseInt(hex, 16);
        return Integer.toOctalString(dec);
    }

    public static String HexToBin(String hex){
        int dec = Integer.parseInt(hex, 16);
        return Integer.toBinaryString(dec);
    }


    public static String OctToDec(String oct){
        int dec = Integer.parseInt(oct, 8);
        return String.valueOf(dec);
    }

    public static String OctToHex(String oct){
        int dec = Integer.parseInt(oct, 8);
        return Integer.toHexString(dec);
    }

    public static String OctToBin(String oct){
        int dec = Integer.parseInt(oct, 8);
        return Integer.toBinaryString(dec);
    }


    public static String BinToDec(String bin){
        int dec = Integer.parseInt(bin, 2);
        return String.valueOf(dec);
    }

    public static String BinToHex(String bin){
        int dec = Integer.parseInt(bin, 2);
        return Integer.toHexString(dec);
    }

    public static String BinToOct(String bin){
        int dec = Integer.parseInt(bin, 2);
        return Integer.toOctalString(dec);
    }
}

