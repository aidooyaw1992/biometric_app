package com.miaxis.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.miaxis.demo.PensionApplication;
import com.miaxis.demo.data.remote.response.Agent;
import com.miaxis.demo.databinding.ActivityLoginBinding;
import com.miaxis.demo.util.DataState;
import com.miaxis.demo.util.MySharedPreferences;
import com.miaxis.demo.viewmodel.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    ActivityLoginBinding binding;

    @Inject
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((PensionApplication) getApplicationContext()).getAppComponent().inject(this);

        binding.loginButton.setOnClickListener((v) -> {
            if (validateForm()) {

                viewModel.submitLogin(
                        binding.usernameInput.getText().toString(),
                        binding.passwordInput.getText().toString()
                ).observe(this, state -> {
                    if (state.getStatus() == DataState.Status.LOADING) {
                        setLoginBusyState(true);
                    } else if (state.getStatus() == DataState.Status.ERROR) {
                        setLoginBusyState(false);
                        Toast.makeText(this, "Login Failure!", Toast.LENGTH_LONG).show();
                    } else {
                        MySharedPreferences.saveUser(getApplicationContext(), (Agent) state.getData());
                        setLoginBusyState(false);
                        viewModel.sendLoginAnalytics(state.getData());
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                        gotoHomePage();
                    }
                });

            }

        });
    }


    void setLoginBusyState(boolean isBusy) {
        if (isBusy) {
            binding.usernameInput.setEnabled(false);
            binding.passwordInput.setEnabled(false);
            binding.loginButton.setEnabled(false);
            binding.loginProgressBar.setVisibility(View.VISIBLE);
        } else {
            binding.usernameInput.setEnabled(true);
            binding.passwordInput.setEnabled(true);
            binding.loginButton.setEnabled(true);
            binding.loginProgressBar.setVisibility(View.GONE);
        }
    }

    void gotoHomePage() {
        Intent vIntent = new Intent(this, HomeActivity.class);
        startActivity(vIntent);
    }

    private boolean validateForm() {
        boolean isValid = true;
        String username = binding.usernameInput.getText().toString().trim();
        if (TextUtils.isEmpty(username) || username.length() < 3) {
            binding.usernameInput.setError("username must be at least 3 characters");
            isValid = false;
        }
        String password = binding.passwordInput.getText().toString().trim();
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            binding.passwordInput.setError("Password must be at least 6 characters");
            isValid = false;
        }

        return isValid;
    }

    private void performLogin() {
        // Implement your login logic here
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
    }
}