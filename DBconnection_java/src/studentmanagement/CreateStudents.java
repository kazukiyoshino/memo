package studentmanagement;

import java.util.Scanner;

import studentmanagement.model.schoolclass.SchoolClassName;
import studentmanagement.model.student.StudentName;
import studentmanagement.service.studentregister.RegisterStudentService;
import studentmanagement.service.studentregister.ValidationClassService;

public class CreateStudents {
    static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try{
			StudentName studentName =requestRegisterName();

			if(!studentName.validationStudentNameLength()) {
				System.out.println("登録する生徒名の文字数が長すぎます。60文字以内で入力してください");
				return;
			}

			SchoolClassName schoolClassName = requestRegisterSchoolClassName();
			boolean validationClass = ValidationClassService.validationClass(schoolClassName);
			if(!validationClass) {
				System.out.println("入力されたクラスが見つかりません");
				return;
			}
			RegisterStudentService registerStudent = new RegisterStudentService();
			registerStudent.registerStudent(studentName, schoolClassName);

			System.out.println("処理が完了しました。");
		}
		catch(Exception e) {
			System.out.println("エラーが発生しました。プログラムを終了します。");
		}
		finally {
				scanner.close();
		}
	}


	public static StudentName requestRegisterName() {
		System.out.println("登録したい生徒の名前を入力してください");
		String studentName = scanner.nextLine();
		System.out.println("入力された生徒名："+studentName);
		return new StudentName(studentName);
		}


	public static SchoolClassName requestRegisterSchoolClassName() {
		System.out.println("登録したい生徒のクラスを半角で入力してください");
	    String studentClass = scanner.nextLine();
	    System.out.println("入力されたクラス名："+studentClass);
	    return new SchoolClassName(studentClass);
	}
}
