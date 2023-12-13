/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.MapGrid;
import controller.POI;
import controller.TilePlacer;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import model.Cell;
import controller.Datenbank;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ScrollPaneLayout;
import model.NPC;
/**
 * The generated Map as View
 * @author Sehri Singh
 */
public class CellMap extends javax.swing.JFrame {
    private MapGrid Map;
    private GridBagLayout gridLayout;
    private TilePlacer tileplacer;
    private JLayeredPane LayerView;
    private JPanel CellView;
    private JPanel POIView;
    /**
     * Creates new form GeneratorPicker
     * @param AmountX
     * @param AmountY
     */
    public CellMap(int AmountX, int AmountY) {
        initComponents();
        this.tileplacer = new TilePlacer();
        Object[] objList = new Object[1];
        this.Map = new MapGrid(AmountX, AmountY);
        Cell[][] cellList = this.tileplacer.placeTileSet(AmountX, AmountY);
        //this.Map.setPOIList(this.Map.createPOIObjects(cellList));
        this.Map.generateMap(cellList);
        this.Map.insertGeoType(cellList);
        this.Map.SetTileImages();
        fillMap();
        this.repaint();
    }
    
    /**
     * Function to fill the Map with created Cells
     */
    public void fillMap(){
        this.gridLayout = new GridBagLayout();
        //this.jScrollPaneCellMap.setLayout(this.gridLayout);
        //creating the GridPanel
        
        //Dimension mapComponentSize = this.Map.getSizeDimension();
        //this.LayerView.setSize(mapComponentSize.height*this.Map.getAmountX(), mapComponentSize.width*this.Map.getAmountY());
        //filling the GridPanel with Cells
        this.fillTiles();
        this.fillPOIs();
        Dimension layeredViewDimension = new Dimension(CellView.getSize().width, 
                CellView.getSize().height);
        //POIView.setBounds(0, 0, this.POIView.getWidth(), this.POIView.getHeight());
        //CellView.setBounds(0, 0, this.CellView.getWidth(), this.CellView.getHeight());
        this.LayerView = new JLayeredPane();
        this.LayerView.setVisible(true);
        this.LayerView.setOpaque(true);
        this.LayerView.setFocusable(true);
        this.POIView.setLocation(this.jScrollPaneCellMap.getLocation());
        this.CellView.setLocation(this.jScrollPaneCellMap.getLocation());
        this.LayerView.setPreferredSize(layeredViewDimension);
        this.LayerView.add(CellView, JLayeredPane.DEFAULT_LAYER);
        this.LayerView.add(POIView, JLayeredPane.PALETTE_LAYER);
        this.jScrollPaneCellMap.getViewport().add(this.LayerView);
        //this.jScrollPaneCellMap.revalidate();
    }
    
    private void fillPOIs(){
        
        
        this.POIView  = new JPanel();
        //this.POIView.setLayout(gridLayout);
        this.POIView.setVisible(true);
        this.POIView.setSize(this.Map.getSizeDimension().height, this.Map.getSizeDimension().width);
        this.POIView.setOpaque(false);
        this.POIView.setFocusable(false);
        
//        for(POI[] poiList : this.Map.getPOIList()){
//            for(POI poi : poiList){
//                poi.setSize(50, 50);
//                poi.setPOIImage(50, 50);
//                poi.setClickEvent();
//                poi.setDescription(poi.getText());
//                this.POIView.add(poi);
//            }
//        }
        POI house = new POI("House", 2,2);
        house.setDescription("A little House !");
        house.setSize(50,50);
        house.setPOIImage(50, 50);
        house.setClickEvent();
        this.POIView.add(house);
    }
    
