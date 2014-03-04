/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;

/**
 *
 * @author ncummins
 */
public class GameService implements Serializable {
    
    public int generateTargetNumber() {
        int target = (int) (Math.random() * 10) + 1;
        return target;
    }

    public String resultMessage(int target, int guess) {
        String result = "";
        if(guess == target) {
            result = "Your guess is correct";
        } else if (guess > target) {
            result = "Your guess is too high";
        } else {
            result = "Your guess is too low" ;
        }
        return result;
    }

}
