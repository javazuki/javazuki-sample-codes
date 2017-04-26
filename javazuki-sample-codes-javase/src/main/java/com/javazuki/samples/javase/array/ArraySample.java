package com.javazuki.samples.javase.array;

import java.util.Arrays;

public class ArraySample {

  public static void main(String[] args) {

    {
      int[] scores = { 30, 80, 40 };

      System.out.println("scores[0]:" + scores[0]);
      System.out.println("scores[1]:" + scores[1]);
      System.out.println("scores[2]:" + scores[2]);
    }

    {
      int[] scores = { 30, 80, 40 };
      System.out.println("scores.toString()による出力:" + scores.toString());
      System.out.println("Arrays.toString(scores)による出力:" + Arrays.toString(scores));
    }
  }

}
