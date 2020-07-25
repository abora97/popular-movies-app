package com.abora.popularmoviesapp.ui.activities.main;

import android.os.Bundle;

import com.abora.popularmoviesapp.R;
import com.abora.popularmoviesapp.ui.activities.base.BaseActivity;
import com.abora.popularmoviesapp.ui.fragment.movie.MoviesFragment;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initActivity(Bundle savedInstanceState) {
       // goToFragment(new MoviesFragment(),R.id.nav_host_fragment,"d");
    }
}