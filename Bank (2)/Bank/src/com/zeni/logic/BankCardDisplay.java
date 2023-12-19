package com.zeni.logic;
import com.zeni.logic.BankCard.CardDisplay;
import com.zeni.model.Account;
import java.util.List;

public interface BankCardDisplay {
  public static void displayAllCardsForAccount(Account account) {
    List<BankCard> cards = account.getAssociatedCards();
    
    System.out.println("Карти, прив'язані до акаунту " + account.getAccountNumber() + ":");
    
    CardDisplay cardDisplay = new CardDisplay() {
      @Override
      public void displayCard(BankCard card) {
        System.out.println("Номер карти: " + card.getCardNumber());
        System.out.println("Баланс: " + card.getBalance());
        System.out.println();
      }
    };
    
    for (BankCard card : cards) {
      cardDisplay.displayCard(card);
    }
  }
}
