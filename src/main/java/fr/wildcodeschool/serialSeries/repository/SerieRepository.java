package fr.wildcodeschool.serialSeries.repository;

import fr.wildcodeschool.serialSeries.entity.Episode;
import fr.wildcodeschool.serialSeries.entity.Season;
import fr.wildcodeschool.serialSeries.entity.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * All request used with the database on Serie TABLE
 */
public class SerieRepository {
    private static SerieRepository instance;

    public static SerieRepository getInstance() {
        return instance == null ? new SerieRepository(): instance;
    }

    
    public List<Serie> getUserSeriesByUserId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Serie LEFT JOIN Season ON Serie.id=Season.serie_id LEFT JOIN Episode ON Season.id=Episode.season_id WHERE user_id=? ORDER BY Serie.title"
            );

            statement.setInt(1, id);
            List<Serie>  series = new ArrayList<Serie>();
            ResultSet resultSet = statement.executeQuery();
            Map<Integer, Serie> serieList = new HashMap<Integer, Serie>();
            
            while (resultSet.next()){
            	if(serieList.containsKey(resultSet.getInt("Serie.id"))) {
            		//Season exist ?
            		Serie tmp = serieList.get(resultSet.getInt("Serie.id"));

            		if(tmp.getSeasonList().containsKey(resultSet.getInt("Season.id"))){
            			
            		}else {
            			Season tmpSeason = new Season();
                		tmpSeason.setId(id);
                		tmpSeason.setNumber(resultSet.getInt("Season.number"));
                		tmpSeason.setSerieId(resultSet.getInt("Serie.id"));
                		if(resultSet.getInt("Episode.id")==0) {
                    		Episode tmpEpisode = new Episode();
                    		tmpEpisode.setId(resultSet.getInt("Episode.id"));
                    		tmpEpisode.setNumber(resultSet.getInt("Episode.episode_numb"));
                    		tmpEpisode.setSeasonId(resultSet.getInt("Season.id"));
                    		tmpEpisode.setTitle(resultSet.getString("Episode.title"));
                    		tmpEpisode.setSeen(resultSet.getBoolean("seen"));
                    		tmpSeason.addEpisode(tmpEpisode);
                		}
                		tmp.addSeason(tmpSeason);	
            		}
            		
            	}else {            		
            		Serie tmp = new Serie();
            		tmp.setTitle(resultSet.getString("Serie.title"));
            		tmp.setId(resultSet.getInt("Serie.id"));
            		tmp.setPictureURL(resultSet.getString("Serie.serie_picture"));
            		tmp.setUserId(id);
            		if(resultSet.getInt("Season.id")==0) {
                		Season tmpSeason = new Season();
                		tmpSeason.setId(id);
                		tmpSeason.setNumber(resultSet.getInt("Season.number"));
                		tmpSeason.setSerieId(resultSet.getInt("Serie.id"));
                		if(resultSet.getInt("Episode.id")==0) {
                    		Episode tmpEpisode = new Episode();
                    		tmpEpisode.setId(resultSet.getInt("Episode.id"));
                    		tmpEpisode.setNumber(resultSet.getInt("Episode.episode_numb"));
                    		tmpEpisode.setSeasonId(resultSet.getInt("Season.id"));
                    		tmpEpisode.setTitle(resultSet.getString("Episode.title"));
                    		tmpEpisode.setSeen(resultSet.getBoolean("seen"));
                    		tmpSeason.addEpisode(tmpEpisode);
                		}
                		tmp.addSeason(tmpSeason);
            		}
            		serieList.put(resultSet.getInt("Serie.id"), tmp);
            	}
            	
                series.add(new Serie(resultSet));
            }
            for(Serie s : serieList.values()) {
            	System.out.println(s.getId()+"  === "+ s.getTitle());

                for(Season ss : s.getSeasonList()) {
                	System.out.println("   Season n° "+ss.getNumber()+" ID="+ss.getId());
                    for(Episode e : ss.getEpisodeList()) {
                    	System.out.println("      Episode n° "+e.getNumber()+" "+e.getTitle()+" ID="+e.getId());
                    }
                }
            }
            System.out.println("=================SIZE=================="+series.toArray().length);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * This method get all serie of a user by user_id from database
     * @return List of serie of a user
     */
    public List<Serie> getSerieByUserId(int id) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Serie WHERE user_id=? ORDER BY title"
            );

            statement.setInt(1, id);
            List<Serie>  series = new ArrayList<Serie>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                series.add(new Serie(resultSet));
            }
            return series;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Request on database to create serie
    public void createSerie(String title, int userId, String pictureURL) {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Serie(title, user_id,serie_picture) VALUES (?,?,?)"
            );

            statement.setString(1,title);
            statement.setInt(2,userId);
            statement.setString(3,pictureURL);

            statement.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


}

