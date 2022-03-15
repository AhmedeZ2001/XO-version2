/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.version2;

import java.awt.Color;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class game extends javax.swing.JFrame {

    /**
     * Creates new form game
     */
    int play=0;
    public void chkt(){
        if(play%2==1)
            cpu();
    }            
            
    public boolean val(JButton m){
        if(m.isEnabled())
            return true;
        return false;
    }
    boolean cond =true;
    static boolean c =false;
    public void cpu(){
        Random random = new Random();
        int r = random.nextInt(9);
        System.out.println("choose: "+ r);
        System.out.println("play "+play);
        while(cond){
        switch(r){
            case 0:
                if( val(jButton4)){
                jButton4.doClick();
                cond=false;
                break;
                }
            case 1:
                if( val(jButton7)){
                jButton7.doClick();
                cond=false;
                break;
                }
              case 2:
               if( val(jButton6)){
                jButton6.doClick();
                cond=false;
                break;
                }

        
            case 3:
                if( val(jButton5)){
                jButton5.doClick();
                cond=false;
                break;
                }
        
            case 4:
               if( val(jButton2)){
                jButton2.doClick();
                cond=false;
                break;
                }

        
            case 5:
               if( val(jButton1)){
                jButton1.doClick();
                cond=false;
                break;
                }
  
        
            case 6:
               if( val(jButton3)){
                jButton3.doClick();
                cond=false;
                break;
                }
 
        
            case 7:
               if( val(jButton8)){
                jButton8.doClick();
                cond=false;
                break;
                }
         
            case 8:
                if( val(jButton9)){
                jButton9.doClick();
                cond=false;
                break;
                }
            default:
                        break;

        
        }
        }
    }
    String turn = "X";
    int px = 0;
    int po = 0;
    int moves = 0;
    boolean win = false;
    String[][] board = new String[3][3];

    public void giveTurn() {
        if (turn.equalsIgnoreCase("X")) {
            turn = "O";
            cond =true;
            }
         else {
            turn = "X";
            cond =true;
 
        }
    }

    public void upd(String c) {
        if (c.equalsIgnoreCase("X")) {
            px++;
        } else {
            po++;
        }
        jLabel4.setText(" " + px + " ");
        jLabel5.setText(" " + po + " ");
    }

    public void setColour(JButton x) {
        if (x.getText().equalsIgnoreCase("X")) {
            x.setBackground(Color.yellow);
        } else if (x.getText().equalsIgnoreCase("O")) {
            x.setBackground(Color.CYAN);
        }
    }

    public void reset() {
        jButton1.setEnabled(true);
        jButton1.setText(null);
        jButton1.setBackground(null);
        jButton2.setEnabled(true);
        jButton2.setText(null);
        jButton2.setBackground(null);
        jButton3.setEnabled(true);
        jButton3.setText(null);
        jButton3.setBackground(null);
        jButton4.setEnabled(true);
        jButton4.setText(null);
        jButton4.setBackground(null);
        jButton5.setEnabled(true);
        jButton5.setText(null);
        jButton5.setBackground(null);
        jButton6.setEnabled(true);
        jButton6.setText(null);
        jButton6.setBackground(null);
        jButton7.setEnabled(true);
        jButton7.setText(null);
        jButton7.setBackground(null);
        jButton8.setEnabled(true);
        jButton8.setText(null);
        jButton8.setBackground(null);
        jButton9.setEnabled(true);
        jButton9.setText(null);
        jButton9.setBackground(null);
        moves = 0;
        play = 0;
        win = false;
        cond=true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
    }

    public game() {
        setVisible(true);
        initComponents();
        setSize(1200, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Ahmed's XO Game");
    }

    public void chkwin(String[][] b, int row, int col, String c) {

        for (int i = 0; i < 3; i++) {
            if (b[row][i] != c) {
                break;
            }
            if (i == 2) {
                JOptionPane.showMessageDialog(null, "Player " + c + " Wins ", "Ahmed's XO Game", JOptionPane.INFORMATION_MESSAGE);
                win = true;
                upd(c);
                if (JOptionPane.showConfirmDialog(this, "Play Again?", "Ahmed's XO Game", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
                reset();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != c) {
                break;
            }
            if (i == 2) {
                JOptionPane.showMessageDialog(null, "Player " + c + " Wins ", "Ahmed's XO Game", JOptionPane.INFORMATION_MESSAGE);
                win = true;
                upd(c);
                if (JOptionPane.showConfirmDialog(this, "Play Again?", "Ahmed's XO Game", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
                reset();
            }
        }
        if (col == row) {
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != c) {
                    break;
                }
                if (i == 2) {
                    JOptionPane.showMessageDialog(null, "Player " + c + " Wins ", "Ahmed's XO Game", JOptionPane.INFORMATION_MESSAGE);
                    win = true;
                    upd(c);
                    if (JOptionPane.showConfirmDialog(this, "Play Again?", "Ahmed's XO Game", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                    reset();
                }
            }
        }
        if (col + row == 2) {
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i] != c) {
                    break;
                }
                if (i == 2) {
                    JOptionPane.showMessageDialog(null, "Player " + c + " Wins ", "Ahmed's XO Game", JOptionPane.INFORMATION_MESSAGE);
                    win = true;
                    upd(c);
                    if (JOptionPane.showConfirmDialog(this, "Play Again?", "Ahmed's XO Game", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    }
                    reset();
                }
            }
        }
        if (moves == 9 && !win) {
            JOptionPane.showMessageDialog(this, "Draw!!! ", "Ahmed's XO Game", JOptionPane.INFORMATION_MESSAGE);
            if (JOptionPane.showConfirmDialog(this, "Play Again?", "Ahmed's XO Game", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
            reset();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        jPanel2.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 400));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 100)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("XO Game");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        jButton4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jButton7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);

        jButton6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player X:");
        jPanel3.add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel3.add(jLabel4);

        jButton5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Player O:");
        jPanel3.add(jLabel3);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel3.add(jLabel5);

        jButton3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);

        jButton9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);

        jButton10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton10.setText("EXIT");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);

        jButton11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton11.setText("RESET");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        board[0][0] = turn;
        moves++;
        play++;
        jButton4.setText(turn);
        jButton4.setEnabled(false);
        setColour(jButton4);
        chkwin(board, 0, 0, turn);
       
        giveTurn();
         chkt();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        board[0][1] = turn;
        jButton7.setText(turn);
        moves++;
        play++;
        jButton7.setEnabled(false);
        setColour(jButton7);
        chkwin(board, 0, 1, turn);
        giveTurn();
         chkt();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        board[0][2] = turn;
        jButton6.setText(turn);
        moves++;
        play++;
        jButton6.setEnabled(false);
        setColour(jButton6);
        chkwin(board, 0, 2, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        board[1][0] = turn;
        jButton5.setText(turn);
        moves++;
        play++;
        jButton5.setEnabled(false);
        setColour(jButton5);
        chkwin(board, 1, 0, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        board[1][1] = turn;
        moves++;
        play++;
        jButton2.setText(turn);
        jButton2.setEnabled(false);
        setColour(jButton2);
        chkwin(board, 1, 1, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        board[1][2] = turn;
        jButton1.setText(turn);
        moves++;
        play++;
        jButton1.setEnabled(false);
        setColour(jButton1);
        chkwin(board, 1, 2, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        board[2][0] = turn;
        jButton3.setText(turn);
        moves++;
        play++;
        jButton3.setEnabled(false);
        setColour(jButton3);
        chkwin(board, 2, 0, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        board[2][1] = turn;
        jButton8.setText(turn);
        moves++;
        play++;
        jButton8.setEnabled(false);
        setColour(jButton8);
        chkwin(board, 2, 1, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        board[2][2] = turn;
        jButton9.setText(turn);
        moves++;
        play++;
        jButton9.setEnabled(false);
        setColour(jButton9);
        chkwin(board, 2, 2, turn);
        giveTurn();
         chkt();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        reset();
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
