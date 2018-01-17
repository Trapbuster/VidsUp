package com.tbtech.vidsup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{
private EditText URi;
private Button gButton;
private VideoView vidView;
private String vidAddress;
private MediaController vidControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URi = (EditText) findViewById(R.id.editText);
        gButton = (Button) findViewById(R.id.button);
        final MediaController vidControl = new MediaController(this);
        final VideoView vidView = (VideoView)findViewById(R.id.videoView);
        vidControl.setAnchorView(vidView);



        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vidAddress = URi.getText().toString();
                vidView.setVisibility(View.VISIBLE);
                Uri vidUri = Uri.parse(vidAddress);
                vidView.setVideoURI(vidUri);
                vidView.setMediaController(vidControl);
                vidView.start();
            }
        });

    }

}
