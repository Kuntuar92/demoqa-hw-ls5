package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String userName = "Кайрат",
                lastName = " Кайратов",
                 email = "kairat_test@testtt.comm",
                 gender = "Male",
                 phone = "8777111111",
                 birthDay = "30",
                 birthMonth = "July",
                 birthYear = "1900",
                 subject = "qwerty",
                 hobbies = "Sports",
                 jpfile = "img/homework.jpg",
                 currentAddress = "Some address 1",
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
                .verifyResult("Student Name" , userName + lastName)
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