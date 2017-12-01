package viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import model.MMain;
import tannt.arrangenumber.R;

/**
 * Created by tan.nt on 11/9/17.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    private TextView textView;

    public MainViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.itm_layout);
        textView = itemView.findViewById(R.id.itm_display);
    }

    public void setData(MMain mMain){
        textView.setText(String.valueOf(mMain.getValue()));
        cardView.setVisibility(mMain.getValue() == 0 ? View.INVISIBLE : View.VISIBLE);
        cardView.setEnabled(mMain.getValue() > 0);
    }
}
