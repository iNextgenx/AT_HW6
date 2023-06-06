package ru.netology.web.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }


  public static VerificationCode getVerificationCode() {
    return new VerificationCode("12345");
  }

  public static CardInfo getFirstCardInfo(){
    return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
  }

  public static CardInfo getSecondCardInfo(){
    return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
  }

  public static int  generateRndValidAmount (int amount) {
    return new Random().nextInt(amount) + 1;
  }

  public static int generateRndInvalidAmount (int amount) {
    return Math.abs(amount) + new Random().nextInt(10000);
  }

  @Value
  public static class VerificationCode {
    String code;
  }

  @Value
  public static class CardInfo {
    String cardNumber;
    String testId;
  }

}


