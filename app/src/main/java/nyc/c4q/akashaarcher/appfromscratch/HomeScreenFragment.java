package nyc.c4q.akashaarcher.appfromscratch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.akashaarcher.appfromscratch.Network.ColorService;
import nyc.c4q.akashaarcher.appfromscratch.Network.ServiceFactory;
import nyc.c4q.akashaarcher.appfromscratch.Pojos.ColorPalette;
import nyc.c4q.akashaarcher.appfromscratch.Pojos.ColorResponse;
import nyc.c4q.akashaarcher.appfromscratch.Pojos.Display;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by akashaarcher on 11/14/16.
 */

public class HomeScreenFragment extends Fragment {


    private List<ColorPalette> colorList;
    private ColorAdapter adapter;

    private Display pageHeading = new Display();
    private TextView headingView;
    private RecyclerView colorRecyclerView;
    ColorService colorService;

//    JSONObject object = new JSONObject("{\"display\":{\"text\":\"Man this is difficult\",\"color\":\"DarkSalmon\"},\"colorPalette\":[{\"name\":\"Crimson\",\"value\":\"DC143C\"},{\"name\":\"SpringGreen\",\"value\":\"00FF7F\"},{\"name\":\"Banana\",\"value\":\"E3CF57\"},{\"name\":\"DarkSalmon\",\"value\":\"E9967A\"}]} ");
//
//    public HomeScreenFragment() throws JSONException {
//
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        colorService = ServiceFactory.createService();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_fragment, container, false);
        headingView = (TextView) view.findViewById(R.id.rv_heading);
        //headingView.setText(pageHeading.getText());
        // headingView.setTextColor(Integer.parseInt(pageHeading.getColor()));

        colorList = new ArrayList<>();

        adapter = new ColorAdapter(getContext());
        colorRecyclerView = (RecyclerView) view.findViewById(R.id.color_rv);
        colorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        colorRecyclerView.setAdapter(adapter);


//        initViews(view);
        return view;
    }

//    public void initViews(View view) {
//        colorRecyclerView = (RecyclerView) view.findViewById(R.id.color_rv);
//        colorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Call<ColorResponse> colorCall = colorService.listColors();
        colorCall.enqueue(new Callback<ColorResponse>() {
            @Override
            public void onResponse(Call<ColorResponse> call, Response<ColorResponse> response) {
                ColorResponse colorResp = response.body();
                colorList = colorResp.getColorPalette();
                adapter.setColors(colorList);
                Log.i("LIST:", colorList.size() + "");
                Log.d(TAG, "There was a success" + response);
            }

            @Override
            public void onFailure(Call<ColorResponse> call, Throwable t) {
                Log.d(TAG, "There was a failure" + t);
            }
        });

    }
}