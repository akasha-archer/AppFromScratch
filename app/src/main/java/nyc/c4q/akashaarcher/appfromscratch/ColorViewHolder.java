package nyc.c4q.akashaarcher.appfromscratch;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.akashaarcher.appfromscratch.Pojos.ColorPalette;

/**
 * Created by akashaarcher on 11/14/16.
 */

public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final View view;
    private TextView textView;

    public ColorViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        textView = (TextView) view.findViewById(R.id.color_display);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.color_setup, parent, false);
    }


    public void bind(ColorPalette colorPalette) {
        View root = textView.getRootView();
        textView.setText(colorPalette.getName());
        root.setBackgroundColor(Color.parseColor(colorPalette.getValue()));
    }

    @Override
    public void onClick(View view) {

    }
}

    /**

    private TextView textView;
    private Result currResult;

    public MovieViewHolder(View parent) {
        super(parent);
        textView = (TextView) itemView.findViewById(R.id.movie_title);
        textView.setOnClickListener(this);
    }


    public void bind(Result result){
        this.currResult = result;
        String title = result.getTitle();
        if(title != null)
            textView.setText(title);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), SingleMovieActivity.class);
        intent.putExtra("MOVIE_NAME", currResult.getTitle());
        v.getContext().startActivity(intent);
    }
}

     **/