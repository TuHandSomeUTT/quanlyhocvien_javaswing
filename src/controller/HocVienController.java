package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;
        
/**
 *
 * @author Van Tu Nguyen - 72TT11 - UTT - Adam Nguyen.
 * @date Jun 18, 2024
 */
public class HocVienController {
    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdMale;
    private JRadioButton jrdFemale;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    
    private HocVien hocVien = null;
    
    private HocVienService hocVienService = null;
    
    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, 
            JDateChooser jdcNgaySinh, JRadioButton jrdMale, JRadioButton jrdFemale, JTextField jtfSoDienThoai, 
            JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdMale = jrdMale;
        this.jrdFemale = jrdFemale;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.hocVienService = new HocVienServiceImpl();
    }
    
    public void setView(HocVien hocVien){
        this.hocVien = hocVien;
        jtfMaHocVien.setText("#" + hocVien.getMaHocVien());
        jtfHoTen.setText(hocVien.getHoTen());
        jdcNgaySinh.setDate(hocVien.getNgaySinh());
        if (hocVien.isGioiTinh()==true){
            jrdMale.setSelected(true);
            jrdMale.setSelected(false);
        } else {
            jrdMale.setSelected(false);
            jrdMale.setSelected(true);
        }
        
        jtfSoDienThoai.setText(hocVien.getSoDienThoai());
        jtaDiaChi.setText(hocVien.getDiaChi());
        jcbTinhTrang.setSelected(hocVien.isTinhTrang());
    }

    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length()==0 || jdcNgaySinh.getDate() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc !");
                } else {
                    hocVien.setHoTen(jtfHoTen.getText());
                    hocVien.setNgaySinh(jdcNgaySinh.getDate());
                    hocVien.setGioiTinh(jrdMale.isSelected());
                    hocVien.setSoDienThoai(jtfSoDienThoai.getText());
                    hocVien.setDiaChi(jtaDiaChi.getText());
                    hocVien.setTinhTrang(jcbTinhTrang.isSelected());
                    
                    int lastID = hocVienService.createUpdate(hocVien);
                    if (lastID > 0){
                        hocVien.setMaHocVien(lastID);
                        jtfMaHocVien.setText("# " + lastID);
                        jlbMsg.setText("Cập Nhật Dữ Liệu Thành Công");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }
}
