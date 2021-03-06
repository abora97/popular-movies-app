package com.abora.popularmoviesapp.ui.fragment.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.popularmoviesapp.ui.activities.base.BaseActivity;
import com.abora.popularmoviesapp.util.MyPreference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    public BaseActivity activity;
    public Gson gson;
    public MyPreference preference;
    Unbinder unbinder;

    @Override
    public void onStart() {
        super.onStart();
        activity = getBaseActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        activity = getBaseActivity();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getBaseActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(isHasOptionsMenu());
    }

    public void hideView(View view) {
        activity.hideView(view);
    }

    public void showView(View view) {
        activity.showView(view);
    }

    public void hideView(List<View> views) {
        activity.hideView(views);
    }

    public void showView(List<View> views) {
        activity.showView(views);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getBaseActivity();
        gson = activity.gson;
        preference = activity.preference;
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        //setTitle(getTitle());
        initView(view);
        return view;
    }

    public BaseActivity getBaseActivity() {
        return BaseActivity.getInstance();
    }

    protected boolean isHasOptionsMenu() {
        return false;
    }

    protected abstract int getLayout();

    public abstract void initView(View view);


    public void hideToolbar() {
        activity.hideToolbar();
    }

    public void fillSpinner(List list, Spinner spinner) {
        activity.fillSpinner(list, spinner);
    }

    public void hideKeyboard() {
        activity.hideKeyboard();
    }

    public void showToast(String message) {
        activity.showToast(message);
    }

    public void openActivity(Class<?> activity, Bundle bundle, boolean finish) {
        this.activity.openActivity(activity, bundle, finish);
    }

    public void openActivityWithAnim(Class<?> activity, Bundle bundle, Boolean finish, int startAnime, int endAnime) {
        this.activity.openActivityWithAnim(activity, bundle, finish, startAnime, endAnime);
    }

    public void finishActivityWithAnim(int startAnim, int endAnim) {
        activity.finishActivityWithAnim(startAnim, endAnim);
    }

    public void openActivityForResult(Class<?> activity, Bundle bundle, int requestCode) {
        this.activity.openActivityForResult(activity, bundle, requestCode);
    }

//    public void openFragment(Fragment fragment) {
//        activity.openFragment(fragment);
//    }

    public GridLayoutManager initVerticalRV(RecyclerView recyclerView, int spanCount, int space) {
        return activity.initVerticalRV(recyclerView, spanCount, space);
    }

    public GridLayoutManager initHorizontalRV(RecyclerView recyclerView, int spanCount) {
        return activity.initHorizontalRV(recyclerView, spanCount);
    }

    public ProgressDialog showProgressDialog() {
        return activity.showProgressDialog();
    }

    public void hideProgressDialog() {
        activity.hideProgressDialog();

    }
}
