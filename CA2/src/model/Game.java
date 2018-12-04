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
public class Game {
    
    private int gameID;
    private String gameName, gameDeveloper;
    private String releaseDate;
    // add a date
    
    public Game(int gameID, String gameName, String gameDeveloper) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameDeveloper = gameDeveloper;
    }

    public Game() {
        
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }
}
