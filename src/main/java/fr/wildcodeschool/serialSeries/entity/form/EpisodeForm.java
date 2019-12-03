package fr.wildcodeschool.serialSeries.entity.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  This class is used as form model of Episode to send request on database
 */
public class EpisodeForm {

    @NotNull
    @Min(value = 0)
    private int seasonId;

    @Size(min=3, max=100)
    private String title;

    @NotNull
    @Min(value = 0)
    private int number;

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

