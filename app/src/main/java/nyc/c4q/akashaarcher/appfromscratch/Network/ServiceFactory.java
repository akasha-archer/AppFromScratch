package nyc.c4q.akashaarcher.appfromscratch.Network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akashaarcher on 11/14/16.
 */
public class ServiceFactory {

    private static final String colorUrl = "https://192.168.1.129:8080";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder; //builder.build() will return our retrofit instance.

    public static ColorService createService() {
        if (retrofit == null) {
            builder = new Retrofit.Builder()
                    .baseUrl(colorUrl)
                    .addConverterFactory(GsonConverterFactory.create());

        }
        retrofit = builder.build();
        return retrofit.create(ColorService.class);
    }
}
