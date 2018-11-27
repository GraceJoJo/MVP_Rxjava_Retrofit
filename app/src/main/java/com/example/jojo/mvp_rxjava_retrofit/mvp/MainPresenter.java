package com.example.jojo.mvp_rxjava_retrofit.mvp;

import com.example.jojo.mvp_rxjava_retrofit.base.RxObserverListener;
import com.example.jojo.mvp_rxjava_retrofit.bean.WeatherEntity;
import com.example.jojo.mvp_rxjava_retrofit.net.RetrofitManager;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

import java.util.List;
import java.util.logging.Handler;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/26 11:08 AM
 * desc   : presenter-负责业务逻辑处理
 */
public class MainPresenter extends MainContract.Presenter {
    @Override
    public void getWeather(String city_code, final MultipleStatusView multipleStatusView) {
        if (multipleStatusView != null) {
            multipleStatusView.showLoading();
        }
        rxManager.addObserver(RetrofitManager.getInstance().doRequest(mModel.getWeather(city_code), new RxObserverListener<WeatherEntity>(mView) {
            @Override
            public void onSuccess(WeatherEntity result) {
                if (multipleStatusView != null) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            multipleStatusView.showContent();
                        }
                    }, 2000);
                }
                mView.getWeather(result);
            }
        }));
    }
}
