package com.zeni;

import static com.zeni.ui.MenuHandler.startMenu;
import com.zeni.model.Account;
import com.zeni.logic.BankCard;
import com.zeni.logic.AuthenticationService;
import com.zeni.model.Person;
import com.zeni.model.Product;


public class Main {
  
  public static void main(String[] args) {
    Person[] people = Person.personCreate();
    Account.createAccountsForPeople(people);
    
    Product[] product =Product.createProducts();
    Person authenticatedPerson = AuthenticationService.performAuthentication(people);
    BankCard card = BankCard.generateBankCardForAccount(authenticatedPerson.getAccount());
   
    if (authenticatedPerson != null) {
      System.out.println("Авторизація пройшла успішно!");
      authenticatedPerson.displayInfo();
      card.displayInfo();
      startMenu(authenticatedPerson.getAccount(),card);
    } else {
      System.out.println("Невірне ім'я користувача або пароль.");
    }
  }
}