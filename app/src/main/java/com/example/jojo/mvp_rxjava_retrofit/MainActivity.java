package com.example.jojo.mvp_rxjava_retrofit;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jojo.mvp_rxjava_retrofit.base.BaseMvpActivity;
import com.example.jojo.mvp_rxjava_retrofit.bean.ErrorBean;
import com.example.jojo.mvp_rxjava_retrofit.bean.WeatherEntity;
import com.example.jojo.mvp_rxjava_retrofit.mvp.MainContract;
import com.example.jojo.mvp_rxjava_retrofit.mvp.MainModel;
import com.example.jojo.mvp_rxjava_retrofit.mvp.MainPresenter;
import com.example.jojo.mvp_rxjava_retrofit.net.BaseObserverListener;
import com.example.jojo.mvp_rxjava_retrofit.net.RetrofitManager;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试MVP
 */
public class MainActivity extends BaseMvpActivity<MainPresenter, MainModel> implements MainContract.View {
    @BindView(R.id.tv_quality)
    TextView tv_quality;
    @BindView(R.id.tv_pm)
    TextView tv_pm;
    @BindView(R.id.tv_wendu)
    TextView tv_wendu;
    @BindView(R.id.tv_notice)
    TextView tv_notice;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAndEvents() {
        mMvpPresenter.getWeather("101030100", mMultipleStateView);
    }

    /**
     * 接口请求成功的回调方法
     *
     * @param bean
     */
    @Override
    public void getWeather(WeatherEntity bean) {
        Log.e("TAG", "请求成功");
        tv_quality.setText("空气质量：" + bean.quality);
        tv_pm.setText("Pm10" + bean.pm10);
        tv_wendu.setText("温度：" + bean.wendu);
        tv_notice.setText("提醒：" + bean.ganmao);
    }
}
