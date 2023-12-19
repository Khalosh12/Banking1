package com.zeni.ui;

import static com.zeni.logic.BankCardDisplay.displayAllCardsForAccount;
import static com.zeni.logic.ProductSells.makePurchase;
import static com.zeni.model.Account.refreshAccountBalance;

import com.zeni.logic.BankCard;
import com.zeni.model.Account;
import com.zeni.model.Currency;
import java.util.Scanner;
import com.zeni.model.Product;

public class MenuHandler {
  public static void startMenu(Account account, BankCard bankCard) {
    Scanner scanner = new Scanner(System.in);
    
    while (true)
    {
     
      System.out.println("1. Подивитись список карт"+"\n"+
      "2. Подивитись баланс"+"\n"+
      "3. Подивитись список продуктів"+"\n"+
      "4. Змінити валюту"+"\n"+
      "0. Вийти з програми");

      System.out.print("Виберіть опцію: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Ви обрали подивитись список карт");
          displayAllCardsForAccount(account);
          break;
        case 2:
          System.out.println("Ви обрали подивитись баланс");
          refreshAccountBalance(bankCard);
          System.out.println("Баланс" +account.getBalance());
          break;
        case 3:
          System.out.println("Ви обрали подивитись список продуктів");
          makePurchase(bankCard,Product.createProducts());
          break;
        case 0:
          System.out.println("Дякую за використання програми. До побачення!");
          System.exit(0);
          break;
        case 4:
          System.out.println("Ви обрали змінити валюту");
          
          System.out.println("Доступні валюти:");
          for (Currency currency : Currency.values()) {
            System.out.println(currency.getCode() + ": " + currency.getName());
          }
          
          System.out.print("Введіть код нової валюти: ");
          String newCurrencyCode = scanner.next();
          Currency newCurrency = Currency.getCurrencyByCode(newCurrencyCode);
          
          if (newCurrency != null) {
            bankCard.getLinkedAccount().changeCurrency(newCurrency);
            System.out.println("Валюта змінена успішно.");
          } else {
            System.out.println("Невірний код валюти.");
          }
          break;
        default:
          System.out.println("Невірний вибір. Спробуйте ще раз.");
          break;
      }
    }
  }
}
