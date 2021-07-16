package utils;

import com.github.javafaker.Faker;

public class DataFaker extends Faker {
    private Faker faker;

    public DataFaker() {
        faker = new Faker();
    }
    public String getFakeUsername(){
        return faker.name().username();
    }
    public String getFakePassword(){
        return faker.internet().password();
    }
}
