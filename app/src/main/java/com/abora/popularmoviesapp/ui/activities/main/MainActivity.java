package com.abora.popularmoviesapp.ui.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.abora.popularmoviesapp.R;
import com.abora.popularmoviesapp.ui.activities.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initActivity(Bundle savedInstanceState) {
        showToast("Hello");
    }
}