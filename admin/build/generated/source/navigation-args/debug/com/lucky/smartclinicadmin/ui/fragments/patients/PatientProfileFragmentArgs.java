package com.lucky.smartclinicadmin.ui.fragments.patients;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.lucky.smartclinicadmin.model.Patient;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PatientProfileFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PatientProfileFragmentArgs() {
  }

  private PatientProfileFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PatientProfileFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PatientProfileFragmentArgs __result = new PatientProfileFragmentArgs();
    bundle.setClassLoader(PatientProfileFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("patient")) {
      Patient patient;
      if (Parcelable.class.isAssignableFrom(Patient.class) || Serializable.class.isAssignableFrom(Patient.class)) {
        patient = (Patient) bundle.get("patient");
      } else {
        throw new UnsupportedOperationException(Patient.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("patient", patient);
    } else {
      throw new IllegalArgumentException("Required argument \"patient\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Patient getPatient() {
    return (Patient) arguments.get("patient");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("patient")) {
      Patient patient = (Patient) arguments.get("patient");
      if (Parcelable.class.isAssignableFrom(Patient.class) || patient == null) {
        __result.putParcelable("patient", Parcelable.class.cast(patient));
      } else if (Serializable.class.isAssignableFrom(Patient.class)) {
        __result.putSerializable("patient", Serializable.class.cast(patient));
      } else {
        throw new UnsupportedOperationException(Patient.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PatientProfileFragmentArgs that = (PatientProfileFragmentArgs) object;
    if (arguments.containsKey("patient") != that.arguments.containsKey("patient")) {
      return false;
    }
    if (getPatient() != null ? !getPatient().equals(that.getPatient()) : that.getPatient() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPatient() != null ? getPatient().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PatientProfileFragmentArgs{"
        + "patient=" + getPatient()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(PatientProfileFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
    }

    @NonNull
    public PatientProfileFragmentArgs build() {
      PatientProfileFragmentArgs result = new PatientProfileFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPatient(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Patient getPatient() {
      return (Patient) arguments.get("patient");
    }
  }
}
