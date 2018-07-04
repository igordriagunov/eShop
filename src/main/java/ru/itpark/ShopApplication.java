package ru.itpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.itpark.entity.Product;
import ru.itpark.repository.ProductRepository;
import ru.itpark.service.ProductService;
//

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ShopApplication.class, args);
//        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
////        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        ProductService service = context.getBean(ProductService.class);
        ProductRepository repository = context.getBean(ProductRepository.class);

//        service.save(
//                new Product(
//                        0,
//                        "xiaomi",
//                        "phone made in china",
//                        100,
//                        12500
//                )
//        );


//        accountRepository.saveAll(
//                List.of(
//                        new Account(
//                                0,
//                                "admin",
//                                "user@mail.ru",
//                                encoder.encode("admin"),
//                                List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                                true,
//                                true,
//                                true,
//                                true
//                        )
//                )
//        );
    }
}
