package ru.stqa.aqa.sandbox;

public class Equlity {

    public static void main(String[] args){
        String s1 = "firefox";
        String s2 = s1;

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
