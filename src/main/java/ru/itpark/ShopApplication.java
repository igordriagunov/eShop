package ru.itpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.itpark.entity.Mobile;
import ru.itpark.entity.Product;
import ru.itpark.entity.Shirt;
import ru.itpark.repository.ProductRepository;
import ru.itpark.service.ProductService;
//


@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ShopApplication.class, args);
//        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
////        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        ProductService service = context.getBean(ProductService.class);

        Product prod =  new Mobile(
                0,
                "Siemens c65",
                "phone 2008",
                1,
                1500,
                "2,5",
                0,
                "-",
                650
        );

        service.save(prod);


//        service.save(
//                new Shirt(
//                        0,
//                        "Nike sport",
//                        "new collection T-shirt",
//                        50,
//                        1699,
//                        "M / 48-50",
//                        "black"
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
