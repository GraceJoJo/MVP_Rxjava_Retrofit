package com.example.jojo.mvp_rxjava_retrofit.base;


import com.example.jojo.mvp_rxjava_retrofit.net.RxManager;

/**
 * Created by JoJo on 2018/3/29.
 * wechat:18510829974
 * description:
 */

public abstract class BasePresenter<V, M > {
    public M mModel;
    public V mView;
    public RxManager rxManager = new RxManager();

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
    }
    /**
     * 防止内存泄漏
     */
    public void onDestroy() {
        rxManager.clear();
        rxManager = null;
        mView = null;
    }
}
