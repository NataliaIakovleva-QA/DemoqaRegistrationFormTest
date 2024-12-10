package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            telephoneNumber = faker.phoneNumber().subscriberNumber(10),
            userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            userBirthYear = String.format("%s", faker.number().numberBetween(1920, 2024)),
            subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                    "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                    "Civics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("testPicture.jpg", "fenix.jpeg"),
            userAddress = faker.address().fullAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = getRandomCity(userState);

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }

    }


}
