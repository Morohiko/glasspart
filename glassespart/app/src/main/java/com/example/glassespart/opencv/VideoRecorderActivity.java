package com.example.glassespart.opencv;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.glassespart.R;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.util.Timer;
import java.util.TimerTask;

public class VideoRecorderActivity extends AppCompatActivity {
    private static final int PERIOD_UPDATE_FRAME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recorder);
        Timer timer = new Timer();
        final AppCompatActivity appCompatActivity = this;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!OpenCVLoader.initDebug()) {
                    Log.d("OpenCV", "Internal OpenCV library not found. Using OpenCV Manager for initialization");
                    OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, appCompatActivity, mLoaderCallback);
                } else {
                    Log.d("OpenCV", "OpenCV library found inside package. Using it!");
                    mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
                }
            }
        };
        timer.schedule(timerTask, PERIOD_UPDATE_FRAME, PERIOD_UPDATE_FRAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d("OpenCV", "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d("OpenCV", "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            if (status == LoaderCallbackInterface.SUCCESS) {
                Log.i("OpenCV", "OpenCV loaded successfully");

                // TODO: remove wrapper
                Mat image = Mat.zeros(100, 50, CvType.CV_8UC3);
                Bitmap bm = Bitmap.createBitmap(image.cols(), image.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(image, bm);
                FramesQueue.getInstance().setBitmapFrame(bm);
                //

                updateFrame();
            } else {
                super.onManagerConnected(status);
            }
        }
    };

    private void updateFrame() {
        Log.d("DEBUG", "update frame");
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Bitmap frame = FramesQueue.getInstance().getBitmapFrame();
        if (frame == null) {
            Log.d("ERROR", "bitmap frame is null");
            return;
        }
        iv.setImageBitmap(frame);
    }
}



