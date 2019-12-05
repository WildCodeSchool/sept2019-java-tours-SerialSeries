package fr.wildcodeschool.serialSeries.entity.form;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 *  This class is used as form model of Season to send request on database
 */

public class SeasonForm {
	@NotNull
    @Min(value = 1, message="You can't create season 0")
    private int number;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
