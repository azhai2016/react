package com.baq.rn.zbar;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.View;


import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


public class ZbarScannerActivity extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;
    private Context mContext;
    private static final int ZBAR_CAMERA_PERMISSION = 1;
    

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_zbar_scanner);
        mContext = this;
        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZBarScannerView(this);
        contentFrame.addView(mScannerView);

        findViewById(R.id.flashModelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScannerView.setFlash(true);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

            Intent intent = new Intent(mContext, ZbarScannerActivity.class);
            intent.putExtra("code",rawResult.getContents());
            setResult(RESULT_OK, intent);
            finish();
            ///intent.putExtra(URLs.kCodeInfo, rawResult.getContents());
            //intent.putExtra(URLs.kCodeType, rawResult.getBarcodeFormat().getName());
            //mContext.startActivity(intent);
       

//        Toast.makeText(this, "Contents = " + rawResult.getContents() +
//                ", Format = " + rawResult.getBarcodeFormat().getName(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(getApplicationContext(), TakePhoto.class);
//        intent.putExtra("code", rawResult.getContents());
//        startActivity(intent);

       /* Intent intent = getIntent();
        intent.putExtra("code",rawResult.getContents());
        setResult(RESULT_OK, intent);
        finish();  */


        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mScannerView.resumeCameraPreview(ZbarScannerActivity.this);
//            }
//        }, 2000);
    }
}
