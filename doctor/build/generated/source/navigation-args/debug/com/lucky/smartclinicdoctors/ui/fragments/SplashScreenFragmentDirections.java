package com.lucky.smartclinicdoctors.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicdoctors.R;

public class SplashScreenFragmentDirections {
  private SplashScreenFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashScreenFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashScreenFragment_to_homeFragment);
  }

  @NonNull
  public static NavDirections actionSplashScreenFragmentToLogInFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashScreenFragment_to_logInFragment);
  }
}
