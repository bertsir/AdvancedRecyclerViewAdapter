package cn.bertsir.rvadapterdeamo;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import cn.bertsir.rvadapterdeamo.adapter.AdvancedRecyclerViewAdapter;
import cn.bertsir.rvadapterdeamo.adapter.AdvancedRecyclerViewHolder;

/**
 * Created by Bert on 2018/7/25.
 */
public class TestAdapter extends AdvancedRecyclerViewAdapter {

    private ArrayList<String> datas;

    public TestAdapter(Context mContext, ArrayList<String> data) {
        super(mContext, data);
        datas = data;
    }

    @Override
    public void onBindHeaderViewHolder(AdvancedRecyclerViewHolder holder, int positon) {

    }

    @Override
    public void onBindContentViewHolder(AdvancedRecyclerViewHolder holder, int positon) {
        //设置子项内容
        TextView tv = (TextView) holder.get(R.id.item_tv_content);
        tv.setText(datas.get(positon));

        //or
        //holder.setText(R.id.item_tv_content,"1111");
    }

    @Override
    public void onBindEmptyViewHolder(AdvancedRecyclerViewHolder holder, int positon) {

    }

    @Override
    public void onBindFooterViewHolder(AdvancedRecyclerViewHolder holder, int positon) {

    }

    @Override
    protected int setContentLayout() {
        return R.layout.item_list;
    }


}
