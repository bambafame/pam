package edu.miu.cs.cs489appsd.lab2.pam;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.databind.json.JsonMapper;

@SpringBootApplication
public class PamApplication implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    List<Patient> patients = createPatients();

    sortPatientsByAgeDescending(patients);

    try {
      writePatientsToJson(patients, "patients.json");

      System.out.println("Patient data successfully written to patients.json");

    } catch (IOException e) {
      System.err.println("Error writing JSON file: " + e.getMessage());
    }
  }

  public static List<Patient> createPatients() {

    List<Patient> patients = new ArrayList<>();

    patients.add(new Patient(
        1001,
        "John",
        "Smith",
        "641-555-1001",
        "john.smith@email.com",
        "123 Main Street, Fairfield, IA",
        LocalDate.of(1985, 4, 12)
    ));

    patients.add(new Patient(
        1002,
        "Sarah",
        "Johnson",
        "641-555-1002",
        "sarah.johnson@email.com",
        "456 Maple Avenue, Fairfield, IA",
        LocalDate.of(1997, 8, 23)
    ));

    patients.add(new Patient(
        1003,
        "Michael",
        "Brown",
        "641-555-1003",
        "michael.brown@email.com",
        "789 Oak Street, Ottumwa, IA",
        LocalDate.of(1974, 2, 15)
    ));

    return patients;
  }

  public static void sortPatientsByAgeDescending(
      List<Patient> patients) {

    patients.sort(Comparator.comparingInt(Patient::getAge).reversed());
  }

  public static void writePatientsToJson(List<Patient> patients, String fileName) throws IOException {

    JsonMapper mapper = JsonMapper.builder()
        .build();

    mapper.writerWithDefaultPrettyPrinter()
        .writeValue(new File(fileName), patients);
  }

  public static void main(String[] args) {
    SpringApplication.run(PamApplication.class, args);
  }

}
