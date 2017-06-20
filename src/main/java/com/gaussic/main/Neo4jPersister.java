package com.gaussic.main;

import com.gaussic.model.Product;
import com.gaussic.model.User;
import com.gaussic.repository.ProductRepository;
import com.gaussic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: rkowalewski
 */
@Component
@Transactional
public class Neo4jPersister {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public UserRepository userRepository;

    private void userClickedProduct(User user, Product product) {

        user.addClickedProduct(product);

        userRepository.save(user);
        productRepository.save(product);
    }

    private Product createProduct(String id, String name) {
        return productRepository.save(new Product(id, name));
    }

    private User createUser(String id, String name) {
        return userRepository.save(new User(id, name));
    }
    
    public void createTestData() {
        User jordan = createUser("MJ", "Monika Jordan");
        User pippen = createUser("SP", "Sandra Pippen");
        User miller = createUser("JM", "John Miller");

        Product pizzaMargarita = createProduct("Pizza_1", "Pizza Margarita");
        Product pizzaFungi = createProduct("Pizza_2", "Pizza Fungi");
        Product pizzaSalami = createProduct("Pizza_3", "Pizza Salami");
        Product pizzaVegitarian = createProduct("Pizza_4", "Pizza Vegitarian");
        Product pizzaRustica = createProduct("Pizza_5", "Pizza Rustica");

        userClickedProduct(jordan, pizzaMargarita);
        userClickedProduct(jordan, pizzaFungi);
        userClickedProduct(jordan, pizzaSalami);

        userClickedProduct(pippen, pizzaMargarita);
        userClickedProduct(pippen, pizzaVegitarian);
        userClickedProduct(pippen, pizzaRustica);
        userClickedProduct(pippen, pizzaMargarita);
        userClickedProduct(pippen, pizzaVegitarian);

        userClickedProduct(miller, pizzaFungi);
    }

}
