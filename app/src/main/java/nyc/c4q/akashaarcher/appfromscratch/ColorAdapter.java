package nyc.c4q.akashaarcher.appfromscratch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.akashaarcher.appfromscratch.Pojos.ColorPalette;

/**
 * Created by akashaarcher on 11/14/16.
 */

public class ColorAdapter extends RecyclerView.Adapter {

    Context context;
    private List<ColorPalette> colors;

    public ColorAdapter(Context context) {
        this.context = context;
        this.colors = new ArrayList<>();
    }


    public void setColors(List<ColorPalette> colors) {
        this.colors = colors;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColorViewHolder colorViewHolder = (ColorViewHolder) holder;
        ColorPalette colorList = colors.get(position);
        colorViewHolder.bind(colorList);

    }

    @Override
    public int getItemCount() {
        return colors.size();
    }
}
