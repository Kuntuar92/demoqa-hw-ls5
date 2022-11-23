package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test

    void fillFormTest() {
        Faker faker = new Faker();

        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                 email = faker.internet().emailAddress(),
                 gender = "Male",
                 phone = faker.phoneNumber().subscriberNumber(10),
                 birthDay = "30",
                 birthMonth = "July",
                 birthYear = "1900",
                 subject = faker.chuckNorris().fact(),
                 hobbies = "Sports",
                 jpfile = "img/homework.jpg",
                 currentAddress = faker.address().fullAddress(),
                 state = "Uttar Pradesh",
                 city = "Agra";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(birthDay , birthMonth , birthYear)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setUpFile(jpfile)
                .curAdress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit();


        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name" , userName + " " + lastName)
                .verifyResult("Student Email" , email)
                .verifyResult("Gender" , gender)
                .verifyResult("Mobile" , phone)
                .verifyResult("Date of Birth" , birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Hobbies" , hobbies)
                .verifyResult("Picture" , jpfile.substring(5))
                .verifyResult("Address" , currentAddress)
                .verifyResult("State and City" , state + " " + city);

    }
}