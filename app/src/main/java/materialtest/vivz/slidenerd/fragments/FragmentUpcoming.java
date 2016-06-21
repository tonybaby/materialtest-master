package materialtest.vivz.slidenerd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import materialtest.vivz.slidenerd.adapters.AdapterMovies;
import materialtest.vivz.slidenerd.adapters.TaxiServicesAdapter;
import materialtest.vivz.slidenerd.callbacks.UpcomingMoviesLoadedListener;
import materialtest.vivz.slidenerd.database.DBMovies;
import materialtest.vivz.slidenerd.extras.MovieSorter;
import materialtest.vivz.slidenerd.extras.SortListener;
import materialtest.vivz.slidenerd.extras.StoreDetailsTaxiServices;
import materialtest.vivz.slidenerd.logging.L;
import materialtest.vivz.slidenerd.materialtest.MyApplication;
import materialtest.vivz.slidenerd.materialtest.R;
import materialtest.vivz.slidenerd.pojo.Movie;
import materialtest.vivz.slidenerd.task.TaskLoadUpcomingMovies;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUpcoming#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUpcoming extends Fragment implements SortListener, UpcomingMoviesLoadedListener {
    //The key used to store arraylist of movie objects to and from parcelable
    private static final String STATE_MOVIES = "state_movies";
    //the arraylist containing our list of box office his
    private ArrayList<Movie> mListMovies = new ArrayList<>();
    //the adapter responsible for displaying our movies within a RecyclerView
    private TaxiServicesAdapter mAdapter;
    //the recyclerview containing showing all our movies
    private RecyclerView mRecyclerMovies;
    //the TextView containing error messages generated by Volley
    private TextView mTextError;
    //the sorter responsible for sorting our movie results based on choice made by the user in the FAB
    private MovieSorter mSorter = new MovieSorter();

    public static List<StoreDetailsTaxiServices> listArray;

    public FragmentUpcoming() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentUpcoming.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUpcoming newInstance(String param1, String param2) {
        FragmentUpcoming fragment = new FragmentUpcoming();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onSortByName() {
        mSorter.sortMoviesByName(mListMovies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSortByDate() {
        mSorter.sortMoviesByDate(mListMovies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSortByRating() {
        mSorter.sortMoviesByRating(mListMovies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listArray = new ArrayList<>();

        StoreDetailsTaxiServices storeDetailsTaxiServices = new StoreDetailsTaxiServices();

        storeDetailsTaxiServices.setImageName("1");
        storeDetailsTaxiServices.setVehicleType("1");
        storeDetailsTaxiServices.setSeatingCapacity("seating_capacity");
        storeDetailsTaxiServices.setRatePerDay("rate_per_day");
        storeDetailsTaxiServices.setRatePerAdditionalKm("rate_per_additional_km");
        storeDetailsTaxiServices.setAllowedKmPerDay("allowed_km_per_day");

        listArray.add(storeDetailsTaxiServices);
        //mAdapter.notifyDataSetChanged();


        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_upcoming, container, false);
        mTextError = (TextView) layout.findViewById(R.id.textVolleyError);
        mRecyclerMovies = (RecyclerView) layout.findViewById(R.id.listMovieUpcoming);
        //set the layout manager before trying to display data
        mRecyclerMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TaxiServicesAdapter(listArray,getActivity());
        mRecyclerMovies.setAdapter(mAdapter);

//        if (savedInstanceState != null) {
//            //if this fragment starts after a rotation or configuration change, load the existing movies from a parcelable
//            mListMovies = savedInstanceState.getParcelableArrayList(STATE_MOVIES);
//        } else {
//            //if this fragment starts for the first time, load the list of movies from a database
//            mListMovies = MyApplication.getWritableDatabase().readMovies(DBMovies.UPCOMING);
//            //if the database is empty, trigger an AsycnTask to download movie list from the web
//            if (mListMovies.isEmpty()) {
//                L.m("FragmentUpcoming: executing task from fragment");
//                new TaskLoadUpcomingMovies(this).execute();
//            }
//        }
//        //update your Adapter to containg the retrieved movies
//        mAdapter.setMovies(mListMovies);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save the movie list to a parcelable prior to rotation or configuration change
        outState.putParcelableArrayList(STATE_MOVIES, mListMovies);
    }

    private void handleVolleyError(VolleyError error) {
        //if any error occurs in the network operations, show the TextView that contains the error message
        mTextError.setVisibility(View.VISIBLE);
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            mTextError.setText(R.string.error_timeout);

        } else if (error instanceof AuthFailureError) {
            mTextError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof ServerError) {
            mTextError.setText(R.string.error_auth_failure);
            //TODO
        } else if (error instanceof NetworkError) {
            mTextError.setText(R.string.error_network);
            //TODO
        } else if (error instanceof ParseError) {
            mTextError.setText(R.string.error_parser);
            //TODO
        }
    }

    @Override
    public void onUpcomingMoviesLoaded(ArrayList<Movie> listMovies) {
//        mAdapter.setMovies(listMovies);
    }
}
