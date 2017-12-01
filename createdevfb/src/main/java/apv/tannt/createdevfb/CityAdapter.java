package apv.tannt.createdevfb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tan.nt on 11/29/17.
 */

public class CityAdapter extends BaseAdapter {
    private List<CityObject> objects;

    public void setObjects(List<CityObject> objects) {
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = view;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        }

        TextView city = convertView.findViewById(R.id.city);
        TextView votes = convertView.findViewById(R.id.votes);

        CityObject currentObject = objects.get(i);

        city.setText(currentObject.getName());
        votes.setText(String.valueOf(currentObject.getVotes()));

        return convertView;
    }
}
