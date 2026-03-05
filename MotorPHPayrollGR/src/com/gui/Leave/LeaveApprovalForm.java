package com.gui.Leave;

import com.gui.Home.User;
import com.motorph.model.LeaveRequest;
import com.motorph.service.LeaveService;
import com.motorph.service.ServiceLocator;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * NetBeans GUI Builder form for approving or rejecting pending leave requests.
 */
public class LeaveApprovalForm extends javax.swing.JFrame {

    private final User currentUser;
    private final LeaveService leaveService;

    /**
     * Constructor used in production — receives the logged-in user.
     */
    public LeaveApprovalForm(User currentUser) {
        this.currentUser = currentUser;
        this.leaveService = ServiceLocator.getLeaveService();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        loadPendingRequests();
    }

    /**
     * Default no-arg constructor for GUI Builder compatibility.
     */
    public LeaveApprovalForm() {
        this.currentUser = null;
        this.leaveService = ServiceLocator.getLeaveService();
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLeaves = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leave Approval");

        jPanelMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        jLabelTitle.setText("Pending Leave Requests");

        tblLeaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Emp ID", "Name", "From", "To", "Reason", "Status" }
        ) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLeaves);

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(btnApprove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnReject)
                    .addComponent(btnRefresh)
                    .addComponent(btnClose))
                .addContainerGap())
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

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        int selectedRow = tblLeaves.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a leave request to approve.",
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int requestId = (Integer) tblLeaves.getValueAt(selectedRow, 0);
        String approverEmpId = currentUser != null ? currentUser.getuEmpId() : "SYSTEM";
        leaveService.approveLeave(requestId, approverEmpId);
        JOptionPane.showMessageDialog(this, "Leave request approved.",
                "Approved", JOptionPane.INFORMATION_MESSAGE);
        loadPendingRequests();
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        int selectedRow = tblLeaves.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a leave request to reject.",
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int requestId = (Integer) tblLeaves.getValueAt(selectedRow, 0);
        String approverEmpId = currentUser != null ? currentUser.getuEmpId() : "SYSTEM";
        leaveService.rejectLeave(requestId, approverEmpId);
        JOptionPane.showMessageDialog(this, "Leave request rejected.",
                "Rejected", JOptionPane.INFORMATION_MESSAGE);
        loadPendingRequests();
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadPendingRequests();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void loadPendingRequests() {
        DefaultTableModel model = (DefaultTableModel) tblLeaves.getModel();
        model.setRowCount(0);
        List<LeaveRequest> pending = leaveService.getPendingLeaves();
        for (LeaveRequest req : pending) {
            model.addRow(new Object[]{
                req.getId(),
                req.getEmpId(),
                req.getEmpName(),
                req.getDateFrom() != null ? req.getDateFrom().toString() : "",
                req.getDateTo() != null ? req.getDateTo().toString() : "",
                req.getReason(),
                req.getStatus() != null ? req.getStatus().name() : ""
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLeaves;
    // End of variables declaration//GEN-END:variables
}
