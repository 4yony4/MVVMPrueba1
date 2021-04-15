package com.eurekamps.mvvmprueba1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    private val _text= MutableLiveData<String>().apply {
        value="Hola mundo"
    }

    val text: LiveData<String> = _text

    fun updateText(texto:String){
        _text.value=texto
    }
}
