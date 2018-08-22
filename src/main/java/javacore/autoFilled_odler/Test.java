package javacore.autoFilled_odler;
// Created by ZhangJian on 17/12/7.

import java.util.ArrayList;

public class Test {


    public static String autoFilled(String bondName) {
        String shortName = bondName;

        if (shortName.contains("A")) {
            shortName = shortName.substring(shortName.lastIndexOf("A"), shortName.length());
        }
        if (shortName.contains("B")) {
            shortName = shortName.substring(shortName.lastIndexOf("B"), shortName.length());
        }
        if (shortName.contains("C")) {
            shortName = shortName.substring(shortName.lastIndexOf("C"), shortName.length());
            shortName = shortName.replace("C", "Z");
        }
        if (shortName.contains("次")) {
            shortName = shortName.substring(shortName.lastIndexOf("次"), shortName.length());
            if (shortName.contains("次级")) {
                shortName = shortName.replace("次级", "Z");
            } else if (shortName.contains("次")) {
                shortName = shortName.replace("次", "Z");
            }
        }
        if (shortName.contains("优")) {
            shortName = shortName.substring(shortName.lastIndexOf("优"), shortName.length());
            if (shortName.contains("优先级")) {
                shortName = shortName.replace("优先级", "A");
            } else if (shortName.contains("优先")) {
                shortName = shortName.replace("优先", "A");
            } else if (shortName.contains("优")) {
                shortName = shortName.replace("优", "A");
            }
        }
        return shortName;
    }


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("15德宝天元2A2"); // C
//        arrayList.add("15德宝天元2B"); // C
//        arrayList.add("15德宝天元2C"); // B
//        arrayList.add("15德宝天元2A1"); // A
//        arrayList.add("15德宝天元1C"); // C
//        arrayList.add("15德宝天元1A1"); // C
//        arrayList.add("15德宝天元1A2"); // CBC
        arrayList.add("17华驭6A"); // C        arrayList.add("15德宝天元1A1"); // C
        arrayList.add("17华驭6B"); // C        arrayList.add("15德宝天元1A1"); // C
        arrayList.add("17华驭6C"); // C        arrayList.add("15德宝天元1A1"); // C



        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(Test.autoFilled(arrayList.get(i)));
        }
    }

}

