package com.lucky.smartclinic.ui.fragments.home.news;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.lucky.smartclinic.model.Article;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NewsDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private NewsDetailsFragmentArgs() {
  }

  private NewsDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static NewsDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    NewsDetailsFragmentArgs __result = new NewsDetailsFragmentArgs();
    bundle.setClassLoader(NewsDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("newsArticle")) {
      Article newsArticle;
      if (Parcelable.class.isAssignableFrom(Article.class) || Serializable.class.isAssignableFrom(Article.class)) {
        newsArticle = (Article) bundle.get("newsArticle");
      } else {
        throw new UnsupportedOperationException(Article.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (newsArticle == null) {
        throw new IllegalArgumentException("Argument \"newsArticle\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("newsArticle", newsArticle);
    } else {
      throw new IllegalArgumentException("Required argument \"newsArticle\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Article getNewsArticle() {
    return (Article) arguments.get("newsArticle");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    NewsDetailsFragmentArgs that = (NewsDetailsFragmentArgs) object;
    if (arguments.containsKey("newsArticle") != that.arguments.containsKey("newsArticle")) {
      return false;
    }
    if (getNewsArticle() != null ? !getNewsArticle().equals(that.getNewsArticle()) : that.getNewsArticle() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getNewsArticle() != null ? getNewsArticle().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "NewsDetailsFragmentArgs{"
        + "newsArticle=" + getNewsArticle()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(NewsDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Article newsArticle) {
      if (newsArticle == null) {
        throw new IllegalArgumentException("Argument \"newsArticle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("newsArticle", newsArticle);
    }

    @NonNull
    public NewsDetailsFragmentArgs build() {
      NewsDetailsFragmentArgs result = new NewsDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setNewsArticle(@NonNull Article newsArticle) {
      if (newsArticle == null) {
        throw new IllegalArgumentException("Argument \"newsArticle\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("newsArticle", newsArticle);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Article getNewsArticle() {
      return (Article) arguments.get("newsArticle");
    }
  }
}
