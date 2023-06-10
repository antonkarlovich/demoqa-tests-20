package junit.demoqa.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.devtools.v85.domsnapshot.model.ArrayOfStrings;

import java.util.*;

public class TestData {
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String gender = setRandomValue("Male", "Female", "Other");
    public String userEmail = faker.internet().emailAddress();
    public String phoneNumber = faker.number().digits(10);
    public String dayOfBirth = setRandomDay();
    public String monthOfBirth = getRandomMonth();
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2015));
    public String subject = setRandomValue("Biology", "Math", "Chemistry", "Arts");

    public String hobby = setRandomValue("Sports", "Reading", "Music");

    public String state = setRandomValue("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String city = getRandomCity(state);

    public String address = faker.address().fullAddress();


    public String setRandomValue(String ... strings) {
        List<String> values = new ArrayList<>();
        Collections.addAll(values, strings);
        return values.get(faker.random().nextInt(0, values.size() - 1));
    }

    public String setRandomDay() {
        int day = faker.number().numberBetween(1, 25);
        if (day < 10) {
            return "0" + day;
        } else {
            return day + "";
        }
    }

    public String getRandomMonth() {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        return  months.get(faker.random().nextInt(0, months.size() -1));
    }

    public String getRandomCity(String state) {
        String city = null;
        List<String> citiesNCR = Arrays.asList("Delhi", "Gurgaon", "Noida");
        List<String> citiesUttarPradesh = Arrays.asList("Agra", "Lucknow", "Merrut");
        List<String> citiesHaryana = Arrays.asList("Karnal", "Panipat");
        List<String> citiesRajasthan = Arrays.asList("Jaipur", "Jaiselmer");

        switch (state) {
            case "NCR":
                city = citiesNCR.get(faker.random().nextInt(0, citiesNCR.size() - 1));
                break;
            case "Uttar Pradesh":
                city = citiesUttarPradesh.get(faker.random().nextInt(0, citiesUttarPradesh.size() - 1));
                break;
            case "Haryana":
                city = citiesHaryana.get(faker.random().nextInt(0, citiesHaryana.size() - 1));
                break;
            case "Rajasthan" :
                city = citiesRajasthan.get(faker.random().nextInt(0, citiesRajasthan.size() - 1));
        }
        return city;
    }
}
