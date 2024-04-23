
import Classes.Usuario;
import java.sql.*;

public class TelaLogin extends javax.swing.JFrame {


    public TelaLogin() {
        initComponents();
  Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "1234");
            ResultSet rsUsuario = conexao.createStatement().executeQuery("SELECT * FROM USUARIO");
            while (rsUsuario.next()){
                System.out.println("Nome: " + rsUsuario.getNString("nome"));
                System.out.println("Senha: " + rsUsuario.getNString("senha"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }        

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nomeUSERtxt = new javax.swing.JFormattedTextField();
        loginTxt = new javax.swing.JButton();
        sairtxt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SENHAtxt = new javax.swing.JPasswordField();

        jLabel2.setText("jLabel2");

        jLabel4.setText("jLabel4");

        jFormattedTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome de usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 12))); // NOI18N

        jButton1.setBackground(new java.awt.Color(105, 245, 105));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nomeUSERtxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome de usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 12))); // NOI18N
        nomeUSERtxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeUSERtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUSERtxtActionPerformed(evt);
            }
        });
        nomeUSERtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeUSERtxtKeyTyped(evt);
            }
        });

        loginTxt.setBackground(new java.awt.Color(105, 245, 105));
        loginTxt.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        loginTxt.setText("Login");
        loginTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTxtActionPerformed(evt);
            }
        });

        sairtxt.setBackground(new java.awt.Color(153, 153, 153));
        sairtxt.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        sairtxt.setText("Sair");
        sairtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairtxtActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        SENHAtxt.setToolTipText("Senha");
        SENHAtxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SENHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sairtxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(loginTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeUSERtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(SENHAtxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(nomeUSERtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SENHAtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sairtxt)
                    .addComponent(loginTxt))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeUSERtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUSERtxtActionPerformed
         //String Usuario = nomeUSERtxt.getText();
    }//GEN-LAST:event_nomeUSERtxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTxtActionPerformed
        String nome_usuario, senha_usuario;
         nome_usuario=nomeUSERtxt.getText();
            
    senha_usuario = new String(SENHAtxt.getPassword());
    
    Usuario ObjUsuario = new Usuario();
    ObjUsuario.setNome(nome_usuario);
    ObjUsuario.setSenha(senha_usuario);
    
    
    
    }//GEN-LAST:event_loginTxtActionPerformed

    private void sairtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairtxtActionPerformed
    //String cadastrar = cadastrotxt.getText();
    }//GEN-LAST:event_sairtxtActionPerformed

    private void nomeUSERtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUSERtxtKeyTyped
        //String Usuario = nomeUSERtxt.getText();
        //System.out.println(Usuario+ "usuario digitado: ");
    }//GEN-LAST:event_nomeUSERtxtKeyTyped

  
    public static void main(String args[]) {
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField SENHAtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginTxt;
    private javax.swing.JFormattedTextField nomeUSERtxt;
    private javax.swing.JButton sairtxt;
    // End of variables declaration//GEN-END:variables
}
