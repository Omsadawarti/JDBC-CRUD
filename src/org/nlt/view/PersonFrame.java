package org.nlt.view;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PersonFrame extends javax.swing.JFrame implements ParentInterface {

    private int id;

    public PersonFrame() {
        initComponents();
        setTableData();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel2.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

        jLabel1.setText("ENTER NAME");
        jPanel2.add(jLabel1);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(nameTextField);

        jLabel2.setText("ENTER AGE");
        jPanel2.add(jLabel2);
        jPanel2.add(ageTextField);

        jLabel3.setText("ENTER PHONE");
        jPanel2.add(jLabel3);
        jPanel2.add(phoneTextField);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(submitButton);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateButton);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteButton);

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel5.add(resetButton);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        personTable.setModel(new javax.swing.table.DefaultTableModel(
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
        personTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
        // ignore this block
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        // ignore this block
        resetData();
        setTableData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:

        try 
        
        {
            String n = nameTextField.getText().toUpperCase();
            int a = Integer.parseInt(ageTextField.getText());
            String p = phoneTextField.getText();

            if (n.isEmpty() || p.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Entry! All Dields Are Required!!", "Person CRUD", JOptionPane.ERROR_MESSAGE);
            } else {
                Statement smt = con.createStatement();
                smt.execute("insert into persons (name,age,phone,status) values('" + n + "' , " + a + " , '" + p + "' , 1)");
                smt.close();
                JOptionPane.showMessageDialog(this, "Record Submitted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);

                resetData();
                setTableData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Person CRUDE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (id == 0) {
                JOptionPane.showMessageDialog(this, "Please Select Record to Update", "Person CRUDE", JOptionPane.ERROR_MESSAGE);
            } else {

                String n = nameTextField.getText().toUpperCase();
                int a = Integer.parseInt(ageTextField.getText());
                String p = phoneTextField.getText();

                if (n.isEmpty() || p.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Invalid Entry! All Dields Are Required!!", "Person CRUD", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Statement smt = con.createStatement();
                    smt.execute("update persons set name = '" + n + "' , age = " + a + " , phone = '" + p + "' where id = " + id + "");
                    smt.close();
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                    
                    resetData();
                    setTableData();
                    id = 0 ;
                }
            }
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, e, "Person CRUDE", JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (id == 0) {
                JOptionPane.showMessageDialog(this, "Please Select Record to Delete", "Person CRUDE", JOptionPane.ERROR_MESSAGE);
            } else
            {

                    Statement smt = con.createStatement();
                    smt.execute("update persons set status = 0 where id = "+id+"");
                    smt.close();
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);

                    resetData();
                    setTableData();
                    id = 0;
                }
            }
         
catch (Exception e) 
{
            JOptionPane.showMessageDialog(this, e, "Person CRUDE", JOptionPane.ERROR_MESSAGE);

        }
        setTableData();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void personTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personTableMouseClicked
        // TODO add your handling code here:
        try {
            // will get id for a record
            String obj = personTable.getValueAt(personTable.getSelectedRow(), 0).toString();
            Statement smt = con.createStatement();

            //will get given id record into rs
            ResultSet rs = smt.executeQuery("select * from  persons where status  = 1 and id = '" + obj + "'");

            // if rs is present at least one record so there is no need to implement a loop  ,  just use if conditional statement
            if (rs.next()) {
                id = rs.getInt("id"); 
                nameTextField.setText(rs.getString("name"));
                ageTextField.setText(rs.getInt("age") + "");
                phoneTextField.setText(rs.getString("phone"));
            }
            rs.close();
            smt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Persom CRUDE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_personTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable personTable;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        new PersonFrame().setVisible(true);
    }
    public void setTableData() {
        //shift delete
        try {
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select * from persons where status = 1");
            rs.last();// this will move the cursor at the last row of the table
            int size = rs.getRow(); // this will return lastrow number i.e number or rows i.e size of table
            rs.beforeFirst(); //  this will move the cursoe as it was before(pointing before the first row of the table)
            String[][] data = new String[size][4];
            String[] cols = {"ID", "NAME", "AGE", "PHONE"}; // columns heading
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getInt("id") + "";
                data[i][1] = rs.getString("name"); 
               data[i][2] = rs.getInt("age") + "";
                data[i][3] = rs.getString("phone");
                i++;
            }
            DefaultTableModel model = new DefaultTableModel(data, cols);
            personTable.setModel(model);
            
            rs.close();
            smt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUDE", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void resetData() {
        nameTextField.setText("");
        ageTextField.setText("");
        phoneTextField.setText("");
    }
}
