package com.javazuki.samples.javase.array;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ArrayTest {

  /**
   * 「EFFECTIVE JAVA 第2版」P.116より引用。<br/>
   * コンパイルエラーにならず、実行時にArrayStoreExceptionになる。
   */
  @Test(expected = ArrayStoreException.class) public void testVariant() {
    Object[] objectArray = new Long[1];
    objectArray[0] = "I don't fit in";
  }

  /**
   * 参照型による配列→List変換の検証
   */
  @Test public void testReferenceArrayConvertToList() throws Exception {
    String[] arrayMessages = { "good morning", "hello", "good afternoon" };
    List<String> listMessages = Arrays.asList(arrayMessages);

    assertThat("good morning", is(listMessages.get(0)));
    assertThat("hello", is(listMessages.get(1)));
    assertThat("good afternoon", is(listMessages.get(2)));
  }

  /**
   * プリミティブ型による配列→List変換の検証<br/>
   * プリミティブ型の場合は、 Arrays.asList()ではダメ。
   */
  @Test public void testPrimitiveArrayConvertToList() throws Exception {
    int[] arrayScores = { 30, 80, 40 };

    List<Object> fromAsListScores = Arrays.asList(arrayScores);
    assertThat(30, is(not(fromAsListScores.get(0))));
    System.out.println(fromAsListScores);

    List<Integer> listScores = Arrays.stream(arrayScores)
                                     .mapToObj(Integer::valueOf)
                                     .collect(Collectors.toList());
    assertThat(30, is(listScores.get(0)));
    assertThat(80, is(listScores.get(1)));
    assertThat(40, is(listScores.get(2)));
  }

  @Test public void testEqualsArray() throws Exception {
    int[] firstArray = { 30, 80, 40 };
    int[] secondArray = { 30, 80, 40 };

    assertThat(firstArray.equals(secondArray), is(false));
    assertThat(Arrays.equals(firstArray, secondArray), is(true));

    System.out.println("firstArray.equals(secondArray) is " + firstArray.equals(secondArray));
    System.out.println("Arrays.equals(firstArray, secondArray) is " + Arrays.equals(firstArray, secondArray));

  }

}
