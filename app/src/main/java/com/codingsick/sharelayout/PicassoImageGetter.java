package com.codingsick.sharelayout;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoImageGetter implements Html.ImageGetter {

    private TextView textView;
    private Context context;
    private int width,height;
    private  String img,TAG="ho";


    public PicassoImageGetter(TextView mTextView, MainActivity3 mainActivity3) {

        textView=mTextView;
        context=mainActivity3;
    }

    @Override
    public Drawable getDrawable(String s) {

        img=s;
        BitmapDrawablePlaceHolder drawable = new BitmapDrawablePlaceHolder();

        Picasso.get()
                .load(img)
                .into((com.squareup.picasso.Target)drawable);

        if(width>153 ) {
            Picasso.get()
                    .load(img)
                    .resize(350, 50)
                    .into(drawable);
        }
        else
        {
            Picasso.get()
                    .load(img)
                    .into((com.squareup.picasso.Target)drawable);
        }

        Log.w(TAG,""+drawable.getMinimumHeight());
        Log.w(TAG,""+drawable.getMinimumWidth());
        Log.d("data", "getDrawable: "+s);

        return drawable;
    }

    private  class BitmapDrawablePlaceHolder extends BitmapDrawable implements Target {

        protected Drawable drawable;

        @Override
        public void draw(final Canvas canvas) {

            if (drawable != null) {
                drawable.draw(canvas);
            }

        }

        public void setDrawable(Drawable drawable) {

             this.drawable = drawable;

             width = drawable.getIntrinsicWidth();
             height = drawable.getIntrinsicHeight();

            Log.w(TAG,""+width);
            Log.w(TAG,""+height);
            drawable.setBounds(0, 0, width, height);
            setBounds(0, 0, width, height);

        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {


            setDrawable(new BitmapDrawable(context.getResources(), bitmap));
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }


        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }

    }

}
