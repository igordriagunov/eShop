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


        mobileService.save(
                new Mobile(
                        0,
                        "xiaomi",
                        "phone made in china",
                        100,
                        12500,
                        "5,5",
                        "8 Gb",
                        "qlcm3x",
                        "4000",
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


        shirtService.save(
                new Shirt(
                        0,
                        "nike AIR",
                        "sportwear",
                        4,
                        999,
                        "M /48",
                        "red",
                        new Account(
                                3,
                                "vova",
                                "vova@mail.ru",
                                encoder.encode("vova"),
                                List.of(new SimpleGrantedAuthority("ROLE_USER")),
                                true,
                                true,
                                true,
                                true,
                                List.of(new Order())
                        )
                )
        );


//        Mobile mobile = new Mobile();
//
//        mobile.setName("xiaomi");
//        mobile.setDescription("phone made in china");
//        mobile.setQuantity(100);
//        mobile.setPrice(12500);
//        mobile.setDiagonal("5.5");
//        mobile.setMemoryGb("8 Gb");
//        mobile.setBatteryPower("4000");
//        mobile.setProcessorModel("qlcm3x");
//        mobile.setAccount(
//                new Account(
//                        "admin",
//                        "admin@mail.ru",
//                        encoder.encode("admin"),
//                        List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                        true,
//                        true,
//                        true,
//                        true,
//                        List.of(new Order())
//                )
//        );
//
//        mobileService.save(mobile);
//
//
//        Mobile mobile1 = new Mobile();
//
//        mobile1.setName("Motorola e 398");
//        mobile1.setDescription("phone from 2007");
//        mobile1.setQuantity(1);
//        mobile1.setPrice(2999);
//        mobile1.setDiagonal("3,1");
//        mobile1.setMemoryGb("64 Mb");
//        mobile1.setBatteryPower("800 mAh");
//        mobile1.setProcessorModel("m3m");
//        mobile1.setAccount(
//                new Account(
//                        "user",
//                        "user@mail.ru",
//                        encoder.encode("user"),
//                        List.of(new SimpleGrantedAuthority("ROLE_USER")),
//                        true,
//                        true,
//                        true,
//                        true,
//                        List.of(new Order())
//                )
//        );
//
//        mobileService.save(mobile1);
//
//
//        Mobile mobile2 = new Mobile();
//
//        mobile2.setName("iPhone 8");
//        mobile2.setDescription("smartphone made in china");
//        mobile2.setQuantity(100);
//        mobile2.setPrice(44000);
//        mobile2.setDiagonal("5,5");
//        mobile2.setMemoryGb("32 Gb");
//        mobile2.setProcessorModel("a8");
//        mobile2.setBatteryPower("2400");
//        mobile2.setAccount(new Account(
//                        "admin",
//                        "admin@mail.ru",
//                        encoder.encode("admin"),
//                        List.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
//                        true,
//                        true,
//                        true,
//                        true,
//                        List.of(new Order())
//                )
//        );
//
//        mobileService.save(mobile2);
//
//
//        Shirt shirt = new Shirt();
//
//        shirt.setName("Nike sport");
//        shirt.setDescription("new collection T-shirt");
//        shirt.setQuantity(4);
//        shirt.setPrice(1699);
//        shirt.setSize("M / 48-50");
//        shirt.setColor("black");
//        shirt.setAccount(new Account(
//                        "vova",
//                        "vova@mail.ru",
//                        encoder.encode("vova"),
//                        List.of(new SimpleGrantedAuthority("ROLE_USER")),
//                        true,
//                        true,
//                        true,
//                        true,
//                        List.of(new Order())
//                )
//        );
//
//        shirtService.save(shirt);
//
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


        accountRepository.saveAll(
                List.of(
                        new Account(
                                2,
                                "user",
                                "user@mail.ru",
                                encoder.encode("user"),
                                List.of(new SimpleGrantedAuthority("ROLE_USER")),
                                true,
                                true,
                                true,
                                true,
                                List.of(new Order())
                        )
                )
        );


        accountRepository.saveAll(
                List.of(
                        new Account(
                                3,
                                "vova",
                                "vova@mail.ru",
                                encoder.encode("vova"),
                                List.of(new SimpleGrantedAuthority("ROLE_USER")),
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
