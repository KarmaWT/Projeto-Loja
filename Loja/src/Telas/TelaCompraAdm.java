package Telas;

import Classes.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TelaCompraAdm extends javax.swing.JFrame {

    private ConexaoBancoDeDados conexaoBanco;
    private ButtonGroup buttonGroupPagamento;
    private double precoUnitario;
    private String cpfUsuario;
    private TelaPrincipalAdm telaPrincipalAdm;

    public TelaCompraAdm(TelaPrincipalAdm telaPrincipalAdm, String cpf) throws SQLException {
        initComponents();

        this.telaPrincipalAdm = telaPrincipalAdm;

        conexaoBanco = new ConexaoBancoDeDados();
        this.cpfUsuario = cpf;

        configurarTextArea();

        buttonGroupPagamento = new ButtonGroup();
        buttonGroupPagamento.add(pagCredito);
        buttonGroupPagamento.add(pagDebito);
        buttonGroupPagamento.add(pagPix);

        txtQuantidade.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                atualizarPreco();
            }
        });
    }

    private TelaCompraAdm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void configurarTextArea() {
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
    }

    public void preencherDadosProduto(String nomeProduto, double preco, String descricao, int quantidade) {
        txtProduto.setText(nomeProduto);
        precoUnitario = preco;
        txtPreco.setText(String.valueOf(preco));
        txtDescricao.setText(descricao);
        txtQuantidade.setModel(new SpinnerNumberModel(1, 1, quantidade, 1));
    }

    private void realizarCompra(String nomeProduto, int quantidade) {

        String consultaProduto = "SELECT idProduto, quantidade FROM banco.produto WHERE nomeProduto = ?";

        try (Connection connection = conexaoBanco.getConnection(); PreparedStatement stmt = connection.prepareStatement(consultaProduto)) {

            stmt.setString(1, nomeProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                int quantidadeDisponivel = rs.getInt("quantidade");
                
                if (quantidadeDisponivel >= quantidade) {

                    String inserirCompra = "INSERT INTO ProdutosComprados (idProduto, quantidade, cpfCliente, dataCompra) VALUES (?, ?, ?, NOW())";
                    try (PreparedStatement stmtCompra = connection.prepareStatement(inserirCompra)) {
                        stmtCompra.setInt(1, idProduto);
                        stmtCompra.setInt(2, quantidade);
                        stmtCompra.setString(3, cpfUsuario);
                        stmtCompra.executeUpdate();
                    }

                    String atualizarProduto = "UPDATE banco.produto SET quantidade = quantidade - ? WHERE idProduto = ?";
                    try (PreparedStatement stmtAtualizar = connection.prepareStatement(atualizarProduto)) {
                        stmtAtualizar.setInt(1, quantidade);
                        stmtAtualizar.setInt(2, idProduto);
                        stmtAtualizar.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(this, "Compra realizada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Quantidade disponível insuficiente. Disponível: " + quantidadeDisponivel);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar a compra: " + ex.getMessage());
        }
    }

    private void atualizarPreco() {
        int quantidade = (Integer) txtQuantidade.getValue();
        double precoTotal = precoUnitario * quantidade;
        txtPreco.setText(String.valueOf(precoTotal));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TextoLogin1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        BotaoCancelar = new javax.swing.JButton();
        BotaoComprar = new javax.swing.JButton();
        pagCredito = new javax.swing.JRadioButton();
        pagDebito = new javax.swing.JRadioButton();
        pagPix = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Senha:");

        txtSenha.setEditable(false);
        txtSenha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Nome:");

        txtNome.setEditable(false);
        txtNome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("CPF:");

        txtCPF.setEditable(false);
        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        TextoLogin1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TextoLogin1.setForeground(new java.awt.Color(255, 255, 255));
        TextoLogin1.setText("Compra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(TextoLogin1)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TextoLogin1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Preço(R$):");

        txtPreco.setEditable(false);
        txtPreco.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Produto:");

        txtProduto.setEditable(false);
        txtProduto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantidadeStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Descrição:");

        txtDescricao.setEditable(false);
        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        BotaoCancelar.setBackground(new java.awt.Color(255, 102, 102));
        BotaoCancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        BotaoComprar.setBackground(new java.awt.Color(153, 153, 153));
        BotaoComprar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotaoComprar.setText("Comprar");
        BotaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoComprarActionPerformed(evt);
            }
        });

        pagCredito.setText("Crédito");
        pagCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagCreditoActionPerformed(evt);
            }
        });

        pagDebito.setText("Débito");

        pagPix.setText("Pix");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Pagamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BotaoCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoComprar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pagCredito)
                                .addGap(18, 18, 18)
                                .addComponent(pagDebito)
                                .addGap(18, 18, 18)
                                .addComponent(pagPix))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtProduto)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagDebito)
                    .addComponent(pagCredito)
                    .addComponent(pagPix)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoComprarActionPerformed
        if (buttonGroupPagamento.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma forma de pagamento.");
            return;
        }

        String nomeProduto = txtProduto.getText();
        int quantidade = (Integer) txtQuantidade.getValue();
        realizarCompra(nomeProduto, quantidade);

        try {

            telaPrincipalAdm.atualizarProdutos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar os produtos: " + ex.getMessage());
        }
        dispose();
    }//GEN-LAST:event_BotaoComprarActionPerformed

    private void pagCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagCreditoActionPerformed

    private void txtQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantidadeStateChanged

    }//GEN-LAST:event_txtQuantidadeStateChanged

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
            java.util.logging.Logger.getLogger(TelaCompraAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCompraAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCompraAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCompraAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCompraAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoComprar;
    private javax.swing.JLabel TextoLogin1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pagCredito;
    private javax.swing.JRadioButton pagDebito;
    private javax.swing.JRadioButton pagPix;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JSpinner txtQuantidade;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
