package com.lucky.smartclinicadmin.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicadmin.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToPatientsListFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_patientsListFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToDoctorListFragmentFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_doctorListFragmentFragment);
  }
}
