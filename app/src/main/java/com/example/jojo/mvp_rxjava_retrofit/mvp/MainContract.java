package com.example.jojo.mvp_rxjava_retrofit.mvp;

import com.example.jojo.mvp_rxjava_retrofit.base.BaseModel;
import com.example.jojo.mvp_rxjava_retrofit.base.BasePresenter;
import com.example.jojo.mvp_rxjava_retrofit.base.IBaseView;
import com.example.jojo.mvp_rxjava_retrofit.bean.WeatherEntity;
import com.example.jojo.mvp_rxjava_retrofit.net.BaseHttpResponse;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

import io.reactivex.Observable;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/24 1:08 PM
 * desc   :
 */
public interface MainContract {

    interface View extends IBaseView {
        void getWeather(WeatherEntity bean);
    }

    interface Model extends BaseModel {
        Observable<BaseHttpResponse<WeatherEntity>> getWeather(String city_code);
    }

    abstract class Presenter extends BasePresenter<MainContract.View, MainContract.Model> {
        public abstract void getWeather(String city_code, MultipleStatusView multipleStatusView);
    }
}
