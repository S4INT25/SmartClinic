package com.lucky.smartclinicdoctors.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicdoctors.R;

public class ProfileDirections {
  private ProfileDirections() {
  }

  @NonNull
  public static NavDirections actionProfileToSplashScreenFragment() {
    return new ActionOnlyNavDirections(R.id.action_profile_to_splashScreenFragment);
  }
}
