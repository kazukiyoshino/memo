package studentmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionTest {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //接続文字列
        String url = "jdbc:postgresql://localhost:5432/training_dbconnection";
        String user = "postgres";
        String password = "Ky22364467";

        try{
            //PostgreSQLへ接続
            connect = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            connect.setAutoCommit(false);


            statement = connect.createStatement();

            //SELECT文の実行
            String sql = "SELECT* from course";
            resultSet = statement.executeQuery(sql);

            //SELECT結果の受け取り
            while(resultSet.next()){
                String col = resultSet.getString(2);
                System.out.println(col);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(resultSet != null)resultSet.close();
                if(statement != null)statement.close();
                if(connect != null)connect.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
}