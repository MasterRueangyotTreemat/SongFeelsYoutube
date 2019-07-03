package com.noomnim.songfeelsyoutube.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.noomnim.songfeelsyoutube.R;
import com.noomnim.songfeelsyoutube.activities.Youtube.DetailsActivity;
import com.noomnim.songfeelsyoutube.models.YoutubeDataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubePostHolder> {

    private ArrayList<YoutubeDataModel> dataSet;
    private Context mContext = null;

    public VideoPostAdapter(Context mContext,ArrayList<YoutubeDataModel> dataSet) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public YoutubePostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.youtube_post_layout,viewGroup,false );
        final YoutubePostHolder postHolder = new YoutubePostHolder( view );
        return postHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubePostHolder youtubePostHolder, int i) {
        //set the views here
        TextView textViewTitle = youtubePostHolder.textViewTitle;
        TextView textViewDes = youtubePostHolder.textViewDes;
        TextView textViewDate = youtubePostHolder.textViewDate;
        ImageView ImageThumb = youtubePostHolder.ImageThumb;


        YoutubeDataModel object = dataSet.get( i );

        textViewTitle.setText( object.getTitle() );
        textViewDes.setText( object.getDescription() );
        textViewDate.setText( object.getPublishedAt() );

        //TODO : image will be download from url
        Picasso.get().load( object.getThumbnail() ).into( ImageThumb );

        youtubePostHolder.ImageThumb.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity( new Intent( mContext,DetailsActivity.class ) );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubePostHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDes;
        TextView textViewDate;
        ImageView ImageThumb;

        public YoutubePostHolder(@NonNull View itemView) {
            super( itemView );
            this.textViewTitle = (TextView) itemView.findViewById( R.id.textViewTitle );
            this.textViewDes = (TextView) itemView.findViewById( R.id.textViewDes );
            this.textViewDate = (TextView) itemView.findViewById( R.id.textViewDate );
            this.ImageThumb = (ImageView) itemView.findViewById( R.id.ImageThumb );


        }
    }
}
