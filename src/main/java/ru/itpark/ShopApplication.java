package ru.itpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;

import ru.itpark.entity.Mobile;
//import ru.itpark.entity.Product;

import ru.itpark.repository.MobileRepository;
import ru.itpark.service.MobileService;
//


@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ShopApplication.class, args);
        MobileService service = context.getBean(MobileService.class);
        MobileRepository repository = context.getBean(MobileRepository.class);


        service.save(
                new Mobile(
                        0,
                        "xiaomi",
                        "phone made in china",
                        100,
                        12500,
                        "5,5",
                        8,
                        "qwer",
                        4000
                )
        );


        service.save(
                new Mobile(
                        0,
                        "samsung s9",
                        "phone made in korea",
                        155,
                        66500,
                        "6,2",
                        34,
                        "s9s",
                        3500
                )
        );

        service.save(
                new Mobile(
                        0,
                        "iPhone 8",
                        "smartphone made in china",
                        100,
                        44000,
                        "5,5",
                        32,
                        "a8",
                        2400
                )
        );
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
