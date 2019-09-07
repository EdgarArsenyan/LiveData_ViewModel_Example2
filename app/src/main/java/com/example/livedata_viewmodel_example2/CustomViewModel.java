package com.example.livedata_viewmodel_example2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {

    MutableLiveData<Integer> liveData;
    MutableLiveData<Integer> liveData2;

    public MutableLiveData<Integer> getLiveData() {

        if(liveData == null){
            liveData = new MutableLiveData<>();
            liveData.setValue(0);
        }
        return liveData;
    }

    public MutableLiveData<Integer> getLiveData2() {

        if(liveData2 == null){
            liveData2 = new MutableLiveData<>();
            liveData2.setValue(0);
        }
        return liveData2;
    }

    void increment1() {
        liveData.setValue(liveData.getValue() + 1);
    }

    void decrement1() {
        liveData.setValue(liveData.getValue() - 1);
    }

    void increment2() {
        liveData2.setValue(liveData2.getValue() + 1);
    }

    void decrement2() {
        liveData2.setValue(liveData2.getValue() - 1);
    }
}
