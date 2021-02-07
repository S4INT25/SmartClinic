package com.lucky.smartclinicadmin.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicadmin.R;

public class StartScreenFragmentDirections {
  private StartScreenFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionStartScreenFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_startScreenFragment_to_homeFragment);
  }
}