    private void fillTiles(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        this.CellView  = new JPanel();
        this.CellView.setSize(new Dimension(this.Map.getSizeDimension().height * this.Map.getCellDataList().length, 
              this.Map.getSizeDimension().width * this.Map.getCellDataList().length));
//        this.CellView.setPreferredSize(new Dimension(this.Map.getSizeDimension().height * this.Map.getCellDataList().length, 
//                this.Map.getSizeDimension().width * this.Map.getCellDataList().length));
        this.CellView.setLayout(gridLayout);
        this.CellView.setVisible(true);
        for(int i = 0; this.Map.getMapData().getAmountX()> i; i++){
            for(int j = 0; this.Map.getMapData().getAmountY() > j; j++){
                gbc.gridx = j;
                gbc.gridy = i;
                this.CellView.add(this.Map.getMapData().getCellDataList()[i][j], gbc);
                this.Map.getMapData().getCellDataList()[i][j].setPreferredSize( this.Map.getSizeDimension());
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jScrollPaneCellMap = new javax.swing.JScrollPane();
        JTabPaneFunctions = new javax.swing.JTabbedPane();
        jPanelPOI = new javax.swing.JPanel();
        jPanelPrinces = new javax.swing.JPanel();
        loadPrincesBTN = new javax.swing.JButton();
        savePrincesBTN = new javax.swing.JButton();
        viewPrincesjPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Map");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jScrollPaneCellMap.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneCellMap.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneCellMap.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneCellMap.setMaximumSize(new java.awt.Dimension(845, 452));

        JTabPaneFunctions.setBackground(new java.awt.Color(255, 255, 255));

        jPanelPOI.setMaximumSize(new java.awt.Dimension(190, 419));

        javax.swing.GroupLayout jPanelPOILayout = new javax.swing.GroupLayout(jPanelPOI);
        jPanelPOI.setLayout(jPanelPOILayout);
        jPanelPOILayout.setHorizontalGroup(
            jPanelPOILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jPanelPOILayout.setVerticalGroup(
            jPanelPOILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        JTabPaneFunctions.addTab("POIs", jPanelPOI);

        loadPrincesBTN.setText("Laden");
        loadPrincesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPrincesBTNActionPerformed(evt);
            }
        });

        savePrincesBTN.setText("Speichern");
        savePrincesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePrincesBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewPrincesjPanelLayout = new javax.swing.GroupLayout(viewPrincesjPanel);
        viewPrincesjPanel.setLayout(viewPrincesjPanelLayout);
        viewPrincesjPanelLayout.setHorizontalGroup(
            viewPrincesjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewPrincesjPanelLayout.setVerticalGroup(
            viewPrincesjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPrincesLayout = new javax.swing.GroupLayout(jPanelPrinces);
        jPanelPrinces.setLayout(jPanelPrincesLayout);
        jPanelPrincesLayout.setHorizontalGroup(
            jPanelPrincesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(loadPrincesBTN)
                .addGap(30, 30, 30)
                .addComponent(savePrincesBTN)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanelPrincesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPrincesjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPrincesLayout.setVerticalGroup(
            jPanelPrincesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPrincesjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPrincesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadPrincesBTN)
                    .addComponent(savePrincesBTN))
                .addGap(16, 16, 16))
        );

        JTabPaneFunctions.addTab("Princes", jPanelPrinces);

        jMenu1.setText("File");

        jMenuItem1.setText("Load");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneCellMap, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabPaneFunctions, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCellMap, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTabPaneFunctions)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        //this.CellView.setSize(this.getSize().width*3/4, this.getSize().height*3/4);
        //Dimension dm = this.Map.getMapData().getCellDataList().get(0).get(0).getPreferredSize();
        //this.Map.UpdateTileImages(dm);
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void loadPrincesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPrincesBTNActionPerformed
        // TODO add your handling code here:
        List<NPC> npcList = new ArrayList<>();
        Datenbank db = new Datenbank();
        npcList = db.getAllNPCs();
        Label princLbl = new Label(npcList.get(0).getName()); 
        this.viewPrincesjPanel.add(princLbl);
        
    }//GEN-LAST:event_loadPrincesBTNActionPerformed

    private void savePrincesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePrincesBTNActionPerformed
        // TODO add your handling code here:
        Datenbank db = new Datenbank();
        NPC npc = new NPC("Deutschland", "Germany", 100,
                "Mensch", "Kartoffel", "Baecker", "100",
                "Rentenversicherung", 1000, "Humans", "Vaterland",
                100, 100, "Doof", "Olaf Scholz");
        db.insertNPC(npc);
    }//GEN-LAST:event_savePrincesBTNActionPerformed

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
            java.util.logging.Logger.getLogger(CellMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CellMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CellMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CellMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Map().setVisible(true);
            }
        });
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Map().setVisible(true);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabPaneFunctions;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanelPOI;
    private javax.swing.JPanel jPanelPrinces;
    private javax.swing.JScrollPane jScrollPaneCellMap;
    private javax.swing.JButton loadPrincesBTN;
    private javax.swing.JButton savePrincesBTN;
    private javax.swing.JPanel viewPrincesjPanel;
    // End of variables declaration//GEN-END:variables
}
