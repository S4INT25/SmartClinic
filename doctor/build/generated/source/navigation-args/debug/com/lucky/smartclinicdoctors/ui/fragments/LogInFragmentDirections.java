package com.lucky.smartclinicdoctors.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicdoctors.R;

public class LogInFragmentDirections {
  private LogInFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLogInFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_logInFragment_to_homeFragment);
  }

  @NonNull
  public static NavDirections actionLogInFragmentToSignUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_logInFragment_to_signUpFragment);
  }
}
