package com.example.shivam.opencvtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.engine.OpenCVEngineInterface;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener{
    JavaCameraView javaCameraView;
    Mat mat;
    BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case BaseLoaderCallback.SUCCESS:
                    javaCameraView.enableView();
                    break;
                default:
                    super.onManagerConnected(status);
                    break;

            }


        }
    };
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (javaCameraView!=null){
            javaCameraView.disableView();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(OpenCVLoader.initDebug()){
            Log.d("yo**************","loaded");
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
        else
        {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_2_0,this,baseLoaderCallback);
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (javaCameraView!=null){
            javaCameraView.disableView();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Mat mat;
javaCameraView=(JavaCameraView)findViewById(R.id.javaCamView);
        javaCameraView.setVisibility(View.VISIBLE);
        javaCameraView.setCvCameraViewListener(this);

    }

    static {

    }

    @Override
    public void onCameraViewStarted(int width, int height) {
        mat = new Mat(height,width, CvType.CV_8UC4);

    }

    @Override
    public void onCameraViewStopped() {
mat.release();
    }

    @Override
    public Mat onCameraFrame(Mat inputFrame) {
        mat=inputFrame;

        return mat;
    }
}
