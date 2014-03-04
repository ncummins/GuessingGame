

package managed.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.GameService;

/**
 *
 * @author ncummins
 */
@Named
@SessionScoped
public class GameBean implements Serializable{
    private boolean btnSubmit;
    private boolean btnQuit;
    private int target;
    private int guess;
    private int numGuesses;
    private int numGames;
    String result = "";
    @Inject
    private GameService service;
    
    /**
     * Default constructor
     */
    public GameBean(){
    }
    
    @PostConstruct
    public void init(){
        target = 5;
        guess = 0;
        numGuesses = 0;
        numGames = 1;
        btnSubmit = false;
        btnQuit = false;
    }

    public void startNewGame(){
        target = service.generateTargetNumber();
        numGuesses = 0;
        guess = 0;
        numGames += 1;
        btnSubmit = true;
        btnQuit = true;
    }
    
    public void check(){
        numGuesses += 1;
    }
    
    public String resultMessage(){
        return service.resultMessage(target, guess);
    }
    
    public void quitGame(){
        numGuesses = 0;
        guess = 0;
        btnSubmit = false;
        btnQuit = false;
    }
    
    
    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public GameService getService() {
        return service;
    }

    public void setService(GameService service) {
        this.service = service;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public int getNumGames() {
        return numGames;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public boolean isBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(boolean btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public boolean isBtnQuit() {
        return btnQuit;
    }

    public void setBtnQuit(boolean btnQuit) {
        this.btnQuit = btnQuit;
    }
    
    
    
    
}
