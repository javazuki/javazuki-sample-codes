package com.javazuki.samples.javase.array;

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

}
