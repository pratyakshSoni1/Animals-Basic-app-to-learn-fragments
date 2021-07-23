package com.smartphone_codes.extinctanimals.Datasource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.smartphone_codes.extinctanimals.R

class animalsDatasource (){
    fun loadData():List<animals>{
        return mutableListOf<animals>(
        animals(R.string.animal1,R.drawable.toothedcat,R.string.animal1data) ,
        animals(R.string.animal2,R.drawable.mammoth,R.string.animal2data) ,
        animals(R.string.animal3,R.drawable.dodo,R.string.animal3data) ,
        animals(R.string.animal4,R.drawable.pigeon,R.string.animal4data) ,
        animals(R.string.animal5,R.drawable.tapir,R.string.animal5data) ,
        animals(R.string.animal6,R.drawable.tasmaniantiger,R.string.animal6data)
        )
    }
}