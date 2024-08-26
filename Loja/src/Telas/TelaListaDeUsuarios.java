package Telas;

import Classes.*;
import Telas.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;


public class TelaListaDeUsuarios extends javax.swing.JFrame {

    private ConexaoBancoDeDados conexaoBanco;

    public TelaListaDeUsuarios() throws SQLException {
        initComponents();
        conexaoBanco = new ConexaoBancoDeDados();

        preencherOsUsuarios();
    }

    private void preencherOsUsuarios() {
        try {
            String queryUsuarios = "SELECT idUsuario, nome, senha, cpf, telefone, cep, estado, cidade, bairro, rua, numero, administrador FROM usuario";
            Statement stmtUsuarios = conexaoBanco.getConnection().createStatement();
            ResultSet rsUsuarios = stmtUsuarios.executeQuery(queryUsuarios);

            DefaultTableModel model = (DefaultTableModel) tabHistorico.getModel();
            model.setRowCount(0);

            while (rsUsuarios.next()) {
                int idUsuario = rsUsuarios.getInt("idUsuario");
                String nome = rsUsuarios.getString("nome");
                String senha = rsUsuarios.getString("senha");
                String cpf = rsUsuarios.getString("cpf");
                String telefone = rsUsuarios.getString("telefone");
                String cep = rsUsuarios.getString("cep");
                String estado = rsUsuarios.getString("estado");
                String cidade = rsUsuarios.getString("cidade");
                String bairro = rsUsuarios.getString("bairro");
                String rua = rsUsuarios.getString("rua");
                String numero = rsUsuarios.getString("numero");
                

                boolean isAdmin = rsUsuarios.getBoolean("administrador");
                String adminStatus = isAdmin ? "Sim" : "Não";

                model.addRow(new Object[]{"Editar", idUsuario, nome, senha, cpf, telefone, cep, estado, cidade, bairro, rua, numero, adminStatus});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher a tabela: " + e.getMessage());
            e.printStackTrace();  
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
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabela de Usuarios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        tabHistorico.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Editar", "Id", "Nome", "Senha", "CPF", "Telefone", "CEP", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Adm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
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
            tabHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabHistorico.getColumnModel().getColumn(1).setPreferredWidth(25);
            tabHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
            tabHistorico.getColumnModel().getColumn(11).setPreferredWidth(30);
            tabHistorico.getColumnModel().getColumn(12).setPreferredWidth(30);
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
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(767, 767, 767))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(BotaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHistoricoMouseClicked
        int coluna = tabHistorico.getColumnModel().getColumnIndexAtX(evt.getX());
        int linha = evt.getY() / tabHistorico.getRowHeight();

        if (linha < tabHistorico.getRowCount() && linha >= 0 && coluna == 0) {
            DefaultTableModel model = (DefaultTableModel) tabHistorico.getModel();

            String cpfUsuarioLista = model.getValueAt(linha, 4).toString();


            TelaEditarUsuario telaEditar;
            try {
                telaEditar = new TelaEditarUsuario(cpfUsuarioLista);
                telaEditar.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
        java.util.logging.Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                new TelaListaDeUsuarios().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaListaDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
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
