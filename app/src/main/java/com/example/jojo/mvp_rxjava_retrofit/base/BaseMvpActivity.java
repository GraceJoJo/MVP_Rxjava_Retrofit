package com.example.jojo.mvp_rxjava_retrofit.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jojo.mvp_rxjava_retrofit.bean.ErrorBean;
import com.example.jojo.mvp_rxjava_retrofit.util.ClassReflectHelper;
import com.example.jojo.mvp_rxjava_retrofit.widgets.MultipleStatusView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : JOJO
 * e-mail : 18510829974@163.com
 * date   : 2018/11/24 11:24 AM
 * desc   : BaseMvpActivity
 */
public abstract class BaseMvpActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements IBaseView {
    protected P mMvpPresenter;
    protected M mModel;
    protected MultipleStatusView mMultipleStateView;
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContentViewLayoutID() != 0) {
            mMultipleStateView = new MultipleStatusView(this);
            setContentView(View.inflate(this, getContentViewLayoutID(), mMultipleStateView));
            unBinder = ButterKnife.bind(this);
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        //MVP
        mMvpPresenter = ClassReflectHelper.getT(this, 0);
        mModel = ClassReflectHelper.getT(this, 1);
        if (this instanceof IBaseView) {
            if (mMvpPresenter != null && mModel != null) {
                mMvpPresenter.setVM(this, mModel);
            }
        }
        initViewAndEvents();
    }

    protected abstract int getContentViewLayoutID();

    protected abstract void initViewAndEvents();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
        if (mMvpPresenter != null) {
            mMvpPresenter.onDestroy();
        }
    }

    @Override
    public void showLoading(MultipleStatusView multipleStatusView, String msg) {

    }


    @Override
    public void hideLoading() {

    }
    @Override
    public void showBusinessError(ErrorBean error) {
        mMultipleStateView.showError();
    }
//
    @Override
    public void showException(ErrorBean error) {
        mMultipleStateView.showNoNetwork();
    }

}
