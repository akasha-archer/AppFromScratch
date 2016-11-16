package nyc.c4q.akashaarcher.appfromscratch.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akashaarcher on 11/14/16.
 */


public class Display {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("color")
    @Expose
    private String color;

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color The color
     */
    public void setColor(String color) {
        this.color = color;
    }

}