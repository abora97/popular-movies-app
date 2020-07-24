package com.abora.popularmoviesapp.ui.activities.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.abora.popularmoviesapp.R;
import com.abora.popularmoviesapp.ui.activities.base.BaseActivity;
import com.abora.popularmoviesapp.ui.activities.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initActivity(Bundle savedInstanceState) {
        timerStart();
        ImageView imageView = findViewById(R.id.ivSplash);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);
    }

    private void timerStart() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000);
    }
}