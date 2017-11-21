package com.javazuki.samples.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {

  @Test public void testMatcherUsage() throws Exception {

    String input = "cat dog cap";

    Pattern pattern = Pattern.compile("ca.");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      String matched = matcher.group();
      System.out.printf("[%s] がマッチしました。 Pattern:[%s] input:[%s]\n", matched, pattern, input);
    }

  }

  @Test public void testMatcherGroupMethod() throws Exception {

    String input = "cat dog cap";

    Pattern pattern = Pattern.compile("ca.");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      String matched = matcher.group();
      System.out.printf("[%s] が抽出されました。\n", matched);
    }

  }

}
