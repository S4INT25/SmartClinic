package com.lucky.smartclinicadmin.ui.fragments.patients;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicadmin.R;
import com.lucky.smartclinicadmin.model.Patient;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PatientsListFragmentDirections {
  private PatientsListFragmentDirections() {
  }

  @NonNull
  public static ActionPatientsListFragmentToPatientProfileFragment actionPatientsListFragmentToPatientProfileFragment(
      @NonNull Patient patient) {
    return new ActionPatientsListFragmentToPatientProfileFragment(patient);
  }

  public static class ActionPatientsListFragmentToPatientProfileFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPatientsListFragmentToPatientProfileFragment(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
    }

    @NonNull
    public ActionPatientsListFragmentToPatientProfileFragment setPatient(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_patientsListFragment_to_patientProfileFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Patient getPatient() {
      return (Patient) arguments.get("patient");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPatientsListFragmentToPatientProfileFragment that = (ActionPatientsListFragmentToPatientProfileFragment) object;
      if (arguments.containsKey("patient") != that.arguments.containsKey("patient")) {
        return false;
      }
      if (getPatient() != null ? !getPatient().equals(that.getPatient()) : that.getPatient() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getPatient() != null ? getPatient().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPatientsListFragmentToPatientProfileFragment(actionId=" + getActionId() + "){"
          + "patient=" + getPatient()
          + "}";
    }
  }
}
