package com.example.covid19apirecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<com.example.covid19apirecyclerview.CustomAdapter.CustomViewHolder> {
    //private ArrayList<Dictionary> mList;

    private ArrayList<Dictionary> mList = new ArrayList<>();


    // 아이템 뷰를 저장하는 viewholder 클래스
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView createDt;
        protected TextView gubun;
        protected TextView defCnt;

        public CustomViewHolder(View view) {
            super(view);
            this.createDt = (TextView) view.findViewById(R.id.createDt_listitem);
            this.gubun = (TextView) view.findViewById(R.id.gubun_item);
            this.defCnt = (TextView) view.findViewById(R.id.defCnt_item);
        }


        void onBind(Dictionary data1) {
            createDt.setText(data1.getCreateDt());
            gubun.setText(data1.getGubun());
            defCnt.setText(data1.getDefCnt());
        }
    }
    public CustomAdapter(ArrayList<Dictionary> list) {
        this.mList = list;
    }


    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 return
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_list, parent, false);
        CustomViewHolder viewHolder = new CustomAdapter.CustomViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {

        holder.onBind(mList.get(position));

    }


    // 사이즈
    @Override
    public int getItemCount() {
        return mList.size();
    }


    // data 모델의 객체들을 list에 저장
    public void setmovieList(ArrayList<Dictionary> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

}
