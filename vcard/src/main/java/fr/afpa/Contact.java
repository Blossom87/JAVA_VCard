package fr.afpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class Contact implements Serializable {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty surName;
    private StringProperty gender;
    private LocalDate birthDate;
    private StringProperty adress;
    private StringProperty zipCode;
    private StringProperty personalPhone;
    private StringProperty professionalPhone;
    private StringProperty mail;
    private StringProperty gitLinks;

    public Contact(String firstName, String lastName, String surName, String gender, LocalDate birthDate, String adress,
            String zipCode, String personalPhone, String professionalPhone, String mail, String gitLinks) {
        if (lastName == null || firstName == null || adress == null || personalPhone == null || mail == null) {
            throw new IllegalArgumentException("Required fields cannot be null");
        }
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.surName = new SimpleStringProperty(surName);
        this.birthDate = birthDate;
        this.gender = new SimpleStringProperty(gender);
        this.adress = new SimpleStringProperty(adress);
        this.zipCode = new SimpleStringProperty(zipCode);
        this.personalPhone = new SimpleStringProperty(personalPhone);
        this.professionalPhone = new SimpleStringProperty(professionalPhone);
        this.mail = new SimpleStringProperty(mail);
        this.gitLinks = new SimpleStringProperty(gitLinks);

    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public void setLastName(StringProperty lastName) {
        this.lastName = lastName;
    }

    public StringProperty getSurname() {
        return surName;
    }

    public void setSurname(StringProperty surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public StringProperty getGender() {
        return gender;
    }

    public void setGender(StringProperty gender) {
        this.gender = gender;
    }

    public StringProperty getAddress() {
        return adress;
    }

    public void setAddress(StringProperty adress) {
        this.adress = adress;
    }

    public StringProperty getZipCode() {
        return zipCode;
    }

    public void setZipCode(StringProperty zipCode) {
        this.zipCode = zipCode;
    }

    public StringProperty getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(StringProperty personalPhone) {
        this.personalPhone = personalPhone;
    }

    public StringProperty getProfessionalPhone() {
        return professionalPhone;
    }

    public void setProfessionalPhone(StringProperty professionalPhone) {
        this.professionalPhone = professionalPhone;
    }

    public StringProperty getMail() {
        return mail;
    }

    public void setMail(String mail) {

        if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", mail)) {
            throw new IllegalArgumentException("Wrong mail format.");
        }
        this.mail.set(mail);
    }

    public StringProperty getGitLinks() {
        return gitLinks;
    }

    public void setGitLinks(String gitHub) {

        if (!Pattern.matches("^https?://github.com/([A-Za-z0-9._-]+)$", gitHub)) {
            throw new IllegalArgumentException("Wrong link format.");
        }
        this.gitLinks.set(gitHub);
    }
}