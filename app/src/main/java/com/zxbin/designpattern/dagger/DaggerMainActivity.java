package com.zxbin.designpattern.dagger;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zxbin.commomlib.base.ListActivity;
import com.zxbin.commomlib.base.TextAdapter;

/**
 * Created by zxbin on 2018/2/2.
 */

public class DaggerMainActivity extends ListActivity {
    private Class[] clz = new Class[]{
            DaggerBeginActivity.class,

    };

    @Override
    protected RecyclerView.Adapter initAdapter() {
        TextAdapter adapter = new TextAdapter(this);
        for (Class cls : clz) {
            adapter.addData(cls.getSimpleName());
        }

        adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                startActivity(clz[position]);
            }
        });
        return adapter;
    }
}
