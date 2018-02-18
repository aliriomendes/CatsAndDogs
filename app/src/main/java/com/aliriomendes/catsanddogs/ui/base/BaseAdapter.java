package com.aliriomendes.catsanddogs.ui.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by aliriomendes on 17/02/2018.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

    public abstract void setData(List<Data> data);
}
