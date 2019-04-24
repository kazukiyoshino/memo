package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentsList {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statements = null;
		ResultSet resultSet = null;

		String requireSchoolClass = confirmClass();

		connection = createConnection();
		if(connection == null) ending(connection,statements,resultSet);

		Integer classId = findClassId(requireSchoolClass,connection,statements,resultSet);
        if(classId == null) ending(connection,statements,resultSet);

        resultSet = createResultSet(classId,connection,statements);
        if(resultSet == null) ending(connection,statements,resultSet);

        classListDisplay(requireSchoolClass,connection,resultSet);

        ending(connection,statements,resultSet);

	}


	public static String confirmClass() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("確認したいクラスを半角で入力してください");
	    String studentClass = scanner.nextLine();
	    System.out.println("入力されたクラス名："+studentClass);
	    scanner.close();
	    return studentClass;
	}


	public static Connection createConnection() {
		String url = "jdbc:postgresql://localhost:5432/training_dbconnection";
        String user = "postgres";
        String password = "postgres";
//      Scanner scanner = new Scanner(System.in);
        try {
//        	System.out.println("SQL user:"+user+" のパスワードを入力してください");
//            password = scanner.next();
            return DriverManager.getConnection(url,user,password);
        }
        catch(SQLException e) {
        	e.printStackTrace();
        	return null;
        }
//        finally {
//        	scanner.close();
//        }
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
    			System.out.println("クラスIDを発見できませんでした。");
    			return null;
    		}

        }


    public static ResultSet createResultSet(Integer classId,Connection connection,PreparedStatement statements) {
    	try {
    	 String sql = "select student_id,name from student where schoolclass_id = ?";
         statements = connection.prepareStatement(sql);
         statements.setInt(1,classId);
         return statements.executeQuery();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("sql文の実行及び情報取得に問題が発生しました。");
    	 return null;
    	}
    }


    public static void classListDisplay(String requireSchoolClass,Connection connection,ResultSet resultSet) {
    	try {
    		while(resultSet.next()){
                String collection = resultSet.getString(1);
                System.out.print("Id： "+collection+" ");
                System.out.print("クラス： "+requireSchoolClass+" ");
                collection = resultSet.getString(2);
                System.out.println("名前： "+collection);
            	}
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		System.out.println("生徒一覧の正常な表示に失敗しました。");
    	}
    }

    public static void ending(Connection connection,PreparedStatement statements,ResultSet resultSet) {
    	try {
            if(resultSet != null)resultSet.close();
            if(statements != null)statements.close();
            if(connection != null)connection.close();
            System.exit(0);
        }
        catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

}
