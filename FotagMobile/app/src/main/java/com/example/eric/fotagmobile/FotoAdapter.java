package com.example.eric.fotagmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class FotoAdapter extends BaseAdapter implements Observer{

    Context context;
    FotagModel model;
    List<Bitmap> images;

    public FotoAdapter(Context c, FotagModel m) {
        context = c;
        model = m;
        model.addObserver(this);
        images = new ArrayList<>(0);
    }

    public int getCount() {
        return images.size();
    }

    public Object getItem(int position) {
        return images.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

  //  public void setUrl(URL url)
  // {
     //   this.url = url;
 //   }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
               imageView = new ImageView(context);
               imageView.setLayoutParams(new GridView.LayoutParams(700, 700));
               imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
               imageView.setPadding(0, 0, 0, 0);
            //InputStream is = url.openStream();

 //           Bitmap bmp = BitmapFactory.decodeStream(is);
 //           img.setImageBitmap(bmp);
        } else {
            imageView = (ImageView) convertView;
        }

       // imageView.setImageResource(mThumbIds[position]);
        imageView.setImageBitmap(images.get(position));
     /*  imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setLayoutParams(new LinearLayout.LayoutParams(imageView.getMaxHeight(),imageView.getMaxWidth()));
            }
        });*/
        /*RatingBar bar = new RatingBar(imageView.getContext());
        bar.setNumStars(5);
        bar.showContextMenu();*/
       // bar.setOnClickListener();
        return imageView;
    }

    public void update(Observable observable, Object data){
        try{
        int i = 0;
        images.clear();
        while(i < model.numFotos()) {
            if(model.at(i).getURL() != null) {
                images.add(BitmapFactory.decodeStream(model.at(i).getURL().openStream()));
            }
            else{
                images.add(BitmapFactory.decodeStream(context.getContentResolver().openInputStream(model.at(i).getUri())));
            }
            i++;
        }
            this.notifyDataSetChanged();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
