package Telas;

import Classes.*;
import Telas.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipalAdm extends javax.swing.JFrame {

    private ConexaoBancoDeDados conexaoBanco;
    private String cpf;
    private String senha;
    private TelaPrincipalAdm telaPrincipal;

    public TelaPrincipalAdm(String cpf, String senha) throws SQLException {
        initComponents();
        this.cpf = cpf;
        this.senha = senha;
        conexaoBanco = new ConexaoBancoDeDados();
        this.telaPrincipal = telaPrincipal;

        carregarProdutos();
    }

    private TelaPrincipalAdm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void carregarProdutos() throws SQLException {
        Connection conexao = conexaoBanco.getConnection();
        try {
            Statement statement = conexao.createStatement();

            ResultSet resultado = statement.executeQuery("SELECT * FROM banco.produto WHERE quantidade > 0;");

            DefaultTableModel modelo = (DefaultTableModel) tabProdutos.getModel();

            while (resultado.next()) {
                int id = resultado.getInt("idProduto");
                String nomeProduto = resultado.getString("nomeProduto");
                double preco = resultado.getDouble("preco");
                int quantidade = resultado.getInt("quantidade");
                String descricao = resultado.getString("descricao");

                modelo.addRow(new Object[]{"Comprar", nomeProduto, preco, quantidade, descricao});
            }
            resultado.close();
            statement.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void atualizarProdutos() throws SQLException {
        Connection conexao = conexaoBanco.getConnection();
        Statement statement = conexao.createStatement();

        ResultSet resultado = statement.executeQuery("SELECT * FROM banco.produto WHERE quantidade > 0;");

        DefaultTableModel modelo = (DefaultTableModel) tabProdutos.getModel();
        modelo.setRowCount(0); 

        while (resultado.next()) {
            int id = resultado.getInt("idProduto");
            String nomeProduto = resultado.getString("nomeProduto");
            double preco = resultado.getDouble("preco");
            int quantidade = resultado.getInt("quantidade");
            String descricao = resultado.getString("descricao");

            modelo.addRow(new Object[]{"Comprar", nomeProduto, preco, quantidade, descricao});
        }
        resultado.close();
        statement.close();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pesquisa = new javax.swing.JTextField();
        TextoLogin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProdutos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        pesquisa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });
        pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisaKeyReleased(evt);
            }
        });

        TextoLogin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TextoLogin.setForeground(new java.awt.Color(255, 255, 255));
        TextoLogin.setText("Pesquisa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TextoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoLogin))
                .addGap(28, 28, 28))
        );

        tabProdutos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comprar", "Produto", "Preço(R$)", "Quantidade", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabProdutos);
        if (tabProdutos.getColumnModel().getColumnCount() > 0) {
            tabProdutos.getColumnModel().getColumn(0).setResizable(false);
            tabProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(275);
            tabProdutos.getColumnModel().getColumn(2).setResizable(false);
            tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(75);
            tabProdutos.getColumnModel().getColumn(3).setResizable(false);
            tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(375);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenu4.setText("Perfil");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu4KeyPressed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Perfil do usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Cadastrar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Cadastrar Produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //VAMOOOOOOOO
        if (cpf == null || senha == null) {
            JOptionPane.showMessageDialog(this, "CPF ou senha não fornecidos.");
            return;
        }
        TelaPerfil telaPerfil;
        try {
            telaPerfil = new TelaPerfil(cpf, senha);
            telaPerfil.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed

    }//GEN-LAST:event_jMenu4KeyPressed

    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed

    }//GEN-LAST:event_pesquisaActionPerformed

    private void pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaKeyReleased
             String digitei = pesquisa.getText();
        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conexao = conexaoBanco.getConnection();
            stmt = conexao.createStatement();
            
            String consultaBanco = "SELECT * FROM banco.produto WHERE nomeProduto LIKE '%" + digitei + "%' AND quantidade > 0;";
            rs = stmt.executeQuery(consultaBanco);

            DefaultTableModel modelo = (DefaultTableModel) tabProdutos.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("idProduto");
                String nomeProduto = rs.getString("nomeProduto");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                String descricao = rs.getString("descricao");

                modelo.addRow(new Object[]{"Comprar", nomeProduto, preco, quantidade, descricao});
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }//GEN-LAST:event_pesquisaKeyReleased

    private void tabProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutosMouseClicked
        int coluna = tabProdutos.getColumnModel().getColumnIndexAtX(evt.getX());
        int linha = evt.getY() / tabProdutos.getRowHeight();

        if (coluna == 0 && linha < tabProdutos.getRowCount()) {
            String nomeProduto = tabProdutos.getValueAt(linha, 1).toString();
            double preco = (double) tabProdutos.getValueAt(linha, 2);
            int quantidade = (int) tabProdutos.getValueAt(linha, 3);
            String descricao = tabProdutos.getValueAt(linha, 4).toString();

            TelaCompraAdm telaCompraAdm = null;
            try {

                telaCompraAdm = new TelaCompraAdm(this, cpf);
                telaCompraAdm.preencherDadosProduto(nomeProduto, preco, descricao, quantidade);
                telaCompraAdm.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipalAdm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tabProdutosMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaCadastroProduto telaCadastroProduto;
        try {
            telaCadastroProduto = new TelaCadastroProduto(this, cpf);
            telaCadastroProduto.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipalAdm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de cadastro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextoLogin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JTable tabProdutos;
    // End of variables declaration//GEN-END:variables
}
