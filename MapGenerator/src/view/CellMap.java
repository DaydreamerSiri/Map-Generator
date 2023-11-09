/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.MapGrid;
import controller.POI;
import controller.TilePlace;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.*;
import model.Cell;
/**
 * The generated Map as View
 * @author Sehri Singh
 */
public class CellMap extends javax.swing.JFrame {
    private MapGrid Map;
    private GridLayout gridView;
    private TilePlace tileplacer;
    private JLayeredPane LayerView;
    private JPanel CellView;
    private JPanel POIView;
    /**
     * Creates new form GeneratorPicker
     */
    public CellMap(int sizeX, int sizeY) {
        this.Map = new MapGrid(sizeX, sizeY);
        this.Map.generateMap();
        System.out.println("x: "+sizeX+" y: "+sizeY);
        this.tileplacer = new TilePlace();
        this.tileplacer.placeTiles(Map, sizeX, sizeY);
        this.Map.SetTileImages();
        this.fillMap();
        initComponents();
    }
    
    /**
     * Function to fill the Map with created Cells
     */
    public void fillMap(){
        this.gridView = new GridLayout(this.Map.getSizeX(), this.Map.getSizeY());
        //creating the GridPanel
        this.LayerView = new JLayeredPane();
        this.LayerView.setVisible(true);
        this.LayerView.setSize(this.Map.xCellSize+300, this.Map.yCellSize+300);
        //filling the GridPanel with Cells
        this.fillTiles();
        this.fillPOIs();
        this.LayerView.add(CellView, JLayeredPane.DEFAULT_LAYER);
        this.LayerView.add(POIView, JLayeredPane.DRAG_LAYER);
        this.add(this.LayerView);
    }
    
    private void fillPOIs(){
        this.POIView  = new JPanel();
        //this.POIView.setLayout(gridView);
        this.POIView.setVisible(true);
        this.POIView.setSize(this.Map.xCellSize+100, this.Map.yCellSize+100);
        this.POIView.setOpaque(false);
        
        POI house = new POI("House", 2,2);
        house.setSize(50,50);
        house.setPOIImage(50, 50);
        this.POIView.add(house);
    }
    
    private void fillTiles(){
        
        this.CellView  = new JPanel();
        this.CellView.setLayout(gridView);
        this.CellView.setVisible(true);
        this.CellView.setSize(this.Map.xCellSize+100, this.Map.yCellSize+100);
        this.CellView.setFocusable(true);
        this.CellView.requestFocusInWindow();
        this.CellView.setBorder(LineBorder.createBlackLineBorder());
        
        for(int i = 0; this.Map.getMapData().getSizeX()> i; i++){
            for(int j = 0; this.Map.getMapData().getSizeY() > j; j++){
                System.out.println(this.Map.getMapData().getCellDataList().get(i).get(j).getTileInformation()[0]);
                this.Map.getMapData().getCellDataList().get(i).get(j).setBackground(
                        this.Map.getMapData().getCellDataList().get(i).get(j).getTileColor(this.Map.getMapData().getCellDataList().get(i).get(j).getTileInformation()[0].toString()));
                //Box box = Box.createVerticalBox();
                //box.setPreferredSize(this.Map.getSizeDimension());
                //box.add(this.Map.getMapData().getCellDataList().get(i).get(j));
                this.CellView.add(this.Map.getMapData().getCellDataList().get(i).get(j));
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

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Map");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        System.out.println(this.getSize());
        System.out.println(this.Map.getMapData().getCellDataList().get(0).get(0).getSize());
        this.CellView.setSize(this.getSize().width*3/4, this.getSize().height*3/4);
        this.Map.UpdateTileImages(this.getSize());
    }//GEN-LAST:event_formComponentResized

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
