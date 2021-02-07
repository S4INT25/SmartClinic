package com.lucky.smartclinicadmin.ui.fragments.doctors;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.lucky.smartclinicadmin.R;

public class DoctorProfileDirections {
  private DoctorProfileDirections() {
  }

  @NonNull
  public static NavDirections actionDoctorProfileFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_doctorProfileFragment_to_homeFragment);
  }
}
