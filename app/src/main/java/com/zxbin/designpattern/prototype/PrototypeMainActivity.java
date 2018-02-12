package com.zxbin.designpattern.prototype;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zxbin.commomlib.base.ListActivity;
import com.zxbin.commomlib.base.TextAdapter;

/**
 * 原型模式
 * Created by zxbin on 2018/2/12.
 */

public class PrototypeMainActivity extends ListActivity {
    Class[] cls = new Class[]{
            ShallowCopyActivity.class,
            DeepCopyActivity.class,
            PrototypePerformanceActivity.class,
    };

    @Override
    protected RecyclerView.Adapter initAdapter() {
        TextAdapter adapter = new TextAdapter(this);
        for (Class clz : cls) {
            adapter.addData(clz.getSimpleName());
        }
        adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                startActivity(cls[position]);
            }
        });
        return adapter;
    }
}
