package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
public class GiftCardTest {
  
  @Test
  public void getIssuingStore() {
    
      double balance;
      GiftCard card;
      int issuingStore;
      
      issuingStore = 1337;
      balance = 100.00;
      card = new GiftCard(issuingStore, balance);
      
      assertEquals("getIssuingStore()",issuingStore, card.getIssuingStore());
  }
  
  @Test
  public void getBalance() {
    
    double balance;
    GiftCard card;
    int issuingStore;
    
    issuingStore = 1337;
    balance = 100.00;
    card = new GiftCard(issuingStore, balance);
    
    assertEquals("getBalance()",
        balance, card.getBalance(),0.001);
  }
  
  @Test
  public void deductInvalid() {
    
    double balance;
    GiftCard card;
    int issuingStore;
    
    issuingStore = 1337;
    balance = 100.00;
    card = new GiftCard(issuingStore, balance);
    
    double amount = -50.00;
    
    String result = "Invalid Transaction";
    
    assertEquals("deduct()",result, card.deduct(amount));
    
  }
  
  @Test
  public void deductOverdraw() {
    
    double balance;
    GiftCard card;
    int issuingStore;
    
    issuingStore = 1337;
    balance = 100.00;
    card = new GiftCard(issuingStore, balance);
    
    double amount = 150.00;
    
    balance -= amount;
    
    String result = "Amount Due: " + String.format("%6.2f",
        Math.abs(balance));
    
    assertEquals("deduct()",result,card.deduct(amount));
    
  }
  @Test
  public void deduct() {
    
    double balance;
    GiftCard card;
    int issuingStore;
    
    issuingStore = 1337;
    balance = 100.00;
    card = new GiftCard(issuingStore, balance);
    
    double amount = 75.00;
    
    balance -= amount;
    
    String result = "Remaining Balance: " + String.format("%6.2f",
        Math.abs(balance));
    
    assertEquals("deduct()",result,card.deduct(amount));
    
  }
  
  @Test
  public void testBalanceException() {
    
    assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
    
  }
  
  @Test
  public void testStoreIDException() {
    
    
    assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
    
  }
  
  @Test
  public void constructor_IncorrectID_High() {
    
    assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});

    
  }
}