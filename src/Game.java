import java.util.Date;

/**
 * Created by David Merriman on 11/28/2015.
 */
public class Game {
    //Fields
    private String title;
    private Date gameReleaseDate;
    private String franchiseName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(Date gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }
}
