package ru.itpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Order;
import ru.itpark.entity.Shirt;
import ru.itpark.repository.AccountRepository;
import ru.itpark.service.MobileService;
import ru.itpark.service.ShirtService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ShopApplication.class, args);

        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
        MobileService mobileService = context.getBean(MobileService.class);
        ShirtService shirtService = context.getBean(ShirtService.class);


        Mobile mobile = new Mobile();

        mobile.setName("xiaomi");
        mobile.setDescription("phone made in china");
        mobile.setQuantity(100);
        mobile.setPrice(12500);
        mobile.setDiagonal("5.5");
        mobile.setMemoryGb("8 Gb");
        mobile.setBatteryPower("4000");
        mobile.setProcessorModel("qlcm3x");
        mobile.setAccount(
                new Account(
                        1,
                        "admin",
                        "admin@mail.ru",
                        encoder.encode("admin"),
                        List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
                        true,
                        true,
                        true,
                        true,
                        List.of(new Order())
                )
        );

        mobileService.save(mobile);


//
//
//        mobileService.save(
//                new Mobile(
//                        0,
//                        "samsung s9",
//                        "phone made in korea",
//                        155,
//                        66500,
//                        "6,2",
//                        "34",
//                        "s9s",
//                        "3500",
//                        new Account(
//                                2,
//                                "user",
//                                "user@mail.ru",
//                                encoder.encode("user"),
//                                List.of(new SimpleGrantedAuthority("ROLE_USER")),
//                                true,
//                                true,
//                                true,
//                                true,
//                                new ArrayList<>()
//                        )
//                )
//        );
////
//        mobileService.save(
//                new Mobile(
//                        0,
//                        "iPhone 8",
//                        "smartphone made in china",
//                        100,
//                        44000,
//                        "5,5",
//                        "32",
//                        "a8",
//                        "2400",
//                        new Account(
//                                1,
//                                "admin",
//                                "admin@mail.ru",
//                                encoder.encode("admin"),
//                                List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                                true,
//                                true,
//                                true,
//                                true,
//                                new ArrayList<>()
//                        )
//
//                )
//        );
//
//        shirtService.save(
//                new Shirt(
//                        0,
//                        "Nike sport",
//                        "new collection T-shirt",
//                        4,
//                        1699,
//                        "M / 48-50",
//                        "black",
//                        new Account(
//                                1,
//                                "admin",
//                                "admin@mail.ru",
//                                encoder.encode("admin"),
//                                List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                                true,
//                                true,
//                                true,
//                                true,
//                                new ArrayList<>()
//                        )
//                )
//        );
//
//        shirtService.save(
//                new Shirt(
//                        2,
//                        "abibas",
//                        "new collection T-shirt",
//                        4,
//                        1399,
//                        "M / 48-50",
//                        "black",
//                        new Account(
//                                2,
//                                "user",
//                                "user@mail.ru",
//                                encoder.encode("user"),
//                                List.of(new SimpleGrantedAuthority("ROLE_USER")),
//                                true,
//                                true,
//                                true,
//                                true,
//                                new ArrayList<>()
//                        )
//                )
//        );
//
//
//        accountRepository.saveAll(
//                List.of(
//                        new Account(
//                                1,
//                                "admin",
//                                "admin@mail.ru",
//                                encoder.encode("admin"),
//                                List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                                true,
//                                true,
//                                true,
//                                true,
//                                new ArrayList<>()
//                        )
//                )
//        );
//
        accountRepository.saveAll(
                List.of(
                        new Account(
                                1,
                                "admin",
                                "admin@mail.ru",
                                encoder.encode("admin"),
                                List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
                                true,
                                true,
                                true,
                                true,
                                List.of(new Order())
                        )
                )
        );
    }
}
