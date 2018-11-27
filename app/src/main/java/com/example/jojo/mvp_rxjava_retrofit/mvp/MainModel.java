package com.example.jojo.mvp_rxjava_retrofit.mvp;

import com.example.jojo.mvp_rxjava_retrofit.bean.WeatherEntity;
import com.example.jojo.mvp_rxjava_retrofit.net.BaseHttpResponse;
import com.example.jojo.mvp_rxjava_retrofit.net.RetrofitManager;

import io.reactivex.Observable;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/26 11:08 AM
 * desc   : model-负责数据
 */
public class MainModel implements MainContract.Model {
    @Override
    public Observable<BaseHttpResponse<WeatherEntity>> getWeather(String city) {
        return RetrofitManager.getInstance().getRequestService().getWeather(city);
    }
}
