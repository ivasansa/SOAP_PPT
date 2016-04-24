/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ivan
 */
@WebService(serviceName = "Soap")
public class Soap {

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
//
//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "suma")
//    public Integer suma(@WebParam(name = "i") Integer i, @WebParam(name = "j") Integer j) {
//        //TODO write your implementation code here:
//        return i+j;
//    }
    
    ArrayList<Partida> llistaPartides = new ArrayList<Partida>();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "iniciarJoc")
    public Boolean iniciarJoc(@WebParam(name = "codiPartida") int codiPartida, 
            @WebParam(name = "jug1") String jug1) {
        boolean flag = false;
        
        for(int i = 0; i < llistaPartides.size(); ++i){
            if(llistaPartides.get(i).getID() == codiPartida){
                llistaPartides.get(i).setJUG2(jug1);
                flag = true;
                return false;
            }
        }
        if(!flag){
            Partida p = new Partida(codiPartida, jug1);
            llistaPartides.add(p);
            return true;
        }
        

        return null;
    }

    
    @WebMethod(operationName = "moureJugador")
    public Boolean moureJugador(@WebParam(name = "tipus") int tipus, 
            @WebParam(name = "jug") String jug, 
            @WebParam(name = "codiPartida") int codiPartida) {
        
        for(int i = 0; i < llistaPartides.size(); ++i){
            if(llistaPartides.get(i).getID() == codiPartida){
                if(llistaPartides.get(i).getJUG1().getNick() == jug){
                    llistaPartides.get(i).getJUG1().setMoviment(tipus);
                } else if (llistaPartides.get(i).getJUG2().getNick() == jug){
                    llistaPartides.get(i).getJUG2().setMoviment(tipus);
                } else{
                    System.out.println("ErrorMoureJug");
                }
                return false;
            }
        }
        
        return true;
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "consultarEstatPartida")
    public Integer consultarEstatPartida(@WebParam(name = "codiPartida") int codiPartida) {
        
        for(int i = 0; i < llistaPartides.size(); ++i){
            if(llistaPartides.get(i).getID() == codiPartida){/*
                if(llistaPartides.get(i).getJUG1().getNick() == jug){
                    llistaPartides.get(i).getJUG1().setMoviment(tipus);
                } else if (llistaPartides.get(i).getJUG2().getNick() == jug){
                    llistaPartides.get(i).getJUG2().setMoviment(tipus);
                } else{
                    System.out.println("ErrorMoureJug");
                }
                return false;*/
            }
        }
        return null;
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "acabarJoc")
    public Boolean acabarJoc(@WebParam(name = "codiPartida") int codiPartida) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */

    /**
     * Web service operation
     */
    
    
}
