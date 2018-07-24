package com.example.hp.newsapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CostomAdapter extends RecyclerView.Adapter<CostomAdapter.ViewHolder> {

    String[] channelName = {"ABC News","The Times Of India","National Geographic","Google News (India)","News24","The New York Times","Reddit /r/all","MTV News","TechCrunch (CN)","Financial Times","New Scientist"};
    String[] channelType = {"General","General","Science","General","General","General","General","Entertainment","Technology","Business","Science"};


    Context context;

    ItemClick itemClick;

    public CostomAdapter(Context context) {
        this.context = context;
        itemClick = (ItemClick) context;
    }

    @NonNull
    @Override
    public CostomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.relist_item,parent,false);
        return new ViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull CostomAdapter.ViewHolder holder, final int position) {


        holder.channelTitle.setText (channelName[position]);
        holder.channelType.setText (channelType[position]);

        holder.channelTitle.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                itemClick.newClick (position);
            }
        });


        switch (position) {
            case 0:
                Glide.with (context).load (R.drawable.abnews).into (holder.imageView);
                break;

            case 1:
                Glide.with (context).load (R.drawable.timeoi).into (holder.imageView);
                break;
            case 2:
                Glide.with (context).load (R.drawable.ntnlgeo).into (holder.imageView);
                break;

            case 3:
                Glide.with (context).load (R.drawable.gle).into (holder.imageView);
                break;

            case 4:
                Glide.with (context).load (R.drawable.tfnews).into (holder.imageView);
                break;

            case 5:
                Glide.with (context).load (R.drawable.neyrk).into (holder.imageView);
                break;

            case 6:
                Glide.with (context).load (R.drawable.reddit).into (holder.imageView);
                break;

            case  7:
                Glide.with (context).load (R.drawable.mtvnews).into (holder.imageView);
                break;

            case  8:
                Glide.with (context).load (R.drawable.tech).into (holder.imageView);
                break;

            case  9:
                Glide.with (context).load (R.drawable.finacialtime).into (holder.imageView);
                break;

            case  10:
                Glide.with (context).load (R.drawable.newsci).into (holder.imageView);
                break;

        }


    }

    @Override
    public int getItemCount() {
        return channelName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


            TextView channelTitle, channelType;
            ImageView imageView;


        public ViewHolder(View itemView) {

            super (itemView);

                channelTitle = itemView.findViewById (R.id.chnlnme);
                channelType = itemView.findViewById (R.id.chnltype);

                imageView = itemView.findViewById (R.id.chnlimg);





        }
    }
}
