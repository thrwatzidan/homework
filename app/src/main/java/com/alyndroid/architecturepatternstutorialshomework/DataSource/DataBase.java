package com.alyndroid.architecturepatternstutorialshomework.DataSource;

import com.alyndroid.architecturepatternstutorialshomework.Model.NumberModel;

public   class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
