package com.lucky.smartclinicadmin.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicadmin.R;

public class SplashScreenFragmentDirections {
  private SplashScreenFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashScreenFragmentToStartScreenFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashScreenFragment_to_startScreenFragment);
  }

  @NonNull
  public static NavDirections actionSplashScreenFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashScreenFragment_to_homeFragment);
  }
}
