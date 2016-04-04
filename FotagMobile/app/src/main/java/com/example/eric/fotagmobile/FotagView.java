package com.example.eric.fotagmobile;

import java.util.Observable;
import java.util.Observer;
import android.content.Context;
import android.widget.GridLayout;

public class FotagView extends GridLayout implements Observer{

    private FotagModel fotagModel;
    int rating;

    FotagView(Context context, FotagModel fm){
        super(context);
        //INFLATE
        fotagModel = fm;
        fotagModel.addObserver(this);
        rating = 0;
    }

    public void update(Observable observable, Object data){
        //blank to suppress warnings for now
    }
}
