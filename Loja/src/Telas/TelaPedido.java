/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import java.awt.Dimension;


public class TelaPedido extends javax.swing.JFrame {

    /**
     * Creates new form TelaPedido
     */
    public TelaPedido() {
        initComponents();
        
        this.setSize(new Dimension(800,600));
        this.setTitle("TELA PEDIDO");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PapelFundo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1_Cliente = new javax.swing.JComboBox<>();
        jComboBox1_Produto = new javax.swing.JComboBox<>();
        txt_buscarCliente = new javax.swing.JTextField();
        txt_Quantidade = new javax.swing.JTextField();
        jButton_Adicionar_Produto = new javax.swing.JButton();
        jButton_Buscar_Cliente1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_Produtos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Troco = new javax.swing.JTextField();
        txt_subtotal = new javax.swing.JTextField();
        txt_desconto = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txtCalcular = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_dinheiro1 = new javax.swing.JTextField();
        txtRegistrarvenda = new javax.swing.JButton();

        PapelFundo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FATURAMENTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CLIENTE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PRODUTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("QUANTIDADE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jComboBox1_Cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR PRODUTO:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 170, -1));

        jComboBox1_Produto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1_Produto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE CLIENTE:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, -1));

        txt_buscarCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_buscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 60, -1));

        txt_Quantidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_Quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 150, -1));

        jButton_Adicionar_Produto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Adicionar_Produto.setText("ADICIONAR PRODUTO");
        jButton_Adicionar_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Adicionar_ProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Adicionar_Produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 180, -1));

        jButton_Buscar_Cliente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Buscar_Cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscar_1.png"))); // NOI18N
        jButton_Buscar_Cliente1.setText("BUSCAR");
        jButton_Buscar_Cliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Buscar_Cliente1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Buscar_Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 150, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1_Produtos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 210));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("SUBTOTAL:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TOTAL A PAGAR :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("DESCONTO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("TROCO:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, -1));

        txt_Troco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_Troco.setEnabled(false);
        jPanel2.add(txt_Troco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 120, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_subtotal.setEnabled(false);
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, -1));

        txt_desconto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_desconto.setEnabled(false);
        jPanel2.add(txt_desconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, -1));

        txtCalcular.setBackground(new java.awt.Color(51, 255, 255));
        txtCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCalcular.setText("CALCULAR ");
        txtCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalcularActionPerformed(evt);
            }
        });
        jPanel2.add(txtCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 130, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DINHEIRO:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, -1));

        txt_dinheiro1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txt_dinheiro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 380, 210));

        txtRegistrarvenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRegistrarvenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/vendas_1.png"))); // NOI18N
        txtRegistrarvenda.setText("REGISTRAR VENDA");
        getContentPane().add(txtRegistrarvenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 220, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Adicionar_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Adicionar_ProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Adicionar_ProdutoActionPerformed

    private void jButton_Buscar_Cliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Buscar_Cliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Buscar_Cliente1ActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subtotalActionPerformed

    private void txtCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalcularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalcularActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PapelFundo;
    private javax.swing.JButton jButton_Adicionar_Produto;
    private javax.swing.JButton jButton_Buscar_Cliente1;
    private javax.swing.JComboBox<String> jComboBox1_Cliente;
    private javax.swing.JComboBox<String> jComboBox1_Produto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1_Produtos;
    private javax.swing.JButton txtCalcular;
    private javax.swing.JButton txtRegistrarvenda;
    private javax.swing.JTextField txt_Quantidade;
    private javax.swing.JTextField txt_Troco;
    private javax.swing.JTextField txt_buscarCliente;
    private javax.swing.JTextField txt_desconto;
    private javax.swing.JTextField txt_dinheiro1;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables
}
