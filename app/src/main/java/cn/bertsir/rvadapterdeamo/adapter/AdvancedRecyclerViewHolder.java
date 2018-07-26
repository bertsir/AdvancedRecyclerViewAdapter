package cn.bertsir.rvadapterdeamo.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bert on 2018/7/25.
 */
public class AdvancedRecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;

    public AdvancedRecyclerViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    /**
     * 根据View Id 获取对应的View
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T get(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = this.itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    //******** 提供对View、TextView、ImageView的常用设置方法 ******//

    public AdvancedRecyclerViewHolder setText(int viewId, String text) {
        TextView tv = get(viewId);
        tv.setText(text);
        return this;
    }

    public AdvancedRecyclerViewHolder setText(int viewId, int textRes) {
        TextView tv = get(viewId);
        tv.setText(textRes);
        return this;
    }

    public AdvancedRecyclerViewHolder setTextColor(int viewId, int textColor) {
        TextView view = get(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public AdvancedRecyclerViewHolder setTextSize(int viewId, int size) {
        TextView view = get(viewId);
        view.setTextSize(size);
        return this;
    }

    public AdvancedRecyclerViewHolder setImageResource(int viewId, int resId) {
        ImageView view = get(viewId);
        view.setImageResource(resId);
        return this;
    }

    public AdvancedRecyclerViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = get(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }


    public AdvancedRecyclerViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = get(viewId);
        view.setImageDrawable(drawable);
        return this;
    }


    public AdvancedRecyclerViewHolder setBackgroundColor(int viewId, int color) {
        View view = get(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public AdvancedRecyclerViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = get(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public AdvancedRecyclerViewHolder setVisible(int viewId, boolean visible) {
        View view = get(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public AdvancedRecyclerViewHolder setVisible(int viewId, int visible) {
        View view = get(viewId);
        view.setVisibility(visible);
        return this;
    }
}
