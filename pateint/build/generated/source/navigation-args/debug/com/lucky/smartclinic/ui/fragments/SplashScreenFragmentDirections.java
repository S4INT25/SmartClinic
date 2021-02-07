package com.lucky.smartclinic.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinic.R;

public class SplashScreenFragmentDirections {
  private SplashScreenFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashScreenFragmentToLogInFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashScreenFragment_to_logInFragment);
  }
}
