package fr.wildcodeschool.serialSeries.entity.form;

public class SerieForm {

	private int nbSeason;
	private String title;
	private int userId;

	public SerieForm(String title, int nbSeason, int userId) {
		this.title = title;
		this.nbSeason= nbSeason;
		this.userId=userId;
	}

	public SerieForm() {
		// TODO Auto-generated constructor stub
	}

	public int getNbSeason() {
		return nbSeason;
	}

	public String getTitle() {
		return title;
	}

	public int getUserId() {
		return userId;
	}

	public void setNbSeason(int nbSeason) {
		this.nbSeason = nbSeason;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUserId(int id) {
		this.userId = id;
	}
}
