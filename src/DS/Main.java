package DS;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Student[] studs = {
				new Student(1, "김", "융소", 2),
				new Student(2, "이", "경", 3),
				new Student(3, "윤", "경", 3)
		};
		
		Arrays.sort(studs);
		print(studs, "id");

		Arrays.sort(studs, Student.CompName);
		print(studs, "이름");

		Arrays.sort(studs, Student.CompDept);
		print(studs, "학과");

		Arrays.sort(studs, Student.CompGrade);
		print(studs, "학년");
	}
	
	public static void print(Student[] studs, String key) {
		System.out.println();
		System.out.println(key + "(으)로 정렬");
		System.out.println("-----------------");
		for(Student s: studs) {
			System.out.println(s.getId() + " " + s.getName() + " " + s.getDept() + " " + s.getGrade());
		}

	}

}
