package com.zeni.model;

import com.zeni.logic.BankCard;
import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private String username;
  private String password;
  private Account account;  // Обліковий запис (може бути null)
  private List<BankCard> bankCards;
  
  public Person(String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.bankCards = new ArrayList<>();
  }
  
  public String getName() {
    return name;
  }
  
  public String getUsername() {
    return username;
  }
  
  public boolean login(String enteredPassword) {
    return password.equals(enteredPassword);
  }
  
  public Account getAccount() {
    return account;
  }
  
  public void setAccount(Account account) {
    this.account = account;
  }
  
  public List<BankCard> getBankCards() {
    return bankCards;
  }
  
  public void addBankCard(BankCard bankCard) {
    bankCards.add(bankCard);
  }
  
  public void displayInfo() {
    System.out.println("Імя: " + name);
    System.out.println("Нік нейм: " + username);
    
    if (account != null) {
      System.out.println("Номер акаунту: " + account.getAccountNumber());
      
      
      if (account.getOwner() == this) {
        System.out.println("You are the owner of this account.");
      } else {
        System.out.println("You are a trusted user of this account.");
      }
      
      List<BankCard> cards = account.getAssociatedCards();
      for (BankCard card : cards) {
        System.out.println("Номер карти: " + card.getCardNumber());
      }
    } else {
      System.out.println("No account information available.");
    }
  }
  public boolean authenticate(String enteredUsername, String enteredPassword) {
    return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
  }
  
  public static Person[] personCreate() {
    Person[] people = new Person[5];
    
    people[0] = new Person("Іван", "ivan123", "password123");
    people[1] = new Person("Марія", "maria456", "pass456");
    people[2] = new Person("Петро", "petro789", "securepass");
    people[3] = new Person("Ольга", "olga000", "123456");
    people[4] = new Person("Андрій", "andriy111", "andriy123");
    
    return people;
  }
}