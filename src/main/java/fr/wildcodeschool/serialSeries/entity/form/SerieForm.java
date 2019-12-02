package fr.wildcodeschool.serialSeries.entity.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  This class is used as form model of Serie to send request on database
 */

public class SerieForm {

    @NotNull
    @Size(min = 3, max = 45, message="Your title can't contain less than 3 characters and more than 45")
    private String title;

    @NotNull
    @Min(value = 0)
    private int userId;
    private String pictureURL;

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

	public String getPictureURL() {
		return pictureURL;
	}
	
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
}

