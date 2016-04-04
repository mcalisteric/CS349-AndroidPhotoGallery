package com.example.eric.fotagmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class FotoInfo  extends Observable{

    Uri uri;
    URL url;
    String location;
    int stars;

  /*  FotoInfo(String s){
        url = new URL(s);
        uri = new URI(s);
        location = s;
        stars = 0;
    }*/

    FotoInfo(URL u){
        url = u;
        uri = null;
        stars = 0;
        setChanged();
        notifyObservers();
    }

    FotoInfo(Uri u, int i){
        uri = u;
        url = null;
        stars = 0;
        setChanged();
        notifyObservers();
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int i){
        stars = i;
        setChanged();
        notifyObservers();
    }

    public URL getURL(){
        return url;
    }

    public Uri getUri(){
        return uri;
    }

    @Override
    public void addObserver(Observer observer){
        super.addObserver(observer);
    }

    @Override
    public void deleteObservers(){
        super.deleteObservers();
    }

    @Override
    public void notifyObservers(){
        super.notifyObservers();
    }

    @Override
    public void setChanged(){
        super.setChanged();
    }

    @Override
    public void clearChanged(){
        super.clearChanged();
    }
}
