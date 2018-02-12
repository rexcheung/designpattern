package com.zxbin.designpattern.prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.zxbin.commomlib.base.BaseActivity;
import com.zxbin.designpattern.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxbin on 2018/2/12.
 */

public class PrototypePerformanceActivity extends BaseActivity {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private final int COUNT = 100000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_btn);
        ButterKnife.bind(this);
        btnGet.setText("性能对比");
        tvResult.append(String.valueOf(COUNT));
        tvResult.append("个Bean， new 与 Clone性能对比，可以看到，new 的耗时比clone多一倍。");
    }


    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        long newTime = newOperator();
        long cloneOperator = cloneOperator();
        StringBuilder sb = new StringBuilder(100);
        sb.append("new 用时:")
                .append(newTime)
                .append("\n clone 用时")
                .append(cloneOperator);
        tvResult.setText(sb.toString());

    }

    private long cloneOperator() {
        long newStart = System.currentTimeMillis();
        ArrayList<CopyBean> newList = new ArrayList<>();
        CopyBean source = new CopyBean();
        for (int i = 0; i < COUNT; i++) {
            try {
                CopyBean clone = (CopyBean) source.clone();
                clone.inner = (InnerBean) source.inner.clone();
                newList.add(clone);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long newEnd = System.currentTimeMillis();
        return newEnd - newStart;
    }

    private long newOperator() {
        long newStart = System.currentTimeMillis();
        ArrayList<CopyBean> newList = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            newList.add(new CopyBean());
        }
        long newEnd = System.currentTimeMillis();
        return newEnd - newStart;
    }
}
