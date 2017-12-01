package fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import app_interface.MainInterface;
import helper.AppConstant;
import helper.GridSpacingItemDecoration;
import helper.TempsData;
import model.MGame;
import model.MMain;
import model.MTemps;
import tannt.arrangenumber.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements MainInterface {

    private String TAG = GameFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;

    private MTemps currentTemps;
    private MGame currentGame;
    private MainAdapter adapter;
    private List<MMain> mainList;

    public static GameFragment newInstance(MTemps mTemps) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putParcelable(AppConstant.GAME_FRAGMENT_DATA, mTemps);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            currentTemps = getArguments().getParcelable(AppConstant.GAME_FRAGMENT_DATA);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        mRecyclerView = rootView.findViewById(R.id.mainRecyclerView);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), AppConstant.NUMBER_COUNTS);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4,4,true,4));

        adapter = new MainAdapter();
        mainList = new ArrayList<>();
        adapter.setItems(mainList);
        adapter.setMainInterface(this);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        currentGame = TempsData.generateGame(AppConstant.NUMBER_COUNTS, AppConstant.MAX_GRID);
        mainList.addAll(currentGame.getAllResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClickItem(MMain mMain) {

    }
}
