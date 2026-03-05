package com.gui.Leave;

import com.gui.Home.User;
import com.motorph.model.LeaveRequest;
import com.motorph.model.LeaveStatus;
import com.motorph.service.LeaveService;
import com.motorph.service.ServiceLocator;
import com.toedter.calendar.JDateChooser;

import com.motorph.util.DateUtil;

import java.time.LocalDate;
import java.util.Date;
import javax.swing.*;

/**
 * NetBeans GUI Builder form for submitting a leave request.
 */
public class LeaveRequestForm extends javax.swing.JFrame {

    private final User currentUser;
    private final LeaveService leaveService;

    /**
     * Constructor used in production — receives the logged-in user.
     */
    public LeaveRequestForm(User currentUser) {
        this.currentUser = currentUser;
        this.leaveService = ServiceLocator.getLeaveService();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        lblEmployee.setText(currentUser.getuFirstName() + " " + currentUser.getuLastName()
                + " (" + currentUser.getuEmpId() + ")");
    }

    /**
     * Default no-arg constructor for GUI Builder compatibility.
     */
    public LeaveRequestForm() {
        this.currentUser = null;
        this.leaveService = ServiceLocator.getLeaveService();
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelEmployee = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        jLabelFrom = new javax.swing.JLabel();
        dateFrom = new com.toedter.calendar.JDateChooser();
        jLabelTo = new javax.swing.JLabel();
        dateTo = new com.toedter.calendar.JDateChooser();
        jLabelReason = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leave Request");

        jPanelMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        jLabelTitle.setText("Leave Request Form");

        jLabelEmployee.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabelEmployee.setText("Employee:");

        lblEmployee.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblEmployee.setText("-");

        jLabelFrom.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabelFrom.setText("Date From:");

        jLabelTo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabelTo.setText("Date To:");

        jLabelReason.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jLabelReason.setText("Reason:");

        txtReason.setColumns(20);
        txtReason.setRows(5);
        txtReason.setLineWrap(true);
        txtReason.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtReason);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelEmployee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelReason)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmployee)
                    .addComponent(lblEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFrom)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTo)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelReason)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (currentUser == null) {
            JOptionPane.showMessageDialog(this, "No user logged in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date fromDate = dateFrom.getDate();
        Date toDate = dateTo.getDate();
        String reason = txtReason.getText().trim();

        if (fromDate == null || toDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both Date From and Date To.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (reason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a reason for the leave.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LocalDate localFrom = fromDate.toInstant().atZone(DateUtil.MANILA_ZONE).toLocalDate();
        LocalDate localTo = toDate.toInstant().atZone(DateUtil.MANILA_ZONE).toLocalDate();

        if (localTo.isBefore(localFrom)) {
            JOptionPane.showMessageDialog(this, "Date To cannot be before Date From.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LeaveRequest req = new LeaveRequest(0,
                currentUser.getuEmpId(),
                currentUser.getuFirstName() + " " + currentUser.getuLastName(),
                localFrom, localTo, reason);
        leaveService.submitLeave(req);

        JOptionPane.showMessageDialog(this, "Leave request submitted successfully.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JLabel jLabelEmployee;
    private javax.swing.JLabel jLabelFrom;
    private javax.swing.JLabel jLabelReason;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTo;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JTextArea txtReason;
    // End of variables declaration//GEN-END:variables
}
