package itp341.carter.christin.a7.app.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import itp341.carter.christin.a7.app.R;

/**
 * Created by Chris on 10/27/2015.
 */
public class customArrayAdapter extends ArrayAdapter<Note>{
    public customArrayAdapter(Context context, ArrayList<Note> arrayList) {
        super(context, 0, arrayList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        TextView textViewTitle = (TextView) convertView.findViewById(R.id.textViewListItemTitle);
        TextView textViewDate = (TextView) convertView.findViewById(R.id.textViewListItemDate);

        textViewTitle.setText(note.getTitle());
        textViewDate.setText(note.getFormattedDate());

        return convertView;
    }
}
