package com.lucky.smartclinic.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SplashScreenFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SplashScreenFragmentArgs() {
  }

  private SplashScreenFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SplashScreenFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SplashScreenFragmentArgs __result = new SplashScreenFragmentArgs();
    bundle.setClassLoader(SplashScreenFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("username")) {
      String username;
      username = bundle.getString("username");
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("username", username);
    } else {
      __result.arguments.put("username", "default");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUsername() {
    return (String) arguments.get("username");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("username")) {
      String username = (String) arguments.get("username");
      __result.putString("username", username);
    } else {
      __result.putString("username", "default");
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
    SplashScreenFragmentArgs that = (SplashScreenFragmentArgs) object;
    if (arguments.containsKey("username") != that.arguments.containsKey("username")) {
      return false;
    }
    if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SplashScreenFragmentArgs{"
        + "username=" + getUsername()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SplashScreenFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public SplashScreenFragmentArgs build() {
      SplashScreenFragmentArgs result = new SplashScreenFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setUsername(@NonNull String username) {
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("username", username);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUsername() {
      return (String) arguments.get("username");
    }
  }
}
