package com.prajan.peertechz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prajan.peertechz.R;
import com.prajan.peertechz.model.ArticlesModel;

import java.util.List;

public class ArticlesVerticalAdapter extends RecyclerView.Adapter<ArticlesVerticalAdapter.RecyclerViewHolders> {

    private List<ArticlesModel> itemList;
    private Context context;

    public ArticlesVerticalAdapter(Context context, List<ArticlesModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }
    public class RecyclerViewHolders extends RecyclerView.ViewHolder {
        public TextView txtname,txtmessage;
        public ImageView profilephoto;

        public RecyclerViewHolders(View itemView) {
            super(itemView);

            profilephoto = (ImageView)itemView.findViewById(R.id.profile_image);
            txtname=itemView.findViewById(R.id.txtname);
            txtmessage=itemView.findViewById(R.id.txtmessage);
        }
    }
    @Override
    public ArticlesVerticalAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_vertical_card_view_list, null);
        ArticlesVerticalAdapter.RecyclerViewHolders rcv = new ArticlesVerticalAdapter.RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ArticlesVerticalAdapter.RecyclerViewHolders holder, int position) {

        holder.profilephoto.setImageResource(itemList.get(position).getProfilephoto());
        holder.txtname.setText(itemList.get(position).getTxtname());
        holder.txtmessage.setText(itemList.get(position).getTxtmessage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

}

