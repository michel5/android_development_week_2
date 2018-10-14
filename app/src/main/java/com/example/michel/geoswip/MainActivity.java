package com.example.michel.geoswip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GeoObjectAdapter mAdapter;
    private TextView textVieuw;

    //array list
    public final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding,
            R.drawable.afbeelding
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textVieuw = findViewById(R.id.melding_id);
        setSupportActionBar(toolbar);

        //vul recyclervieuw
        mRecyclerView = findViewById(R.id.recyclervieuw_id);

        //maak object aan
        final List<GeoObject> mGeoObjects = new ArrayList<>();
        for (int i = 0; i < PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {
            mGeoObjects.add(new GeoObject(PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));
        }

        //maak de recycler vieuw
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallbackLeft =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        mGeoObjects.remove(position);
                        mAdapter.notifyItemRemoved(position);
                        textVieuw.setText("Antwoord is goed");
                    }
                };

        ItemTouchHelper.SimpleCallback simpleItemTouchCallbackRight =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        mGeoObjects.remove(position);
                        mAdapter.notifyItemRemoved(position);
                        textVieuw.setText("Antwoord is fout want de plaats ligt in de eu");
                    }
                };


        ItemTouchHelper itemTouchHelperleft = new ItemTouchHelper(simpleItemTouchCallbackLeft);
        ItemTouchHelper itemTouchHelperRight = new ItemTouchHelper(simpleItemTouchCallbackRight);
        itemTouchHelperleft.attachToRecyclerView(mRecyclerView);
        itemTouchHelperRight.attachToRecyclerView(mRecyclerView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
