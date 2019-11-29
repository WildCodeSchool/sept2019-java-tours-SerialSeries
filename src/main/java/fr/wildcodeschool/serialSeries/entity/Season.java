package fr.wildcodeschool.serialSeries.entity;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  This class is used as database model of a Season
 */
public class Season {
    private int id;
    private int serieId;
    private int number;

    public Season(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.serieId = resultSet.getInt("serie_id");
        this.number = resultSet.getInt("number");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}