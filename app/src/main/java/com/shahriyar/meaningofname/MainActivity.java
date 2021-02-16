package com.shahriyar.meaningofname;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shahriyar.meaningofname.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NamesView {
    private NamesPresenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new NamesPresenter(this);

    }

    public void onClickSearch(View view) {
        String name = binding.editTextPersonName.getText().toString();
        presenter.request(name);
        binding.progressBarLoader.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void setNames(String name) {
        binding.tvName.setText(name);
        binding.progressBarLoader.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void setMeaning(String meaning) {
        binding.tvDescription.setText(meaning);
    }

    @Override
    public void setGender(String gender) {
        binding.tvGender.setText(gender);
    }

    @Override
    public void showError(String error) {
        binding.progressBarLoader.setVisibility(ProgressBar.GONE);
        clearText();
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private void clearText() {
        binding.tvGender.setText(R.string.gender);
        binding.tvName.setText(R.string.name);
        binding.tvDescription.setText(R.string.description);
    }
}