package com.example.sharedpreference_20200526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreference_20200526.databinding.ActivityMainBinding;
import com.example.sharedpreference_20200526.utils.ContextUtil;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isIdSave = binding.idSaveCheckBox.isChecked();

                if (isIdSave) {
                    String inputId = binding.emailEdt.getText().toString();

                    ContextUtil.setUserId(mContext, inputId);
                }

            }
        });

    }

    @Override
    public void setValues() {

        binding.emailEdt.setText(ContextUtil.getUserId(mContext));

    }
}
