package com.example.jojo.mvp_rxjava_retrofit.base;


import com.example.jojo.mvp_rxjava_retrofit.bean.ErrorBean;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

/**
 * Created by JoJo on 2018/3/30.
 * wechat：18510829974
 * description：View层接口-定义V层需要作出的动作的接口(界面更新相关)
 */
public interface IBaseView {
    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(MultipleStatusView multipleStatusView, String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show business error :网络异常及数据错误等异常情况
     */
    void showBusinessError(ErrorBean error);

    void showException(ErrorBean error);
}
