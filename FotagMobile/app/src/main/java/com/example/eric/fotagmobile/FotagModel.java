package com.example.eric.fotagmobile;

import java.net.URI;
import java.util.Observable;
import java.util.Observer;
import java.util.List;
import java.util.ArrayList;

public class FotagModel extends Observable {

    List<FotoInfo> allFoto;
    int filter_level;

    FotagModel(){
        allFoto = new ArrayList<FotoInfo>(0);
        filter_level = 0;
    }

    public int getFilter_level() {
        return filter_level;
    }

    public void setFilter_level(int filter_level) {
        this.filter_level = filter_level;
        setChanged();
        notifyObservers();
    }

    public void addFoto(FotoInfo f){
        allFoto.add(f);
        setFilter_level(0);
        setChanged();
        notifyObservers();
    }

    public void clearFoto() {
        allFoto.clear();
        setFilter_level(0);
        setChanged();
        notifyObservers();
    }

    public int numFotos(){
        return allFoto.size();
    }

    public FotoInfo at(int i){
        return allFoto.get(i);
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
