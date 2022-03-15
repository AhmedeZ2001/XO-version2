/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.version2;

import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class XOVersion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(JOptionPane.showConfirmDialog(null,"Against Computer?","Ahmed's XO Game",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {   
            game.c=true;
           
        }
         game x= new game();
      
    }
    
}
