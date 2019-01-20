/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.trabalho.exceptions;

/**
 * User is already a contact of another user.
 * @author igu
 */
public class UserIsAlreadyAContactException extends Exception {
    public UserIsAlreadyAContactException(){
        super();
    }
    public UserIsAlreadyAContactException(String message){
        super(message);
    }
}
