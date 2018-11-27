package com.example.jojo.mvp_rxjava_retrofit.net;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by JoJo on 2018/4/1.
 * wechat：18510829974
 * description：Observables 和 Subscribers管理
 */
public class RxManager {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    /**
     * 添加observer
     * @param observer
     */
    public void addObserver(DisposableObserver observer){
        if(observer!=null){
            compositeDisposable.add(observer);
        }
    }

    public void clear(){
        compositeDisposable.dispose();
    }

}
