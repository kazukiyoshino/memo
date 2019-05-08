package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

import studentmanagement.model.schoolclass.SchoolClassName;
import studentmanagement.model.student.Student;
import studentmanagement.service.studentlist.GetStudentListService;
import studentmanagement.service.studentlist.ValidationClassService;

public class StudentsList {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try{
			SchoolClassName schoolClassName =requestSchoolClassName();
			boolean validationClass = ValidationClassService.validationClass(schoolClassName);

			if(!validationClass) {
				System.out.println("入力されたクラスが見つかりません");
				return;
			}

			studentDisplay(GetStudentListService.getStudentList(schoolClassName));

		}
		catch(Exception e) {
			System.out.println("エラーが発生しました。プログラムを終了します。");
			throw e;
		}
		finally {
			scanner.close();
		}
	}


	public static SchoolClassName requestSchoolClassName() {
		System.out.println("確認したい生徒のクラスを半角で入力してください");
	    String studentClass = scanner.nextLine();
	    System.out.println("入力されたクラス名："+studentClass);
	    return new SchoolClassName(studentClass);
	}


	public static void studentDisplay(ArrayList<Student> studentList) {
		for(Student student : studentList) {
			System.out.print("Id： "+student.getStudentId().getId()+" ");
            System.out.print("クラス： "+student.getSchoolClass().getSchoolClassName().getName()+" ");
            System.out.println("名前： "+student.getStudentName().getName());
		}
		if(studentList.size()==0) {
			System.out.println("対象のクラスに所属する生徒はおりません。");
		}
	}

}
