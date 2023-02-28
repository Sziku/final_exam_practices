package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    private List<Product> products;

    public Storage(List<Product> products) throws IllegalArgumentException {
        if (products == null) {
            throw new IllegalArgumentException();
        }
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> findProductsOnlyValidToday() {
        return products.stream().filter(product -> product.expirationDate.equals(LocalDate.now())).toList();
    }

    public Set<String> getProductNamesInCategory(String category) {
        return products.stream().filter(product -> product.category.contains(category)).map(product -> product.name).collect(Collectors.toSet());
    }

    public int calculateMoneylossOfExpiredProducts() {
        return products.stream().filter(product -> product.expirationDate.isBefore(LocalDate.now())).mapToInt(product -> product.price).sum();
    }

    public List<String> listCategoriesOrderedByMoneylossDesc() {
        Map<String, Integer> categoryMoneyLost = new HashMap<>();
        for (Product product : products.stream().filter(product -> product.expirationDate.isBefore(LocalDate.now())).toList()) {
            for(String categoryName : product.category){
                if(categoryMoneyLost.containsKey(categoryName)){
                    categoryMoneyLost.put(categoryName, categoryMoneyLost.get(categoryName) + product.price);
                } else {
                    categoryMoneyLost.put(categoryName, product.price);
                }
            }
        }
        List<Map.Entry<String, Integer>> sortedEntryByValue = new ArrayList<>(categoryMoneyLost.entrySet());
        sortedEntryByValue.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sortedEntryByValue.stream().map(Map.Entry::getKey).toList();
    }

    public void removeAllExpiredProducts() {
        products.removeIf(product -> product.expirationDate.isBefore(LocalDate.now()));
    }
}
