package studentmanagement.dataaccess.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import studentmanagement.model.schoolclass.SchoolClassId;
import studentmanagement.model.schoolclass.SchoolClassName;

public class FindClassIdDataAccess {

		public static Optional<SchoolClassId> findClassId(SchoolClassName schoolClassName){//修正5/7(findクラスIDは分割しなくていい：resultsetはまだDB関係の値)
			String sql = "select schoolclass_id from schoolclass where name = ?";
			try(Connection connection = DBconnectionCreateDriverManagerDataAccess.createConnection();
				PreparedStatement statements = connection.prepareStatement(sql);) {
				statements.setString(1,schoolClassName.getName());
		    	ResultSet resultSet = statements.executeQuery();
				

			    if(resultSet.next()) {//重要
		    		Integer schoolId =resultSet.getInt(1);

		    		return Optional.ofNullable(new SchoolClassId(schoolId));
	    		}
			    else return Optional.ofNullable(null);
	    		}
	    	catch(SQLException e) {
	    			e.printStackTrace(); //例外情報の出力
	    			throw new RuntimeException(e);
	    		}
	        }

}