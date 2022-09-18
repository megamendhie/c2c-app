package com.mendhie.c2capp.domain.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mendhie.c2capp.data.models.Exhibit
import com.mendhie.c2capp.domain.loader.RestExhibitsLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExhibitViewModel @Inject constructor(val restExhibitsLoader: RestExhibitsLoader): ViewModel() {
    val exhibitList: MutableLiveData<List<Exhibit>> = restExhibitsLoader.data
    val onError: MutableLiveData<String> = restExhibitsLoader.dataError

    fun getExhibits(): MutableLiveData<List<Exhibit>>{
        restExhibitsLoader.getExhibitList()
        return exhibitList
    }

    fun errorListener(): MutableLiveData<String> = onError
}