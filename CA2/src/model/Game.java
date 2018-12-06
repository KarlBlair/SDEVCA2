/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author X00149095
 */
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GAME")

@SequenceGenerator(name="gid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Game {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gid_seq")
    @Column(name="ID")
    private int ID;
    private String gameName, gameGenre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date releaseDate;
    // add a date

    public Game(int ID, String gameName, String gameGenre, Date releaseDate) {
        this.ID = ID;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.releaseDate = releaseDate;
    }
    
    public Game() {
        
    }
    
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    
}