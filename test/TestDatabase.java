import java.sql.*;

public class TestDatabase {
    public static void main(String[] args) {
        Connection conn =null;
        try {

            Class.forName("oracle.jdbc.OracleDriver");
       conn  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","system","272232");
            PreparedStatement ps = conn.prepareStatement("SELECT  * FROM test1");
            ResultSet rs  =ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getObject("t_name"));
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
