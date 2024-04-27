package Telas;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LOGIN extends javax.swing.JFrame {

     private Connection conexao;
    public LOGIN() throws ClassNotFoundException, SQLException{
        initComponents();
        
        this.conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "1234");
            ResultSet rsUsuario = conexao.createStatement().executeQuery("SELECT * FROM USUARIO");
            while (rsUsuario.next()){
                System.out.println("Nome: " + rsUsuario.getNString("nome"));
                System.out.println("Senha: " + rsUsuario.getNString("senha"));
            }
        } catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao acessar o banco T-T");
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "");
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        senhatxt = new javax.swing.JPasswordField();
        usuariotxt = new javax.swing.JTextField();
        Logintxt = new javax.swing.JButton();
        Sairtxt = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        senhatxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        senhatxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SENHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Yu Gothic UI Semibold", 1, 14))); // NOI18N
        senhatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhatxtActionPerformed(evt);
            }
        });

        usuariotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuariotxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USUARIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Yu Gothic UI Semibold", 1, 14))); // NOI18N
        usuariotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariotxtActionPerformed(evt);
            }
        });

        Logintxt.setBackground(new java.awt.Color(204, 204, 204));
        Logintxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logintxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Login_48x48.png"))); // NOI18N
        Logintxt.setText("LOGIN");
        Logintxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logintxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogintxtActionPerformed(evt);
            }
        });

        Sairtxt.setBackground(new java.awt.Color(204, 204, 204));
        Sairtxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Sairtxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        Sairtxt.setText("SAIR");
        Sairtxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Sairtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(senhatxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(Sairtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logintxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(usuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(usuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(senhatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sairtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logintxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogintxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogintxtActionPerformed
       
String usuario = usuariotxt.getText(); 
    String senha = new String(senhatxt.getPassword());
try {
        // Estabelece a conexão com o banco de dados
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
        
        // Consulta o banco de dados para verificar se o usuário e senha correspondem
        PreparedStatement pst = conexao.prepareStatement("SELECT * FROM USUARIO WHERE nome = ? AND senha = ?");
        pst.setString(1, usuario);
        pst.setString(2, senha);
        ResultSet rs = pst.executeQuery();
        
        // Verifica se a consulta retornou algum resultado
        if (rs.next()) {
            // Se encontrou, exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Login bem sucedido!");
            // Aqui você pode abrir uma nova janela ou realizar qualquer ação desejada após o login
        } else {
            // Se não encontrou, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    } catch (ClassNotFoundException | SQLException ex) {
        // Em caso de exceção, exibe uma mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao realizar login: " + ex.getMessage());
    } finally {
        // Fecha a conexão com o banco de dados
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

         
    }//GEN-LAST:event_LogintxtActionPerformed

    private void SairtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SairtxtActionPerformed

    private void usuariotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariotxtActionPerformed

    private void senhatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhatxtActionPerformed

    
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LOGIN().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logintxt;
    private javax.swing.JButton Sairtxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField senhatxt;
    private javax.swing.JTextField usuariotxt;
    // End of variables declaration//GEN-END:variables
}