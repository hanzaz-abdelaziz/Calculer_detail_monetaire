package com.nassim.calculer_detail_monetaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ResultArrayAdapter extends ArrayAdapter<RowItem> {

    private final List<RowItem> mList;
    private final Context mContext;

    public ResultArrayAdapter(Context context, List<RowItem> list){
        super(context, R.layout.result_item, list);
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.result_item, parent, false);

        TextView tv_title = rowView.findViewById(R.id.tv_result_title);
        TextView tv_result = rowView.findViewById(R.id.tv_result_calc);

        tv_title.setText(mList.get(position).getTitle());
        tv_result.setText(String.valueOf(mList.get(position).getValue()));

        return rowView;
    }
}
