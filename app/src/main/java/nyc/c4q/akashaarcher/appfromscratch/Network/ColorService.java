package nyc.c4q.akashaarcher.appfromscratch.Network;

import nyc.c4q.akashaarcher.appfromscratch.Pojos.ColorResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by akashaarcher on 11/14/16.
 */

public interface ColorService {

    @GET(" ")
    Call<ColorResponse> listColors();

}
