package edu.miu.cs.cs489appsd.lab2.pam;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

  private int patientId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  private String mailingAddress;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfBirth;

  public Patient() {
  }

  public Patient(
      int patientId,
      String firstName,
      String lastName,
      String phoneNumber,
      String email,
      String mailingAddress,
      LocalDate dateOfBirth) {

    this.patientId = patientId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.mailingAddress = mailingAddress;
    this.dateOfBirth = dateOfBirth;
  }

  public int getAge() {
    return Period.between(dateOfBirth, LocalDate.now()).getYears();
  }

  public int getPatientId() {
    return patientId;
  }

  public void setPatientId(int patientId) {
    this.patientId = patientId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMailingAddress() {
    return mailingAddress;
  }

  public void setMailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
