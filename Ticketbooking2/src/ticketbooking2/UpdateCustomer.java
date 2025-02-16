/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ticketbooking2;

import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Makrani
 */
public class UpdateCustomer extends javax.swing.JFrame {

    /**
     * Creates new form UpdateCustomer
     */
    public UpdateCustomer() {
        initComponents();
    }
    //database connection
    connection con;
    preparedStatement pst;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtpin = new javax.swing.JTextField();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddr = new javax.swing.JTextArea();
        txtcont = new javax.swing.JTextField();
        txtsta = new javax.swing.JComboBox<>();
        image = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtcoun = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("Update Customer Information");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("X");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 40, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Customer Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("First Name :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 57, -1, -1));

        jLabel3.setText("Last Name :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 110, -1, -1));

        jLabel4.setText("Gender :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 164, -1, -1));

        jLabel5.setText("Pincode :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel9.setText("Address :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jLabel10.setText("Contact");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel11.setText("State :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        jLabel12.setText("Images :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));
        jPanel3.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 250, 30));
        jPanel3.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 102, 250, 30));
        jPanel3.add(txtpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 232, 250, 30));

        r1.setText("Male");
        jPanel3.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        r2.setText("Female");
        jPanel3.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        txtaddr.setColumns(20);
        txtaddr.setRows(5);
        jScrollPane1.setViewportView(txtaddr);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 250, 100));

        txtcont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontActionPerformed(evt);
            }
        });
        jPanel3.add(txtcont, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 250, 30));

        txtsta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal" }));
        txtsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstaActionPerformed(evt);
            }
        });
        jPanel3.add(txtsta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 250, 20));

        image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 90, 90));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jButton3.setText("Reset");
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jButton4.setText("Cancel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 250, 10));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 10, 290));

        jLabel16.setText("Country :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        txtcoun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "India", "Nepal" }));
        txtcoun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcounActionPerformed(evt);
            }
        });
        jPanel3.add(txtcoun, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 232, 250, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 750, 430));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Customer ID :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, -1));
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 250, 30));

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(773, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontActionPerformed

    private void txtstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // search ID;

        string idd = textid.hetText ();
        
        
        try{
            
            Class.forName("java.sql.Drive");

            con = (connection) driverManager.getConnection ("jdbc:mysql//localhost:3306/airline","root","");
            
            pst = con.prepareStatment("select * from newcust where regid=?");
            pst.setString(1, idd);
            
            ResultSet qur = pst.executeQuery();
            if(qur.next()==true)
            {
                String name = qur.getString("fname");
             
                txtname.setText(name);
                
            }
            
        }catch (Exception ex)
        {
            
            System.err.println(ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.setVisible (false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        this.setVisible (false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void txtcounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcounActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcounActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JTextArea txtaddr;
    private javax.swing.JTextField txtcont;
    private javax.swing.JComboBox<String> txtcoun;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpin;
    private javax.swing.JComboBox<String> txtsta;
    // End of variables declaration//GEN-END:variables

    private static class string {

        public string() {
        }
    }

    private static class textid {

        private static string hetText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public textid() {
        }
    }

    private static class connection {

        public connection() {
        }

        private preparedStatement prepareStatment(String select__from_newcust) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class preparedStatement {

        public preparedStatement() {
        }

        private void setString(int i, string idd) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void executeQuery() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
