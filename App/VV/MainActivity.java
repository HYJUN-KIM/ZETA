package com.example.videoviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView; // 비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; // 재생이나 정지와 같은 미디어 제어 버튼부 담당
    private String videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 앱이 첫 실행됐을 때 이곳을 수행한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView); // 비디오 뷰 아이디 연결
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoURL);

        // 참고: 내 res 폴더 안에 동영상이 있을 경우
        uri = Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.disinfect);

        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri); // 비디오 뷰 주소 설정

        // 1회 재생
        /*videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start(); // 비디오 실행
            }
        });*/
        // 연속 재생
        videoView.start();
        videoView.setOnCompletionListener(mp -> videoView.start());

    };

}
