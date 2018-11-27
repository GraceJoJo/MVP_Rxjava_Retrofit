package com.example.jojo.mvp_rxjava_retrofit.base;


import com.example.jojo.mvp_rxjava_retrofit.bean.ErrorBean;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

/**
 * Created by JoJo on 2018/3/30.
 * wechat：18510829974
 * description：View层接口-View相关的界面更新
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
     * dialog loading
     */
    void showDialogLoading(String msg);

    /**
     * dismiss  dialog loading
     */
    void dismissDialogLoading();

    /**
     * show business error :网络异常及数据错误等异常情况
     */
    void showBusinessError(ErrorBean error);

    void showException(ErrorBean error);
}
