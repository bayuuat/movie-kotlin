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

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final TextView ctaToRegister;

  @NonNull
  public final EditText etLoginEmail;

  @NonNull
  public final EditText etLoginPass;

  @NonNull
  public final TextView textView;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLogin,
      @NonNull TextView ctaToRegister, @NonNull EditText etLoginEmail,
      @NonNull EditText etLoginPass, @NonNull TextView textView) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.ctaToRegister = ctaToRegister;
    this.etLoginEmail = etLoginEmail;
    this.etLoginPass = etLoginPass;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.ctaToRegister;
      TextView ctaToRegister = ViewBindings.findChildViewById(rootView, id);
      if (ctaToRegister == null) {
        break missingId;
      }

      id = R.id.etLoginEmail;
      EditText etLoginEmail = ViewBindings.findChildViewById(rootView, id);
      if (etLoginEmail == null) {
        break missingId;
      }

      id = R.id.etLoginPass;
      EditText etLoginPass = ViewBindings.findChildViewById(rootView, id);
      if (etLoginPass == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, btnLogin, ctaToRegister,
          etLoginEmail, etLoginPass, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
