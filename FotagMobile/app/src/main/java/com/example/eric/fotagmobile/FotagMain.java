package com.example.eric.fotagmobile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class FotagMain extends AppCompatActivity {
    String img_loc = "";
    Context context;
    FotagModel model;
    BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_fotag_main);
        model = new FotagModel();
        final GridView gridview = (GridView)findViewById(R.id.gridview);
        adapter = new FotoAdapter(context, model);
        gridview.setAdapter(adapter);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //loadimage:
                    AlertDialog.Builder imgsearch = new AlertDialog.Builder(FotagMain.this);
                    imgsearch.setTitle("Image URL");

                    final EditText et = new EditText(FotagMain.this);
                    et.setTextIsSelectable(true);
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                    imgsearch.setView(et);

                    imgsearch.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                img_loc = et.getText().toString();
                                URL test = new URL(img_loc);
                                                                model.addFoto(new FotoInfo(test));
                                Toast toast = Toast.makeText(context, "Added Foto", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            catch(MalformedURLException e){
                                //Toast toast = Toast.makeText(context, "Could Not Load URL", Toast.LENGTH_SHORT);
                                //toast.show();
                                e.printStackTrace();
                            }
                            catch(IOException e){
                                e.printStackTrace();
                            }
                            catch(RuntimeException e){
                                e.printStackTrace();
                            }
                        }
                    });
                    imgsearch.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    imgsearch.show();

                }
            });
        }
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fotag_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement;
        if (id == R.id.clear_images) {
            model.clearFoto();
        }

        if (id == R.id.add_preset_images){
            Uri gif1 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.gif1);
            model.addFoto(new FotoInfo(gif1, R.drawable.gif1));
            Uri gif2 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.gif2);
            model.addFoto(new FotoInfo(gif2, R.drawable.gif2));
            Uri gif3 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.gif3);
            model.addFoto(new FotoInfo(gif3, R.drawable.gif3));
            Uri png1 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.png1);
            model.addFoto(new FotoInfo(png1, R.drawable.png1));
            Uri png2 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.png2);
            model.addFoto(new FotoInfo(png2, R.drawable.png2));
            Uri png3 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.png3);
            model.addFoto(new FotoInfo(png3, R.drawable.png3));
            Uri jpg1 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.jpg1);
            model.addFoto(new FotoInfo(jpg1, R.drawable.jpg1));
            Uri jpg2 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.jpg2);
            model.addFoto(new FotoInfo(jpg2, R.drawable.jpg2));
            Uri jpg3 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.jpg3);
            model.addFoto(new FotoInfo(jpg3, R.drawable.jpg3));
            Uri jpg4 = Uri.parse("android.resource://com.example.eric.fotagmobile/" + R.drawable.jpg4);
            model.addFoto(new FotoInfo(jpg4, R.drawable.jpg4));
        }

        return super.onOptionsItemSelected(item);
    }
}
