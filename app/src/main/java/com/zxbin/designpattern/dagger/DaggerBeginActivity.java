package com.zxbin.designpattern.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.zxbin.commomlib.base.BaseActivity;
import com.zxbin.designpattern.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxbin on 2018/2/2.
 */

public class DaggerBeginActivity extends BaseActivity {

    @Inject
    StringBean bean;

    @Inject
    SecondBean second;

    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_btn);
        ButterKnife.bind(this);
        DaggerBeginComponent
                .builder()
                .build()
                .inject(this);

    }

    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        tvResult.setText(bean.msg);
        tvResult.append("\n" + second.msg);

    }
}
