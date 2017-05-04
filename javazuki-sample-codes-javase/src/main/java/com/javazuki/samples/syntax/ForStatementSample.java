package com.javazuki.samples.syntax;

public class ForStatementSample {

  public static void main(String[] args) {

    System.out.println("---基本for文の例---");

    int[] numbers = { 10, 60, 88 };
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      System.out.println("numbers[" + i + "]:" + number);
    }

    System.out.println("---基本for文の例（{}の省略）---");
    for (int i = 0; i < numbers.length; i++)
      System.out.println("numbers[" + i + "]:" + numbers[i]);
  }

}
