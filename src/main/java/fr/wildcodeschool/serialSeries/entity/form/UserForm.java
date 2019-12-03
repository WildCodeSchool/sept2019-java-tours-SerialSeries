package fr.wildcodeschool.serialSeries.entity.form;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

/**
 *  This class is used as form model of User to send request on database
 */
public class UserForm {

    @Nullable
    private String pictureUrl;

    @NotNull
    @Size(min = 3, max = 100)
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}

