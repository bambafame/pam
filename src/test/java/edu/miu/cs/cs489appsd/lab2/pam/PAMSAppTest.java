package edu.miu.cs.cs489appsd.lab2.pam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class PAMSAppTest {

  @Test
  void shouldCreatePatients() {

    List<Patient> patients = PamApplication.createPatients();

    assertNotNull(patients);
    assertFalse(patients.isEmpty());
    assertEquals(3, patients.size());
  }

  @Test
  void shouldSortPatientsFromOldestToYoungest() {

    List<Patient> patients = PamApplication.createPatients();

    PamApplication.sortPatientsByAgeDescending(patients);

    for (int i = 0; i < patients.size() - 1; i++) {

      assertTrue(
          patients.get(i).getAge()
              >= patients.get(i + 1).getAge()
      );
    }
  }

  @Test
  void patientAgeShouldBePositive() {

    Patient patient = PamApplication.createPatients().get(0);

    assertTrue(patient.getAge() > 0);
  }
}
