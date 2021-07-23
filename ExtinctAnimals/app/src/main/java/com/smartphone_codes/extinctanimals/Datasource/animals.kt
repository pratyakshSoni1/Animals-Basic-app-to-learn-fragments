package com.smartphone_codes.extinctanimals.Datasource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class animals(@StringRes val animal_name:Int, @DrawableRes val imageId:Int, @StringRes val animal_details:Int) {

}