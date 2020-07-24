package com.abora.popularmoviesapp.ui.activities.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.popularmoviesapp.R;

import com.abora.popularmoviesapp.ui.activities.splash.SplashActivity;
import com.abora.popularmoviesapp.util.LocaleHelper;
import com.abora.popularmoviesapp.util.MyPreference;
import com.abora.popularmoviesapp.util.SpacesItemDecoration;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    private static BaseActivity instance;
    Unbinder unbinder;
    public Gson gson;
    public MyPreference preference;
    private ProgressDialog mProgressDialog;

    public void preInit() {
        gson = new GsonBuilder().create();
        preference = new MyPreference(gson);
        LocaleHelper.setLocale(this, preference.getLanguage());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        instance = this;
    }

    public static BaseActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preInit();
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initActivity(savedInstanceState);
        invertStatusBarColors();
    }

    public void invertStatusBarColors() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
    }

    public abstract int getLayout();

    public void hideView(View view) {
        if (view != null) view.setVisibility(View.GONE);
    }

    public void showView(View view) {
        if (view != null) view.setVisibility(View.VISIBLE);
    }

    public void hideView(List<View> views) {
        for (View view :
                views) {
            if (view != null) view.setVisibility(View.GONE);
        }
    }

    public void showView(List<View> views) {
        for (View view :
                views) {
            if (view != null) view.setVisibility(View.VISIBLE);
        }
    }

    public abstract void initActivity(Bundle savedInstanceState);

    public void hideToolbar() {
        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }

    public void fillSpinner(List list, Spinner spinner) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.item_spinner, list);
        arrayAdapter.setDropDownViewResource(R.layout.item_spinner);
        spinner.setAdapter(arrayAdapter);
    }

    public void fillCustomSpinner(List list, Spinner spinner) {
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.custom_spinner_item, list);
//        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_item);
//        spinner.setAdapter(arrayAdapter);
    }

    public void unAuthenticatedUser() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_unauthorized);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        Button btnOk = dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // preference.logOut();
                openActivityWithAnim(SplashActivity.class, null, true, R.anim.slide_in_up, R.anim.slide_out_up);
                finishAffinity();
            }
        });
        dialog.show();
    }

    public void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (getCurrentFocus() != null)
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("MultiBackStack", "Failed to add fragment to back stack", e);
        }
    }

    public void goToFragment(Fragment fragment, int frame, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(frame, fragment, tag).commit();
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        Log.e("Fragments Quantity", String.valueOf(fragments.size()));
        removeFragments(fragments);
        fragmentManager.beginTransaction().show(fragment).commit();
    }

    private void removeFragments(List<Fragment> fragments) {
        for (Fragment fragment :
                fragments) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void openActivity(Class<?> activity, Bundle bundle, boolean finish) {
        if (finish) finish();
        Intent intent = new Intent(this, activity);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openActivityWithAnim(Class<?> activity, Bundle bundle, Boolean finish, int startAnime, int endAnime) {
        if (finish) finish();
        Intent intent = new Intent(this, activity);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(startAnime, endAnime);
    }

    public void openActivityWithAnimForResult(Class<?> activity, Bundle bundle, Boolean finish, int requestCode, int startAnime, int endAnime) {
        if (finish) finish();
        Intent intent = new Intent(this, activity);
        if (bundle != null) intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
        overridePendingTransition(startAnime, endAnime);
    }

    public void finishActivityWithAnim(int startAnim, int endAnim) {
        this.overridePendingTransition(startAnim, endAnim);
        finish();
    }

    public void openActivityForResult(Class<?> activity, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }


    public GridLayoutManager initVerticalRV(RecyclerView recyclerView, int spanCount, int space) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(space, spanCount, true));
        recyclerView.setNestedScrollingEnabled(false);
        return gridLayoutManager;
    }

    @Override
    protected void onResume() {
        super.onResume();
        instance = this;
    }

    public GridLayoutManager initHorizontalRV(RecyclerView recyclerView, int spanCount) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(0, spanCount, false));
        recyclerView.setNestedScrollingEnabled(false);
        return gridLayoutManager;
    }

    @Override
    public void onBackPressed() {
        finishActivityWithAnim(R.anim.slide_in_down, R.anim.slide_in_up);
        hideProgressDialog();

    }


    public ProgressDialog showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(false);
        }

        if (!mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.show();
        }

        return mProgressDialog;
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


}
