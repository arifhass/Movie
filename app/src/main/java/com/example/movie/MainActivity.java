package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter recyclerAdapter;

    RecyclerView recyclerView;
    List<MovieList> movieListModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListModels = new ArrayList<MovieList>();
        recyclerView = findViewById(R.id.recycler);
        movieListModels.add(new MovieList("1","9News"));
        movieListModels.add(new MovieList("2","ABC News"));
        movieListModels.add(new MovieList("3","The Age"));
        movieListModels.add(new MovieList("4","Sydney Morning Herald"));

        recyclerAdapter = new RecyclerAdapter(movieListModels, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ,RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);
    }

    public void switchContent( Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}
