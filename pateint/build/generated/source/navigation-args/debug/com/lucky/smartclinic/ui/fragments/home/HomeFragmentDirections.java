package com.lucky.smartclinic.ui.fragments.home;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.lucky.smartclinic.R;
import com.lucky.smartclinic.model.Article;
import com.lucky.smartclinic.model.Doctor;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionNavHomeToDoctorProfileFragment actionNavHomeToDoctorProfileFragment(
      @NonNull Doctor doctor) {
    return new ActionNavHomeToDoctorProfileFragment(doctor);
  }

  @NonNull
  public static ActionNavHomeToNewsDetailsFragment actionNavHomeToNewsDetailsFragment(
      @NonNull Article newsArticle) {
    return new ActionNavHomeToNewsDetailsFragment(newsArticle);
  }

  public static class ActionNavHomeToDoctorProfileFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNavHomeToDoctorProfileFragment(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
    }

    @NonNull
    public ActionNavHomeToDoctorProfileFragment setDoctor(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("doctor")) {
        Doctor doctor = (Doctor) arguments.get("doctor");
        if (Parcelable.class.isAssignableFrom(Doctor.class) || doctor == null) {
          __result.putParcelable("doctor", Parcelable.class.cast(doctor));
        } else if (Serializable.class.isAssignableFrom(Doctor.class)) {
          __result.putSerializable("doctor", Serializable.class.cast(doctor));
        } else {
          throw new UnsupportedOperationException(Doctor.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_nav_home_to_doctorProfileFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Doctor getDoctor() {
      return (Doctor) arguments.get("doctor");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNavHomeToDoctorProfileFragment that = (ActionNavHomeToDoctorProfileFragment) object;
      if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
        return false;
      }
      if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNavHomeToDoctorProfileFragment(actionId=" + getActionId() + "){"
          + "doctor=" + getDoctor()
          + "}";
    }
  }

  public static class ActionNavHomeToNewsDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNavHomeToNewsDetailsFragment(@NonNull Article newsArticle) {
      if (newsArticle == null) {
        throw new IllegalArgumentException("Argument \"newsArticle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("newsArticle", newsArticle);
    }

    @NonNull
    public ActionNavHomeToNewsDetailsFragment setNewsArticle(@NonNull Article newsArticle) {
      if (newsArticle == null) {
        throw new IllegalArgumentException("Argument \"newsArticle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("newsArticle", newsArticle);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("newsArticle")) {
        Article newsArticle = (Article) arguments.get("newsArticle");
        if (Parcelable.class.isAssignableFrom(Article.class) || newsArticle == null) {
          __result.putParcelable("newsArticle", Parcelable.class.cast(newsArticle));
        } else if (Serializable.class.isAssignableFrom(Article.class)) {
          __result.putSerializable("newsArticle", Serializable.class.cast(newsArticle));
        } else {
          throw new UnsupportedOperationException(Article.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_nav_home_to_newsDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Article getNewsArticle() {
      return (Article) arguments.get("newsArticle");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNavHomeToNewsDetailsFragment that = (ActionNavHomeToNewsDetailsFragment) object;
      if (arguments.containsKey("newsArticle") != that.arguments.containsKey("newsArticle")) {
        return false;
      }
      if (getNewsArticle() != null ? !getNewsArticle().equals(that.getNewsArticle()) : that.getNewsArticle() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getNewsArticle() != null ? getNewsArticle().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNavHomeToNewsDetailsFragment(actionId=" + getActionId() + "){"
          + "newsArticle=" + getNewsArticle()
          + "}";
    }
  }
}
