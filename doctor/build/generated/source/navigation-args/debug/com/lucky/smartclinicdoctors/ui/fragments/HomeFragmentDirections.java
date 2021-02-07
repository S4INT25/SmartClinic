package com.lucky.smartclinicdoctors.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicdoctors.R;
import com.lucky.smartclinicdoctors.model.Doctor;
import com.lucky.smartclinicdoctors.model.Patient;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionHomeFragmentToPateintProfileFragment actionHomeFragmentToPateintProfileFragment(
      @NonNull Patient patient) {
    return new ActionHomeFragmentToPateintProfileFragment(patient);
  }

  @NonNull
  public static ActionHomeFragmentToProfile2 actionHomeFragmentToProfile2(@NonNull Doctor doctor) {
    return new ActionHomeFragmentToProfile2(doctor);
  }

  @NonNull
  public static ActionHomeFragmentToChatFragment actionHomeFragmentToChatFragment(
      @NonNull Patient patient) {
    return new ActionHomeFragmentToChatFragment(patient);
  }

  public static class ActionHomeFragmentToPateintProfileFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionHomeFragmentToPateintProfileFragment(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
    }

    @NonNull
    public ActionHomeFragmentToPateintProfileFragment setPatient(@NonNull Patient patient) {
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
      return R.id.action_homeFragment_to_pateintProfileFragment;
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
      ActionHomeFragmentToPateintProfileFragment that = (ActionHomeFragmentToPateintProfileFragment) object;
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
      return "ActionHomeFragmentToPateintProfileFragment(actionId=" + getActionId() + "){"
          + "patient=" + getPatient()
          + "}";
    }
  }

  public static class ActionHomeFragmentToProfile2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionHomeFragmentToProfile2(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
    }

    @NonNull
    public ActionHomeFragmentToProfile2 setDoctor(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("doctor")) {
        Doctor doctor = (Doctor) arguments.get("doctor");
        if (Parcelable.class.isAssignableFrom(Doctor.class) || doctor == null) {
          __result.putParcelable("doctor", Parcelable.class.cast(doctor));
        } else if (Serializable.class.isAssignableFrom(Doctor.class)) {
          __result.putSerializable("doctor", Serializable.class.cast(doctor));
        } else {
          throw new UnsupportedOperationException(Doctor.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_profile2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Doctor getDoctor() {
      return (Doctor) arguments.get("doctor");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToProfile2 that = (ActionHomeFragmentToProfile2) object;
      if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
        return false;
      }
      if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
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
      result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToProfile2(actionId=" + getActionId() + "){"
          + "doctor=" + getDoctor()
          + "}";
    }
  }

  public static class ActionHomeFragmentToChatFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionHomeFragmentToChatFragment(@NonNull Patient patient) {
      if (patient == null) {
        throw new IllegalArgumentException("Argument \"patient\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("patient", patient);
    }

    @NonNull
    public ActionHomeFragmentToChatFragment setPatient(@NonNull Patient patient) {
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
      return R.id.action_homeFragment_to_chatFragment;
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
      ActionHomeFragmentToChatFragment that = (ActionHomeFragmentToChatFragment) object;
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
      return "ActionHomeFragmentToChatFragment(actionId=" + getActionId() + "){"
          + "patient=" + getPatient()
          + "}";
    }
  }
}
