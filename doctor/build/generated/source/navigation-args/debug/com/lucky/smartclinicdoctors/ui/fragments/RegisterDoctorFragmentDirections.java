package com.lucky.smartclinicdoctors.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicdoctors.R;

public class RegisterDoctorFragmentDirections {
  private RegisterDoctorFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSignUpFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_signUpFragment_to_homeFragment);
  }
}
