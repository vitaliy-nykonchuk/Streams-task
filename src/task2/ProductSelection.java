package task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProductSelection {
    public static void main(String[] args) {
        Map<String, Double> products = createProductsMap();
        double minPrice = 1.05;
        double maxPrice = 3.15;
        Map<String, Double> selectedProducts = filterProductsByPrice(products, minPrice, maxPrice);
        printSelectedProducts(selectedProducts);
    }

    private static Map<String, Double> createProductsMap() {
        Map<String, Double> products = new HashMap<>();
        products.put("Product1", 2.50);
        products.put("Product2", 1.99);
        products.put("Product3", 3.00);
        products.put("Product4", 1.05);
        products.put("Product5", 3.15);
        products.put("Product6", 2.75);
        return products;
    }

    private static Map<String, Double> filterProductsByPrice(Map<String, Double> products, double minPrice, double maxPrice) {
        return products.entrySet().stream()
                .filter(entry -> entry.getValue() <= maxPrice && entry.getValue() >= minPrice)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void printSelectedProducts(Map<String, Double> selectedProducts) {
        AtomicInteger counter = new AtomicInteger(1);
        selectedProducts.forEach((productName, price) -> System.out.println(counter.getAndIncrement() + ") " + productName + " - $" + price));
    }
}
