/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Datenbank;
import controller.MapGrid;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.NPC;

/**
 *
 * @author Sehri Singh
 */
public class MapSettings extends javax.swing.JFrame {
    Datenbank db;
    /**
     * Creates new form MapSettings
     * @param db the Database Connection
     */
    public MapSettings(Datenbank db) {
       this.db = db;
       initComponents();
       this.fillTileSettingsPanel(30,30);
       this.ySizeInput.setColumns(4);
       this.xSizeInput.setColumns(4);
       System.out.println(this.ySizeInput.getMinimumSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartBTN = new javax.swing.JButton();
        BackBTN = new javax.swing.JButton();
        SettingsPanel = new javax.swing.JPanel();
        xSizeInput = new javax.swing.JTextField();
        ySizeInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrinceAmountInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tileSettingsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MapGeneratorSettings");

        StartBTN.setText("Start");
        StartBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartBTNActionPerformed(evt);
            }
        });

        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });

        xSizeInput.setText("3");

        ySizeInput.setText("3");

        jLabel1.setText("X Size");

        jLabel2.setText("Y Size");

        PrinceAmountInput.setText("32");
        PrinceAmountInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrinceAmountInputActionPerformed(evt);
            }
        });

        jLabel3.setText("Prince Amount");

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(PrinceAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(xSizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ySizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(34, 34, 34))
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xSizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ySizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(PrinceAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tileSettingsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tileSettingsPanelLayout = new javax.swing.GroupLayout(tileSettingsPanel);
        tileSettingsPanel.setLayout(tileSettingsPanelLayout);
        tileSettingsPanelLayout.setHorizontalGroup(
            tileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        tileSettingsPanelLayout.setVerticalGroup(
            tileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(tileSettingsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(SettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StartBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void StartBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartBTNActionPerformed
        // TODO add your handling code here:
        
        CellMap map = new CellMap(Integer.parseInt(this.xSizeInput.getText()), 
                Integer.parseInt(this.ySizeInput.getText()));
        map.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_StartBTNActionPerformed

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        // TODO add your handling code here:
        MainMenu menu = new MainMenu(this.db);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackBTNActionPerformed

    private void ConDbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConDbBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ConDbBtnActionPerformed

    private void FillNpcsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FillNpcsBTNActionPerformed
        // TODO add your handling code here:
        NPC npc = new NPC("Deutschland", "Germany", 100,
                "Mensch", "Kartoffel", "Baecker", "100",
                "Rentenversicherung", 1000, "Humans", "Vaterland",
                100, 100, "Doof", "Olaf Scholz");
        this.db.insertNPC(npc);
        
    }//GEN-LAST:event_FillNpcsBTNActionPerformed

    private void PrinceAmountInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrinceAmountInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrinceAmountInputActionPerformed

    /**
     * Function to fill the TileSettingsPanel with all Images available as Tile
     * @param x x Size for Icon Image
     * @param y y Size for Icon Image
     */
    private void fillTileSettingsPanel(int x, int y){
        File[] files = new File("Images//Tiles").listFiles();
        tileSettingsPanel.setLayout(new GridLayout(files.length/2, files.length/2));
        for(int i = 0; files.length > i; i++){
            JButton tileImage = new JButton();
            tileImage.setSize(x,y);
            tileImage.setVisible(true);
            tileImage.setBackground(Color.RED);
            tileImage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //your actions
                    if(tileImage.getBackground() == Color.GREEN){tileImage.setBackground(Color.RED);}
                    else if (tileImage.getBackground() == Color.RED){tileImage.setBackground(Color.GREEN);}
                }
            });
            try{
                Image icon = ImageIO.read(files[i].getAbsoluteFile()).getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
                tileImage.setIcon(new ImageIcon(icon));
            } catch (IOException e) {
                Logger.getLogger(MapGrid.class.getName()).log(Level.SEVERE, null, e);
            }
            tileSettingsPanel.add(tileImage);
        }
        tileSettingsPanel.repaint();
        System.out.println(files.length);
    }
    
    
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
            java.util.logging.Logger.getLogger(MapSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapSettings(new Datenbank()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JTextField PrinceAmountInput;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JButton StartBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel tileSettingsPanel;
    private javax.swing.JTextField xSizeInput;
    private javax.swing.JTextField ySizeInput;
    // End of variables declaration//GEN-END:variables
}
