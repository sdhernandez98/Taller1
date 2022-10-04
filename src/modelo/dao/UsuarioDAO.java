/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Usuario;



/**
 *
 * @author XPG
 */
public class UsuarioDAO {
    private List<Usuario> users;

    public UsuarioDAO() {
        users= new ArrayList<>();
    }
    
    public int find(String username){
       int n=-1;
       for (int i = 0; i < users.size(); i++) {
           if (users.get(i).getUsername().equals(username)){
               n=i;
               break;
            }
       }
       return n;
    }
    
    public boolean insert(Usuario username){
        if (find(username.getUsername())==-1) { 
            users.add(username);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean modify (Usuario username){
        if (find(username.getUsername())!=-1) { 
            Usuario useraux= obtain(username.getUsername());
            
            useraux.setPassword(username.getPassword());
            useraux.setNames(username.getNames());
            useraux.setSurnames(username.getSurnames());
            useraux.setEmail(username.getEmail());
            
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean delete (String username){
        if (find(username)!=-1) {  
            users.remove(find(username));
            return true;
        }else{
            return false;
        }
        
        
    }
    
    public Usuario obtain (String username){
        if (find(username)!=-1) {
            return users.get(find(username));
        }else{
            return null;
        }
    }    
}
