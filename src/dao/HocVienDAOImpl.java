package dao;

import java.util.List;
import model.HocVien;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Van Tu Nguyen - 72TT11 - UTT - Adam Nguyen.
 * @date Jun 15, 2024
 */
public class HocVienDAOImpl implements HocVienDAO{

    // Continued
    @Override
    public List<HocVien> getList() {
        try {
            Connection SqlConn = dao.DBConnect.getConnection();
            String SqlQuery = "SELECT * FROM hoc_vien";
            List<HocVien> list = new ArrayList<HocVien>();
            PreparedStatement pst = SqlConn.prepareCall(SqlQuery);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next() == true){
                HocVien hocVien = new HocVien();
                hocVien.setMaHocVien(rs.getInt("ma_hoc_vien"));
                hocVien.setHoTen(rs.getString("ho_ten"));
                hocVien.setNgaySinh(rs.getDate("ngay_sinh"));
                hocVien.setSoDienThoai(rs.getString("so_dien_thoai"));
                hocVien.setGioiTinh(rs.getBoolean("gioi_tinh"));
                hocVien.setDiaChi(rs.getString("dia_chi"));
                hocVien.setTinhTrang(rs.getBoolean("tinh_trang"));
                
                list.add(hocVien);
            }
            pst.close();
            rs.close();
            DBConnect.closeConnection(SqlConn);
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HocVienDAO hocVienDAO = new HocVienDAOImpl();
        System.out.println(hocVienDAO.getList());
    }
}
