package com.company.first;
import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new SecureRandom();
        int val = rand.nextInt(21);
        new Window(val);
    }
}