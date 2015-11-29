import java.util.Date;

/**
 * Created by David Merriman on 11/28/2015.
 */
public class Franchise {
    //Fields
    private String name;
    private int gameCount;
    private Date firstReleaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public Date getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(Date firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }
}
