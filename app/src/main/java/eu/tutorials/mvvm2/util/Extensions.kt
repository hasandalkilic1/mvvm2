package eu.tutorials.mvvm2.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.transition(id:Int,view:View){
    findNavController(view).navigate(id)
}

fun Navigation.transition(id:NavDirections,view:View){
    findNavController(view).navigate(id)
}