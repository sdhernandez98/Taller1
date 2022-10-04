/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import modelo.beans.Usuario;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author XPG
 */
public class UsuarioLogic {
   private static UsuarioDAO userdao= new UsuarioDAO();
   
   public static boolean autentify(String username, String password){
       if (obtain(username)!=null) {
           Usuario userconsult=obtain(username);
           if (userconsult.getUsername().equals(username)&&userconsult.getPassword().equals(password)){
               return true;
           }
           else{
               return false;
           }
       }else{
           return false;
       }
   }
   
   public static boolean insert(Usuario username) {
       return userdao.insert(username);
   }
   
   public static boolean modify(Usuario username) {
       return userdao.modify(username);
   }
   
   public static boolean delete(String username) {
       return userdao.delete(username);
   }
   
   public static Usuario obtain (String username){
       return userdao.obtain(username);
   }
   
}
