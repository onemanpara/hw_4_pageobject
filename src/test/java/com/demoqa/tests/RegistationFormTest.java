package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistationFormTest {
    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String name = "Mikhail";
    String surname = "Nesterov";
    String email = "onemanpara@gmail.com";
    String number = "9022541115";
    String address = "Stroiteley street";

    @Test
    void formTest() {
        registrationForm.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender("Male")
                .setNumber(number).setBirthDate("26", "August", "1998")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music").setPicture("img/test.jpg")
                .setAddress(address)
                .setLocation("Haryana", "Karnal")
                .clickSubmit();

        registrationForm.checkResult("Student Name", (name + " " + surname))
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", "26 August,1998")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "img/test.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", "Haryana Karnal");
    }
}
