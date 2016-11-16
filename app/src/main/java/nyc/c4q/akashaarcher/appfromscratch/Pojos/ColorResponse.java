package nyc.c4q.akashaarcher.appfromscratch.Pojos;

/**
 * Created by akashaarcher on 11/14/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ColorResponse {

    @SerializedName("display")
    @Expose
    private Display display;
    @SerializedName("colorPalette")
    @Expose
    private List<ColorPalette> colorPalette = new ArrayList<ColorPalette>();

    /**
     *
     * @return
     * The display
     */
    public Display getDisplay() {
        return display;
    }

    /**
     *
     * @param display
     * The display
     */
    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     *
     * @return
     * The colorPalette
     */
    public List<ColorPalette> getColorPalette() {
        return colorPalette;
    }

    /**
     *
     * @param colorPalette
     * The colorPalette
     */
    public void setColorPalette(List<ColorPalette> colorPalette) {
        this.colorPalette = colorPalette;
    }

}