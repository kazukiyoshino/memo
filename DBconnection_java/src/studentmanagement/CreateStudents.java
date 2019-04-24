package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateStudents {
//	Scanner roadData = new Scanner(System.in);

//	Scanner roadData;
//	public CreateStudents() {
//	 this.roadData = new Scanner(System.in);
//	 }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String studentName = EnteringName(scanner);
		String studentClass = EnteringSchoolClass(scanner);
		scanner.close();

		boolean done = enteringDB(studentName,studentClass);

		if(done)System.out.println("登録が完了しました。");
		else System.out.println("登録が失敗しました。");
	}


	public static String EnteringName(Scanner scanner) {

		System.out.println("登録したい生徒の名前を入力してください");
		String studentName = scanner.nextLine();
		System.out.println("入力された生徒名："+studentName);
		return studentName;
		}


	public static String EnteringSchoolClass(Scanner scanner) {

		System.out.println("登録したい生徒のクラスを半角で入力してください");
	    String studentClass = scanner.nextLine();
	    System.out.println("入力されたクラス名："+studentClass);
	    return studentClass;
	}


    public static boolean enteringDB(String studentName,String studentClass) {

    	Connection connection = null;
		PreparedStatement statements = null;
		ResultSet resultSet = null;

        //接続情報
        String url = "jdbc:postgresql://localhost:5432/training_dbconnection";
        String user = "postgres";
        String password = "postgres";

    	try {

	        connection = DriverManager.getConnection(url, user, password);

	        //自動コミットOFF
	        connection.setAutoCommit(false);

	    	Integer studentClassId = findClassId(studentClass,connection,statements,resultSet);
	    	if(studentClassId == null) {
	    		System.out.println("schoolClassIdを発見できませんでした。");
	    		return false;
	    	}

	    	//insert文実行
	        String sql = "insert into student values(nextval('student_Id_seq'),?,?,current_timestamp,current_timestamp)";
	        statements = connection.prepareStatement(sql);
	        statements.setInt(1,studentClassId);
	        statements.setString(2,studentName);
	        statements.executeUpdate();
	        connection.commit();

	        return true;

	      }
	    catch (SQLException e){
	          e.printStackTrace(); //例外情報の出力
	          return false;
	          }
    	finally {
	          try {
	              if(resultSet != null)resultSet.close();
	              if(statements != null)statements.close();
	              if(connection != null)connection.close();
	          }
	          catch (SQLException e){
	              e.printStackTrace();

	          }
    	}
    }


	public static Integer findClassId(String studentclass,Connection connection,PreparedStatement statements,ResultSet resultSet) {
		try {
			String sql = "select schoolclass_id from schoolclass where name = ?";
			statements = connection.prepareStatement(sql);
			statements.setString(1,studentclass);
			resultSet= statements.executeQuery();

			resultSet.next();//重要

			Integer schoolId =resultSet.getInt(1);

			return schoolId;
		}
		catch(SQLException e) {
			e.printStackTrace(); //例外情報の出力
			return null;
		}

        }
}

	    //DBへの登録コードを作成する。(生徒番号忘れずに）
		//完成後、issue8→developへプルリクエスト(レビュアーを鎌田さんに)