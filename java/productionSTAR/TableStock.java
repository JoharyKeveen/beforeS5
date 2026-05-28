/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;

import connection.Connex;
import java.sql.Connection;
import java.util.Vector;
import table.Produit;
import table.StockProd;

/**
 *
 * @author Achyl
 */
public class TableStock extends javax.swing.JFrame {

    public TableStock(String[][] args,String totalStock,String cump) {
        initComponents(args,totalStock,cump);
    }
    private void initComponents(String[][] args,String totalStock,String cump) {
        String[] entete={"Id Produit","Nom","Quantite","Prix Unitaire","Prix Total"};
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(args,entete);
        jLabel2 = new javax.swing.JLabel();
        valeurCUMP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valeurStock = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        title.setForeground(new java.awt.Color(200, 16, 16));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Serveur Star");

        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("DejaVu Serif Condensed", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(200, 16, 16));
        jLabel2.setText("Coût unitaire moyen pondéré :");

        valeurCUMP.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        valeurCUMP.setText(cump);

        jLabel5.setFont(new java.awt.Font("DejaVu Serif Condensed", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(200, 16, 16));
        jLabel5.setText("Valeur total du stock :");

        valeurStock.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        valeurStock.setText(totalStock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(valeurCUMP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(valeurStock, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valeurStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valeurCUMP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel valeurCUMP;
    private javax.swing.JLabel valeurStock;
    // End of variables declaration//GEN-END:variables

//    public static void main(String args[]) {
//        Connex co=new Connex();
//        Connection lo=co.log();
//        try{
//            Vector<StockProd> listProd=new StockProd().get_Tab(new StockProd().select(lo));
//            String[][] list=new String[listProd.size()][5];
//            Double totalStock=0.0;
//            int quantTotal=0;
//            for(int i=0;i<list.length;i++)
//            {
//                list[i][0]=listProd.get(i).getIdProduit();
//                list[i][1]=listProd.get(i).getNom();
//                list[i][2]=Integer.toString(listProd.get(i).getQuantite());
//                list[i][3]=Double.toString(listProd.get(i).getPrixUnitaire());
//                list[i][4]=Double.toString(listProd.get(i).getPrixTotal());
//                totalStock+=listProd.get(i).getPrixTotal();
//                quantTotal+=listProd.get(i).getQuantite();
//            }
//            double cump=totalStock/quantTotal;
//            new TableStock(list,totalStock.toString(),Double.toString(Math.round(cump*100.0)/100.0)).setVisible(true);
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
}
