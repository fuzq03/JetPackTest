package com.example.jetpacktest;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> lifeData = new MutableLiveData<>();

    public void plusOne(){
        //在使用时要注意判断LiveData的getValue()方法所获得的数据可能为空，为避免空指针异常需要特殊考虑
        if(lifeData.getValue() == null){
            lifeData.setValue(0);
        }else{
            lifeData.setValue(lifeData.getValue() + 1);
        }
        Log.d("Here", lifeData.getValue().toString());
    }

    public MainViewModel(int a){

    }
}
