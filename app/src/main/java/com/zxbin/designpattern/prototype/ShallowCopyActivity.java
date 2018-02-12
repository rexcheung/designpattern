package com.zxbin.designpattern.prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.zxbin.commomlib.base.BaseActivity;
import com.zxbin.designpattern.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 原型模式 - 浅模式
 * Created by zxbin on 2018/2/12.
 */

public class ShallowCopyActivity extends BaseActivity {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_btn);
        ButterKnife.bind(this);
        btnGet.setText("浅拷贝");
    }

    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        StringBuilder sb = new StringBuilder(200);
        CopyBean first = new CopyBean();
        first.inner = new InnerBean();
        CopyBean copyBean = null;
        sb.append("first inner = ")
                .append(first.inner);
        try {
            copyBean = (CopyBean) first.clone();
            sb.append("\ncopy inner bean = ")
                    .append(copyBean.inner);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        sb.append("\nfirst bean = ")
                .append(first)
                .append("\ncopy bean = ")
                .append(copyBean);

        sb.append("\n\n结果显示， first与copyBean为不再的对象，但inner是指向同一个对象的");

        // 结果显示， first与copyBean为不再的对象，但inner是指向同一个对象的
        tvResult.setText(sb.toString());
    }
}
