/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller.view.form;

import javax.swing.JDialog;
import javax.swing.JFrame;
import rs.ac.bg.fon.ps.controller.view.form.util.FormMode;

/**
 *
 * @author Ema
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        super("Projekat");
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuProduct = new javax.swing.JMenu();
        jmiProductNew = new javax.swing.JMenuItem();
        jmiProductShowAll = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuProduct.setText("Product");

        jmiProductNew.setText("New");
        jmiProductNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductNewActionPerformed(evt);
            }
        });
        jMenuProduct.add(jmiProductNew);

        jmiProductShowAll.setText("Show all");
        jmiProductShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductShowAllActionPerformed(evt);
            }
        });
        jMenuProduct.add(jmiProductShowAll);

        jMenuBarMain.add(jMenuProduct);

        jMenuAbout.setText("About");

        jmiAboutSoftware.setText("Software");
        jMenuAbout.add(jmiAboutSoftware);

        jMenuBarMain.add(jMenuAbout);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductNewActionPerformed
        JDialog frmProduct = new FrmProduct(this, true, FormMode.FORM_ADD);
        frmProduct.setVisible(true);
    }//GEN-LAST:event_jmiProductNewActionPerformed

    private void jmiProductShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductShowAllActionPerformed
         new FrmViewProducts(this,true).setVisible(true);
    }//GEN-LAST:event_jmiProductShowAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuProduct;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiProductNew;
    private javax.swing.JMenuItem jmiProductShowAll;
    // End of variables declaration//GEN-END:variables
}
