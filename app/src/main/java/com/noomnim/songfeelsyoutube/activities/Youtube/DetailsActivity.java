package com.noomnim.songfeelsyoutube.activities.Youtube;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.noomnim.songfeelsyoutube.R;
import com.noomnim.songfeelsyoutube.models.YoutubeDataModel;
import com.squareup.picasso.Picasso;



public class DetailsActivity extends Activity {
    private YoutubeDataModel youtubeDataModel = null;
    TextView textViewName;
    TextView textViewDes;
    TextView textViewDate;
    ImageView imageViewIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );
        youtubeDataModel = getIntent().getParcelableExtra( YoutubeDataModel.class.toString() );
        Log.e( "DetailsActivity", youtubeDataModel.getDescription() );

        textViewName = (TextView) findViewById( R.id.textViewName );
        textViewDes = (TextView) findViewById( R.id.textViewDes );
        imageViewIcon = (ImageView) findViewById(R.id.imageView);
        textViewDate = (TextView) findViewById( R.id.textViewDate );

        textViewName.setText( youtubeDataModel.getTitle() );
        textViewDes.setText( youtubeDataModel.getDescription() );
        textViewDate.setText( youtubeDataModel.getPublishedAt() );

        try {
            if(youtubeDataModel.getThumbnail() != null){
                if(youtubeDataModel.getThumbnail().startsWith( "http" )){
                    Picasso.get()
                            .load( youtubeDataModel.getThumbnail() )
                            .into( imageViewIcon );
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void playVideo(View view){
        startActivity( new Intent( DetailsActivity.this, VideoPlayerActivity.class ) );
    }
}
