package info.pauek.moviesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MovieActivity extends AppCompatActivity {

    // model
    private Movie movie;

    // referències a objectes de la pantalla
    private TextView titleview;
    private TextView yearview;
    private TextView ratedview;
    private TextView runtimeview;
    private TextView genreview;
    private TextView directorview;
    private TextView writerview;
    private TextView actorsview;
    private TextView plotview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        try {
            InputStream stream = getAssets().open("lord.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            movie = gson.fromJson(reader, Movie.class);
        }
        catch (IOException e) {
            Toast.makeText(this, "No he pogut llegir el fitxer", Toast.LENGTH_SHORT).show();
        }

        titleview = findViewById(R.id.titleview);
        yearview = findViewById(R.id.yearview);
        ratedview = findViewById(R.id.ratedview);
        runtimeview = findViewById(R.id.runtimeview);
        genreview = findViewById(R.id.genreview);
        directorview = findViewById(R.id.directorview);
        writerview = findViewById(R.id.writerview);
        actorsview = findViewById(R.id.actorsview);
        plotview = findViewById(R.id.plotview);

        titleview.setText(movie.getTitle());
        yearview.setText(movie.getYear());
        ratedview.setText(movie.getRated());
        runtimeview.setText(movie.getRuntime());
        genreview.setText(movie.getGenre());
        directorview.setText(movie.getDirector());
        writerview.setText(movie.getWriter());
        actorsview.setText(movie.getActors());
        plotview.setText(movie.getPlot());
    }
}
