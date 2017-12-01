package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import app_interface.MainInterface;
import model.MMain;
import tannt.arrangenumber.R;
import viewholder.MainViewHolder;

/**
 * Created by tan.nt on 11/9/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<MMain> items;
    private MainInterface mainInterface;

    public void setItems(List<MMain> items) {
        this.items = items;
    }

    public void setMainInterface(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MainViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, int position) {
        final MMain mMain = items.get(position);
        holder.setData(mMain);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainInterface != null) {
                    mainInterface.onClickItem(mMain);
                    holder.cardView.setVisibility(View.INVISIBLE);
                    holder.cardView.setEnabled(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
