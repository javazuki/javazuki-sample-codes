package com.javazuki.samples.javase.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UncaughtExceptionHandlerSample {
  private static final Logger log = LoggerFactory.getLogger(UncaughtExceptionHandlerSample.class);

  public static void main(String[] args) {
    Thread current = Thread.currentThread();
    current.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {
      log.error("キャッチできない例外発生", throwable);
    });

    throw new IllegalStateException("試しに例外を発生させた");
  }

}
