package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;
import utility.ClassTableModel;

/**
 *
 * @author Van Tu Nguyen - 72TT11 - UTT - Adam Nguyen.
 * @date Jun 17, 2024
 */
public class QuanLyHocVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;

    private HocVienService hocVienService = null;
    
    private String[] listColumn = {"Mã Học Viên", "STT", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Địa Chỉ", "Tình Trạng"};
    
    private TableRowSorter<TableModel> rowSorter = null;
            
    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.hocVienService = new HocVienServiceImpl();
    }
    
    public void setDataToTable(){
        List<HocVien> listItem = hocVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() { // sự kiện tìm kiếm, hiển thị data rows theo những gì nhập trong jtextfield
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0){ // nếu jtextfield trống thì giữ nguyên trạng thái, không hiển thị gì
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); 
//              Nếu văn bản không trống, áp dụng bộ lọc để chỉ hiển thị các hàng khớp với văn bản tìm kiếm, không phân biệt chữ hoa chữ thường (RowFilter.regexFilter("(?i)" + text)).      
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) { // giống như bên trên chỉ có điều là nó được gọi khi văn bản bị xóa khỏi jtextfield
                String text = jtfSearch.getText();
                if (text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        // Cài đặt hiển thị cho cột đầu tiên (Nó là cột mã học viên trong database nhưng ta không hiển thị, chỉ hiển thị số thứ tự ra thôi). Ẩn nó đi luôn
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        // Cài đặt hiển thị cho cột có chỉ số index là 1 (Cột ID).
        table.getColumnModel().getColumn(1).setMinWidth(60);
        table.getColumnModel().getColumn(1).setMaxWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        
        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1350, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
}
