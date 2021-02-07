package com.lucky.smartclinic.ui.fragments.chats;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.lucky.smartclinic.model.Doctor;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ChatFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ChatFragmentArgs() {
  }

  private ChatFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ChatFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ChatFragmentArgs __result = new ChatFragmentArgs();
    bundle.setClassLoader(ChatFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("doctor")) {
      Doctor doctor;
      if (Parcelable.class.isAssignableFrom(Doctor.class) || Serializable.class.isAssignableFrom(Doctor.class)) {
        doctor = (Doctor) bundle.get("doctor");
      } else {
        throw new UnsupportedOperationException(Doctor.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("doctor", doctor);
    } else {
      throw new IllegalArgumentException("Required argument \"doctor\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Doctor getDoctor() {
    return (Doctor) arguments.get("doctor");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ChatFragmentArgs that = (ChatFragmentArgs) object;
    if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
      return false;
    }
    if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ChatFragmentArgs{"
        + "doctor=" + getDoctor()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(ChatFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
    }

    @NonNull
    public ChatFragmentArgs build() {
      ChatFragmentArgs result = new ChatFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setDoctor(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Doctor getDoctor() {
      return (Doctor) arguments.get("doctor");
    }
  }
}
