package main.java.fr.wildcodeschool.serialSeries.entity.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SerieForm {

    @NotNull
    @Min(value = 1)
    private int nbSeason;

    @NotNull
    @Size(min = 3, max = 45)
    private String title;

    @NotNull
    @Min(value = 0)
    private int userId;

    public int getNbSeason() {
        return nbSeason;
    }

    public void setNbSeason(int nbSeason) {
        this.nbSeason = nbSeason;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
