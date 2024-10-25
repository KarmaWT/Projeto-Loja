package Telas;

import Classes.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class TelaHistoricoDeCompra extends javax.swing.JFrame {

    private String cpf;
    private ConexaoBancoDeDados conexaoBanco;

    public TelaHistoricoDeCompra(String cpf) throws SQLException {
        initComponents();
        this.cpf = cpf;
        conexaoBanco = new ConexaoBancoDeDados();
        preencherHistorico();
    }

    private TelaHistoricoDeCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void preencherHistorico() {
        try {
            String queryIdUsuario = "SELECT idUsuario, cep, estado, cidade, bairro, rua, numero FROM usuario WHERE cpf = '" + cpf + "'";
            Statement stmtIdUsuario = conexaoBanco.getConnection().createStatement();
            ResultSet rsIdUsuario = stmtIdUsuario.executeQuery(queryIdUsuario);

            if (rsIdUsuario.next()) {
                int idUsuario = rsIdUsuario.getInt("idUsuario");

                String cep = rsIdUsuario.getString("cep");
                String estado = rsIdUsuario.getString("estado");
                String cidade = rsIdUsuario.getString("cidade");
                String bairro = rsIdUsuario.getString("bairro");
                String rua = rsIdUsuario.getString("rua");
                String numero = rsIdUsuario.getString("numero");

                String queryHistorico = "SELECT nomeProduto, descricao, precoUnitario, quantidade, valorTotal, dataHoraCompra " +
                                        "FROM produtoscomprados WHERE idUsuario = " + idUsuario;
                Statement stmtHistorico = conexaoBanco.getConnection().createStatement();
                ResultSet rsHistorico = stmtHistorico.executeQuery(queryHistorico);

                DefaultTableModel model = (DefaultTableModel) tabHistorico.getModel();
                model.setRowCount(0);

                while (rsHistorico.next()) {
                    String nomeProduto = rsHistorico.getString("nomeProduto");
                    String descricao = rsHistorico.getString("descricao");
                    double precoUnitario = rsHistorico.getDouble("precoUnitario");
                    int quantidade = rsHistorico.getInt("quantidade");
                    double valorTotal = rsHistorico.getDouble("valorTotal");
                    Timestamp dataHora = rsHistorico.getTimestamp("dataHoraCompra");

                    model.addRow(new Object[]{"Gerar PDF", nomeProduto, precoUnitario, quantidade, valorTotal, dataHora, descricao});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher a tabela: " + e.getMessage());
        }
    }

    private void gerarPDF(String nomeProduto, String descricao, double precoUnitario, int quantidade, double valorTotal, Timestamp dataHoraCompra, String cep, String estado, String cidade, String bairro, String rua, String numero) {
        Document document = new Document();

        String nomeArquivo = "NotaFiscal" + nomeProduto.replaceAll("\\s+", "") + ".pdf";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));
            document.open();

            Font boldFont = FontFactory.getFont("Times-Roman", 12, Font.BOLD);
            Font normalFont = FontFactory.getFont("Times-Roman", 12);

            document.add(new Paragraph("                                 NOTA FISCAL", boldFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Produto: ", boldFont));
            document.add(new Paragraph(nomeProduto, normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Descrição: ", boldFont));
            document.add(new Paragraph(descricao, normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Preço Unitário: ", boldFont));
            document.add(new Paragraph(String.format("R$ %.2f", precoUnitario), normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Quantidade: ", boldFont));
            document.add(new Paragraph(String.valueOf(quantidade), normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Valor Total: ", boldFont));
            document.add(new Paragraph(String.format("R$ %.2f", valorTotal), normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Data/Hora da Compra: ", boldFont));
            document.add(new Paragraph(dataHoraCompra.toString(), normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Informações de Entrega", boldFont));
            document.add(new Paragraph("CEP: " + cep, normalFont));
            document.add(new Paragraph("Estado: " + estado, normalFont));
            document.add(new Paragraph("Cidade: " + cidade, normalFont));
            document.add(new Paragraph("Bairro: " + bairro, normalFont));
            document.add(new Paragraph("Rua: " + rua + ", Número: " + numero, normalFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("==============================================", normalFont));
            document.add(new Paragraph("               OBRIGADO PELA COMPRA!", boldFont));
            document.add(new Paragraph("==============================================", normalFont));

            document.close();
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso: " + nomeArquivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabHistorico = new javax.swing.JTable();
        BotaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 550));
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Historico de compras");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(219, 219, 219))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tabHistorico.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gerar PDF", "Produto", "Preço Unitario", "Quantidade", "Preço Total", "Data/Hora", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabHistorico);
        if (tabHistorico.getColumnModel().getColumnCount() > 0) {
            tabHistorico.getColumnModel().getColumn(0).setPreferredWidth(75);
            tabHistorico.getColumnModel().getColumn(1).setPreferredWidth(125);
            tabHistorico.getColumnModel().getColumn(2).setPreferredWidth(75);
            tabHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabHistorico.getColumnModel().getColumn(4).setPreferredWidth(75);
            tabHistorico.getColumnModel().getColumn(5).setPreferredWidth(175);
            tabHistorico.getColumnModel().getColumn(6).setPreferredWidth(175);
        }

        BotaoCancelar.setBackground(new java.awt.Color(255, 102, 102));
        BotaoCancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BotaoCancelar.setText("Voltar");
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHistoricoMouseClicked
        int row = tabHistorico.rowAtPoint(evt.getPoint());
        int column = tabHistorico.columnAtPoint(evt.getPoint());

        if (column == 0) {
            String nomeProduto = tabHistorico.getValueAt(row, 1).toString();
            String descricao = tabHistorico.getValueAt(row, 6).toString();
            double precoUnitario = (double) tabHistorico.getValueAt(row, 2);
            int quantidade = (int) tabHistorico.getValueAt(row, 3);
            double valorTotal = (double) tabHistorico.getValueAt(row, 4);
            Timestamp dataHoraCompra = (Timestamp) tabHistorico.getValueAt(row, 5);

            try {
                String queryEndereco = "SELECT cep, estado, cidade, bairro, rua, numero FROM usuario WHERE cpf = '" + cpf + "'";
                Statement stmtEndereco = conexaoBanco.getConnection().createStatement();
                ResultSet rsEndereco = stmtEndereco.executeQuery(queryEndereco);

                if (rsEndereco.next()) {
                    String cep = rsEndereco.getString("cep");
                    String estado = rsEndereco.getString("estado");
                    String cidade = rsEndereco.getString("cidade");
                    String bairro = rsEndereco.getString("bairro");
                    String rua = rsEndereco.getString("rua");
                    String numero = rsEndereco.getString("numero");

                    gerarPDF(nomeProduto, descricao, precoUnitario, quantidade, valorTotal, dataHoraCompra, cep, estado, cidade, bairro, rua, numero);
                } else {
                    JOptionPane.showMessageDialog(this, "Informações de endereço não encontradas.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar informações de endereço: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_tabHistoricoMouseClicked

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed

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
        java.util.logging.Logger.getLogger(TelaHistoricoDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(TelaHistoricoDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(TelaHistoricoDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(TelaHistoricoDeCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new TelaHistoricoDeCompra().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabHistorico;
    // End of variables declaration//GEN-END:variables
}
