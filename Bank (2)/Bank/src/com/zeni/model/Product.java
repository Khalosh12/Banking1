package com.zeni.model;

public class Product {
  private String name;
  private String description;
  private double price;
  
  public Product(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  public static Product[] createProducts() {
    Product[] products = new Product[10];
    
    products[0] = new Product("Молоко", "Натуральне коров'яче молоко", 25.0);
    products[1] = new Product("Хліб", "Пшеничний хліб", 15.0);
    products[2] = new Product("Яйця", "Дерев'яний пакет, 10 штук", 30.0);
    products[3] = new Product("Фрукти", "Асорті зимових фруктів", 50.0);
    products[4] = new Product("М'ясо", "Свіжа курка", 70.0);
    products[5] = new Product("Овочі", "Суміш свіжих овочів", 40.0);
    products[6] = new Product("Кава", "Арабіка, 250 г", 80.0);
    products[7] = new Product("Чай", "Чорний чай, 100 г", 15.0);
    products[8] = new Product("Паста", "Макарони, 500 г", 20.0);
    products[9] = new Product("Сир", "Гауда, 200 г", 45.0);
    
    return products;
  }
}
