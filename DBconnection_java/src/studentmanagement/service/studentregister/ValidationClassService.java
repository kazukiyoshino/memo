package studentmanagement.service.studentregister;

import java.util.Optional;

import studentmanagement.dataaccess.student.FindClassIdDataAccess;
import studentmanagement.model.schoolclass.SchoolClassId;
import studentmanagement.model.schoolclass.SchoolClassName;

public class ValidationClassService {
	public static boolean validationClass(SchoolClassName schoolClassName){
		try{
			Optional<SchoolClassId> schoolClassId = FindClassIdDataAccess.findClassId(schoolClassName);

			if(schoolClassId.isEmpty()) {
				return false;
				}
			else return true;
		}
		catch (RuntimeException e){
	      e.printStackTrace();
	      throw e;
		}
	}

}
