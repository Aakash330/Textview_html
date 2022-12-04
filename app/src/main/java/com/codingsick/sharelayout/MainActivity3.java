package com.codingsick.sharelayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.net.URI;

public class MainActivity3 extends AppCompatActivity  {
    private TextView mTextView;
    Spannable html;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mTextView=findViewById(R.id.txview);

        PicassoImageGetter imageGetter = new PicassoImageGetter(mTextView,this);



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            html = (Spannable) Html.fromHtml(ConstentClass.data, Html.FROM_HTML_MODE_LEGACY,imageGetter, null);
        } else {
            html = (Spannable) Html.fromHtml(ConstentClass.data,imageGetter , null);
        }
        mTextView.setText(html);



    }



}