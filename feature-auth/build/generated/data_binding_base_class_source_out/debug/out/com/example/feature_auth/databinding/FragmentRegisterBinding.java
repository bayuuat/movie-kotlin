// Generated by view binder compiler. Do not edit!
package com.example.feature_auth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.feature_auth.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnRegister;

  @NonNull
  public final EditText etRegisterEmail;

  @NonNull
  public final EditText etRegisterPassword;

  @NonNull
  public final EditText etRegisterRePassword;

  @NonNull
  public final EditText etRegisterUsername;

  @NonNull
  public final TextView textView;

  private FragmentRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnRegister,
      @NonNull EditText etRegisterEmail, @NonNull EditText etRegisterPassword,
      @NonNull EditText etRegisterRePassword, @NonNull EditText etRegisterUsername,
      @NonNull TextView textView) {
    this.rootView = rootView;
    this.btnRegister = btnRegister;
    this.etRegisterEmail = etRegisterEmail;
    this.etRegisterPassword = etRegisterPassword;
    this.etRegisterRePassword = etRegisterRePassword;
    this.etRegisterUsername = etRegisterUsername;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnRegister;
      Button btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.etRegisterEmail;
      EditText etRegisterEmail = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterEmail == null) {
        break missingId;
      }

      id = R.id.etRegisterPassword;
      EditText etRegisterPassword = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterPassword == null) {
        break missingId;
      }

      id = R.id.etRegisterRePassword;
      EditText etRegisterRePassword = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterRePassword == null) {
        break missingId;
      }

      id = R.id.etRegisterUsername;
      EditText etRegisterUsername = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterUsername == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((ConstraintLayout) rootView, btnRegister, etRegisterEmail,
          etRegisterPassword, etRegisterRePassword, etRegisterUsername, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}