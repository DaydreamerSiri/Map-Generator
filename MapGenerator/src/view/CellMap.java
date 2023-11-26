/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.MapGrid;
import controller.POI;
import controller.TilePlace;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
/**
 * The generated Map as View
 * @author Sehri Singh
 */
public class CellMap extends javax.swing.JFrame {
    private MapGrid Map;
    private GridBagLayout gridLayout;
    private TilePlace tileplacer;
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
        this.Map = new MapGrid(AmountX, AmountY);
        this.Map.generateMap();
        this.tileplacer = new TilePlace();
        this.Map.insertGeoType(this.tileplacer.placeTile(AmountX, AmountY));
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
        //this.LayerView = new JLayeredPane();
        //this.LayerView.setVisible(true);
        //this.LayerView.setOpaque(false);
        //this.LayerView.setFocusable(true);
        //this.LayerView.setSize(this.Map.LayerViewSize, this.Map.LayerViewSize);
        //filling the GridPanel with Cells
        this.fillTiles();
        //this.fillPOIs();
        //this.LayerView.add(CellView, JLayeredPane.DEFAULT_LAYER, 0);
        //this.LayerView.add(POIView, JLayeredPane.PALETTE_LAYER,0);
        this.jScrollPaneCellMap.getViewport().add(this.CellView);
        System.out.println(this.jScrollPaneCellMap.getViewport().getSize());
        this.jScrollPaneCellMap.revalidate();
    }
    
    private void fillPOIs(){
        
        
        this.POIView  = new JPanel();
        //this.POIView.setLayout(gridLayout);
        this.POIView.setVisible(true);
        this.POIView.setSize(this.Map.xCellSize, this.Map.yCellSize);
        this.POIView.setOpaque(false);
        this.POIView.setFocusable(false);
        
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
        this.CellView.setLayout(gridLayout);
        this.CellView.setVisible(true);
        for(int i = 0; this.Map.getMapData().getAmountX()> i; i++){
            for(int j = 0; this.Map.getMapData().getAmountY() > j; j++){
                gbc.gridx = j;
                gbc.gridy = i;
                this.CellView.add(this.Map.getMapData().getCellDataList().get(i).get(j), gbc);
                this.Map.getMapData().getCellDataList().get(i).get(j).setPreferredSize( this.Map.getSizeDimension());
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
        jPanel1 = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        JTabPaneFunctions.addTab("Princes", jPanel1);

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPOI;
    private javax.swing.JScrollPane jScrollPaneCellMap;
    // End of variables declaration//GEN-END:variables
}
