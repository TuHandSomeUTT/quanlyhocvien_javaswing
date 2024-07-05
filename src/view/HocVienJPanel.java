package view;

import controller.QuanLyHocVienController;

/**
 *
 * @author tungu
 */
public class HocVienJPanel extends javax.swing.JPanel {
    public HocVienJPanel() {
        initComponents();
        
        QuanLyHocVienController controller = new QuanLyHocVienController(jPnView, jBtnAdd, txtSearch, jBtnPrint, jBtnDelete);
        controller.setDataToTable();
        controller.setEvent();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnRoot = new javax.swing.JPanel();
        jBtnAdd = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jPnView = new javax.swing.JPanel();
        jBtnPrint = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();

        jPnRoot.setBackground(new java.awt.Color(204, 255, 153));

        jBtnAdd.setBackground(new java.awt.Color(76, 175, 80));
        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnAdd.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setText("+ Thêm Mới");
        jBtnAdd.setBorder(null);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPnViewLayout = new javax.swing.GroupLayout(jPnView);
        jPnView.setLayout(jPnViewLayout);
        jPnViewLayout.setHorizontalGroup(
            jPnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPnViewLayout.setVerticalGroup(
            jPnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jBtnPrint.setBackground(new java.awt.Color(76, 175, 80));
        jBtnPrint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnPrint.setForeground(new java.awt.Color(255, 255, 255));
        jBtnPrint.setText("Xuất Báo Cáo");
        jBtnPrint.setBorder(null);

        jBtnDelete.setBackground(new java.awt.Color(76, 175, 80));
        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("Xóa Dữ Liệu");
        jBtnDelete.setBorder(null);

        javax.swing.GroupLayout jPnRootLayout = new javax.swing.GroupLayout(jPnRoot);
        jPnRoot.setLayout(jPnRootLayout);
        jPnRootLayout.setHorizontalGroup(
            jPnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPnRootLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPnRootLayout.setVerticalGroup(
            jPnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnPrint;
    private javax.swing.JPanel jPnRoot;
    private javax.swing.JPanel jPnView;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
