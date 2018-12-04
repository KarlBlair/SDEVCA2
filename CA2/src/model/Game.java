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
//    private String releaseDate;
    // add a date
    
    public Game(String gameName, String gameGenre) {
        this.gameName = gameName;
        this.gameGenre = gameGenre;
    }

    public Game() {
        
    }

    public int getGameID() {
        return ID;
    }

    public void setGameID(int gameID) {
        this.ID = gameID;
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
}