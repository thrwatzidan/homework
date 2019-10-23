package com.alyndroid.architecturepatternstutorialshomework.ui.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.DataSource.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Interface.NumberView;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.ui.NumberViewModel;
import com.alyndroid.architecturepatternstutorialshomework.ui.Presenter.NumberPresnter;

public class MainActivity extends AppCompatActivity implements NumberView , View.OnClickListener {

    NumberPresnter presnter;
    ActivityMainBinding binding;
    DataBase base;
    NumberViewModel numberViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        base = new DataBase();
        presnter = new NumberPresnter(this);
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        binding.setViewDiv(numberViewModel);
        binding.setLifecycleOwner(this);

         binding.plusButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);



    }




    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.plus_button:
                presnter.getPlusResult();
                break;

            case R.id.mul_button:
                getMulResult();
                break;
        }
    }

    private void getMulResult() {
        binding.mulResultTextView.setText
                (String.valueOf(base.getNumbers().getFirstNum()*base.getNumbers().getSecondNum()));
    }

    @Override
    public void onGetPluseResult(int plusResult) {
        binding.plusResultTextView.setText(String.valueOf(plusResult));
    }




}
