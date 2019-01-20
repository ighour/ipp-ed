/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.exceptions;

/**
 * User is already mentioned by another user.
 * @author igu
 */
public class UserIsAlreadyMentionedException extends Exception {
    public UserIsAlreadyMentionedException(){
        super();
    }
    public UserIsAlreadyMentionedException(String message){
        super(message);
    }
}
