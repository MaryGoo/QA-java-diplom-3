package com.model;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;
import java.util.Map;

public class User {

    static Faker faker = new Faker(new Locale("en_EN"));

    private String email;
    private String password;
    private String name;

    public User(){};

    public User (Map<String, String> response){
        this.password = response.get("password");
        this.email = response.get("email");
        this.name = response.get("name");
    }
    public User getRandom(int charNumberInPassword ) {
        return new User()
                .setEmail(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru")
                .setName(faker.name().firstName())
                .setPassword(RandomStringUtils.randomAlphabetic(charNumberInPassword));
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
