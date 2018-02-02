package com.zxbin.designpattern;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zxbin.commomlib.base.ListActivity;
import com.zxbin.commomlib.base.TextAdapter;
import com.zxbin.designpattern.dagger.DaggerMainActivity;

public class MainActivity extends ListActivity {

    private Class[] items = new Class[]{
            DaggerMainActivity.class,


    };

    @Override
    protected RecyclerView.Adapter initAdapter() {
        TextAdapter adapter = new TextAdapter(this);
        for (Class item : items) {
            adapter.addData(item.getSimpleName());
        }

        adapter.setOnItemClickListener(new TextAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                startActivity(items[position]);
            }
        });
        return adapter;
    }
}
