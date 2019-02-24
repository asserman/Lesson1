package com.example.rumpilstilstkin.lesson1.moxy;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.rumpilstilstkin.lesson1.R;


public class MoxyMainActivity extends MvpAppCompatActivity
        implements MoxyExampleView, View.OnClickListener {

    @InjectPresenter(type = PresenterType.LOCAL)
    Presenter presenter;

    @ProvidePresenter(type = PresenterType.LOCAL)
    Presenter providePresenter() {
        return new Presenter(new Model());
    }

    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.btnCounter1);
        btnCounter2 = (Button) findViewById(R.id.btnCounter2);
        btnCounter3 = (Button) findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCounter1: {
                presenter.onAction(ActionType.ONE);
                break;
            }
            case R.id.btnCounter2: {
                presenter.onAction(ActionType.TWO);
                break;
            }
            case R.id.btnCounter3: {
                presenter.onAction(ActionType.THREE);
                break;
            }
        }
    }

    @Override
    public void setOneButtonText(String value) {
        btnCounter1.setText(value);
    }

    @Override
    public void setTwoButtonText(String value) {
        btnCounter2.setText(value);

    }

    @Override
    public void setThreeButtonText(String value) {
        btnCounter3.setText(value);
    }

    class MyAsynck extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //todo show progress
        }

        @Override
        protected String doInBackground(String... strings) {
            // go to net
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //hide show progress
        }
    }
}
