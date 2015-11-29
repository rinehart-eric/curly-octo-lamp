import java.util.Date;

/**
 * Created by David Merriman on 11/28/2015.
 */
public class DevelopedBy {
    //Fields
    private String developerName;
    private String gameTitle;
    private Date gameReleaseDate;

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

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
}
