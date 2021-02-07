package com.lucky.smartclinic.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinic.R;

public class LogInFragmentDirections {
  private LogInFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLogInFragmentToSignUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_logInFragment_to_signUpFragment);
  }
}
