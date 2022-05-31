// Generated by view binder compiler. Do not edit!
package com.example.mobelite_community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mobelite_community.R;
import com.example.mobelite_community.activities.ScaleImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPictureFullScreenBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btCancel;

  @NonNull
  public final ScaleImageView fullImg;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final TextView profileUsername;

  @NonNull
  public final ProgressBar progressBar;

  private ActivityPictureFullScreenBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView btCancel, @NonNull ScaleImageView fullImg,
      @NonNull CircleImageView profileImage, @NonNull TextView profileUsername,
      @NonNull ProgressBar progressBar) {
    this.rootView = rootView;
    this.btCancel = btCancel;
    this.fullImg = fullImg;
    this.profileImage = profileImage;
    this.profileUsername = profileUsername;
    this.progressBar = progressBar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPictureFullScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPictureFullScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_picture_full_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPictureFullScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_cancel;
      ImageView btCancel = ViewBindings.findChildViewById(rootView, id);
      if (btCancel == null) {
        break missingId;
      }

      id = R.id.full_img;
      ScaleImageView fullImg = ViewBindings.findChildViewById(rootView, id);
      if (fullImg == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.profile_username;
      TextView profileUsername = ViewBindings.findChildViewById(rootView, id);
      if (profileUsername == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      return new ActivityPictureFullScreenBinding((RelativeLayout) rootView, btCancel, fullImg,
          profileImage, profileUsername, progressBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}