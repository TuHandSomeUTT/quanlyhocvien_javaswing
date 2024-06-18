package main;
import view.MainJFrame;
import java.sql.Connection;
/**
 *
 * @author Van Tu Nguyen - 72TT11 - UTT - Adam Nguyen.
 * @date Jun 11, 2024
 */
public class Main {
    public static void main(String[] args) {
        new MainJFrame();
        try {
//          Test thử kết nối
            Connection SqlConn = dao.DBConnect.getConnection();
            System.out.println("Mission Success");
            
//          Thử ngắt kết nối
            dao.DBConnect.closeConnection(SqlConn);
            System.out.println("Disconnected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
