package com.alyndroid.architecturepatternstutorialshomework.ui.Presenter;

import com.alyndroid.architecturepatternstutorialshomework.DataSource.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.Interface.NumberView;

public class NumberPresnter   {

    NumberView view;
    DataBase dataBase;

    public NumberPresnter(NumberView view) {
        this.view = view;
    }

    public void getPlusResult() {
        dataBase = new DataBase();
        view.onGetPluseResult(dataBase.getNumbers().getFirstNum() + dataBase.getNumbers().getSecondNum());
    }
}
