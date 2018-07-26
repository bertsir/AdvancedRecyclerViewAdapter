package cn.bertsir.rvadapterdeamo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cn.bertsir.rvadapterdeamo.adapter.AdvancedRecyclerViewAdapter;

public class GridActivity extends Activity implements View.OnClickListener {
    private RecyclerView rv;
    private Button bt_add;
    private Button bt_del;
    private ArrayList<String> datas;
    private TestAdapter testAdapter;
    private Button bt_add_footert;
    private Button bt_del_footer;
    private Button bt_add_data;
    private Button bt_del_data;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        datas = new ArrayList<>();
        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_del = (Button) findViewById(R.id.bt_del);

        bt_add.setOnClickListener(this);
        bt_del.setOnClickListener(this);


        manager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(manager);
        testAdapter = new TestAdapter(this, datas);
        rv.setAdapter(testAdapter);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return testAdapter.isFoot(position) || testAdapter.isHead(position) || testAdapter.isEmpty(position)? manager
                        .getSpanCount() : 1;
            }
        });
        testAdapter.addEmptyView(R.layout.item_empty);
        bt_add_footert = (Button) findViewById(R.id.bt_add_footert);
        bt_add_footert.setOnClickListener(this);
        bt_del_footer = (Button) findViewById(R.id.bt_del_footer);
        bt_del_footer.setOnClickListener(this);
        bt_add_data = (Button) findViewById(R.id.bt_add_data);
        bt_add_data.setOnClickListener(this);
        bt_del_data = (Button) findViewById(R.id.bt_del_data);
        bt_del_data.setOnClickListener(this);


        testAdapter.setOnRecyclerViewContentClick(new AdvancedRecyclerViewAdapter.OnRecyclerViewContentClick() {
            @Override
            public void OnContentClick(int positon) {
                Toast.makeText(GridActivity.this, "子项" + positon, Toast.LENGTH_SHORT).show();
            }
        });
        testAdapter.setOnRecyclerViewEmptyClick(new AdvancedRecyclerViewAdapter.OnRecyclerViewEmptyClick() {
            @Override
            public void OnEmptyClick() {
                Toast.makeText(GridActivity.this, "空布局", Toast.LENGTH_SHORT).show();
            }
        });
        testAdapter.setOnRecyclerViewFooterClick(new AdvancedRecyclerViewAdapter.OnRecyclerViewFooterClick() {
            @Override
            public void OnFooterClick() {
                Toast.makeText(GridActivity.this, "尾布局", Toast.LENGTH_SHORT).show();
            }
        });
        testAdapter.setOnRecyclerViewHeaderClick(new AdvancedRecyclerViewAdapter.OnRecyclerViewHeaderClick() {
            @Override
            public void OnHeaderClick() {
                Toast.makeText(GridActivity.this, "头布局", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                testAdapter.addHeaderView(R.layout.item_header);
                break;
            case R.id.bt_del:
                testAdapter.removeHeaderView();
                break;
            case R.id.bt_add_footert:
                testAdapter.addFooterView(R.layout.item_footer);
                break;
            case R.id.bt_del_footer:
                testAdapter.removeFooterView();
                break;
            case R.id.bt_add_data:
                datas.add(String.valueOf(System.currentTimeMillis()));
                testAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_del_data:
                if (datas.size() > 0) {
                    datas.remove(datas.size() - 1);
                    testAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
