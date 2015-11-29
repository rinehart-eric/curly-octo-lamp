import java.util.Date;

/**
 * Created by David Merriman on 11/28/2015.
 */
public class ProducedBy {
    //Fields
    private String producerName;
    private String gameTitle;
    private Date gameReleaseDate;

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
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
