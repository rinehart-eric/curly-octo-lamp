import java.util.Date;

/**
 * Created by David Merriman on 11/28/2015.
 */
public class GamePlatform {
    //Fields
    private String gameTitle;
    private Date gameReleaseDate;
    private String platformName;
    private Date gameReleaseDateOnPlatform;
    private int sales;

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Date getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(Date gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Date getGameReleaseDateOnPlatform() {
        return gameReleaseDateOnPlatform;
    }

    public void setGameReleaseDateOnPlatform(Date gameReleaseDateOnPlatform) {
        this.gameReleaseDateOnPlatform = gameReleaseDateOnPlatform;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
