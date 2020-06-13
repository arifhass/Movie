package com.example.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public List<MovieList> movieListModelList;
    MainActivity mc;
    public Context context;

    public RecyclerAdapter(List<MovieList> newsListModelList, MainActivity mc){

        this.movieListModelList = newsListModelList;
        this.mc = mc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.setIsRecyclable(false);

        final String itemname = movieListModelList.get(position).getName();
        final String itemiamge = movieListModelList.get(position).getImagename();

        holder.setdata(itemname,itemiamge);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(itemiamge =="4") {
                    mc.switchContent(new sydneyfragment());
                }
//                else if(itemiamge =="2") {
//                    mc.switchContent(new abcnewsFragment());
//                }
//                else if(itemiamge =="3") {
//                    mc.switchContent(new theagefragment());
//                }
//                else if(itemiamge =="4") {
//                    mc.switchContent(new ninenewsfragment());
//                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView name;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            image = mView.findViewById(R.id.imageView);
            name = mView.findViewById(R.id.textView);

        }
        public void setdata( String naame, String img) {

            name.setText(naame);

//            if(img =="4") {
                Picasso.get().load(R.drawable.sydney).into(image);
//            }
//           else if(img =="2") {
//                Picasso.get().load(R.drawable.abc).into(image);
//            }
//          else if(img =="3") {
//                Picasso.get().load(R.drawable.theage).into(image);
//            }
//           else if(img =="4") {
//                Picasso.get().load(R.drawable.nine).into(image);
//            }
        }
    }
}
