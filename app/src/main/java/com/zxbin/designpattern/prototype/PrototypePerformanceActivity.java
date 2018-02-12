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
 * new 与 clone的性能对比。
 * Created by zxbin on 2018/2/12.
 */

public class PrototypePerformanceActivity extends BaseActivity {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private final int COUNT = 10000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_btn);
        ButterKnife.bind(this);
        btnGet.setText("性能对比");
        tvResult.append(String.valueOf(COUNT));
        tvResult.append("个Bean， new 与 Clone性能对比，new 的耗时居然比clone少。");
    }


    @OnClick(R.id.btn_get)
    public void onViewClicked() {
        long cloneOperator = cloneOperator();
        long newTime = newOperator();
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
            CopyBean clone = null;
            try {
                clone = source.clone();
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
