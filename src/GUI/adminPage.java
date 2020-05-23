
package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class adminPage extends javax.swing.JFrame {

    
    public adminPage() {
        initComponents();Main.it.play("sound//page flip.wav");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddUser = new javax.swing.JToggleButton();
        Retrieve = new javax.swing.JToggleButton();
        Update = new javax.swing.JToggleButton();
        Revenue = new javax.swing.JToggleButton();
        Tree = new javax.swing.JToggleButton();
        Activities = new javax.swing.JToggleButton();
        Payment = new javax.swing.JToggleButton();
        Delete = new javax.swing.JToggleButton();
        backbutton = new javax.swing.JToggleButton();
        Commission = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        UserRevenue = new javax.swing.JToggleButton();
        Generation1 = new javax.swing.JToggleButton();
        Generation2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        AddUser.setBackground(new java.awt.Color(255, 255, 51));
        AddUser.setText("Create User");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        Retrieve.setBackground(new java.awt.Color(255, 255, 51));
        Retrieve.setText("Retrieve User");
        Retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrieveActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(255, 255, 51));
        Update.setText("Update User");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Revenue.setBackground(new java.awt.Color(255, 255, 51));
        Revenue.setText("Company Revenue");
        Revenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueActionPerformed(evt);
            }
        });

        Tree.setBackground(new java.awt.Color(255, 255, 51));
        Tree.setText("View Users Tree");
        Tree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreeActionPerformed(evt);
            }
        });

        Activities.setBackground(new java.awt.Color(255, 255, 51));
        Activities.setText("View Activities");
        Activities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivitiesActionPerformed(evt);
            }
        });

        Payment.setBackground(new java.awt.Color(255, 255, 51));
        Payment.setText("Change Registration Fee");
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(255, 255, 51));
        Delete.setText("Delete User");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        backbutton.setBackground(new java.awt.Color(255, 255, 0));
        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        Commission.setBackground(new java.awt.Color(255, 255, 51));
        Commission.setText("Change Commission");
        Commission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommissionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Kozuka Mincho Pr6N EL", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("ADMIN PAGES");

        UserRevenue.setBackground(new java.awt.Color(255, 255, 51));
        UserRevenue.setText("User Revenue");
        UserRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRevenueActionPerformed(evt);
            }
        });

        Generation1.setBackground(new java.awt.Color(255, 255, 51));
        Generation1.setText("Encryption/Decryption Name");
        Generation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generation1ActionPerformed(evt);
            }
        });

        Generation2.setBackground(new java.awt.Color(255, 255, 51));
        Generation2.setText("Generation Revenue");
        Generation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generation2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Retrieve, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Generation1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Activities, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Payment, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(Tree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Commission, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(UserRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Generation2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Revenue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Revenue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Retrieve, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Commission, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Tree, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Generation2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generation1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Activities, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(backbutton)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        // TODO add your handling code here:
       CreateUser cu=new CreateUser();
       cu.setVisible(true);
    }//GEN-LAST:event_AddUserActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
        Main.it.play("sound//page flip.wav");dispose();
    }//GEN-LAST:event_backbuttonActionPerformed

    private void RevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueActionPerformed
        // TODO add your handling code here:
        companyRevenue cr=new companyRevenue();
        cr.rev();
    }//GEN-LAST:event_RevenueActionPerformed

    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed
        ChangeFee p=new ChangeFee();
        p.setVisible(true);
    }//GEN-LAST:event_PaymentActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        DeleteUser d = new DeleteUser();
        d.setVisible(true);
    }//GEN-LAST:event_DeleteActionPerformed

    private void RetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrieveActionPerformed
        RetrieveUser u = new RetrieveUser();
        u.setVisible(true);
    }//GEN-LAST:event_RetrieveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        UpdateName u = new UpdateName();
        u.setVisible(true);
    }//GEN-LAST:event_UpdateActionPerformed

    private void ActivitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivitiesActionPerformed
        companyAct ac=new companyAct();
        ac.setVisible(true);
    }//GEN-LAST:event_ActivitiesActionPerformed

    private void TreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreeActionPerformed
        TreeAdmin T = new TreeAdmin();
        T.setVisible(true);
    }//GEN-LAST:event_TreeActionPerformed

    private void CommissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommissionActionPerformed
       Commission c = new Commission();
       c.setVisible(true);
    }//GEN-LAST:event_CommissionActionPerformed

    private void UserRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRevenueActionPerformed
        // TODO add your handling code here:
        UserRevenue ur=new UserRevenue();
        ur.setVisible(true);
    }//GEN-LAST:event_UserRevenueActionPerformed

    private void Generation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generation1ActionPerformed
        // TODO add your handling code here:
        EncDec ed=new EncDec();
        ed.setVisible(true);
    }//GEN-LAST:event_Generation1ActionPerformed

    private void Generation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generation2ActionPerformed
        // TODO add your handling code here:
        GenerationR g = new GenerationR();
        g.setVisible(true);
    }//GEN-LAST:event_Generation2ActionPerformed

    
//    public static void main(String[]args) {
//       
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new adminPage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Activities;
    private javax.swing.JToggleButton AddUser;
    private javax.swing.JToggleButton Commission;
    private javax.swing.JToggleButton Delete;
    private javax.swing.JToggleButton Generation1;
    private javax.swing.JToggleButton Generation2;
    private javax.swing.JToggleButton Payment;
    private javax.swing.JToggleButton Retrieve;
    private javax.swing.JToggleButton Revenue;
    private javax.swing.JToggleButton Tree;
    private javax.swing.JToggleButton Update;
    private javax.swing.JToggleButton UserRevenue;
    private javax.swing.JToggleButton backbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
