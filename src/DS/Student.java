package DS;
import java.util.Comparator;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private String dept;
	private int grade;
	
	public Student(int id, String name, String dept, int grade) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	public String getDept() {return dept;}
	public int getGrade() {return grade;}
	
	@Override
	public int compareTo(Student s) {
		return this.id - s.id;
	}

	public static Comparator<Student> CompName = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	};

	public static Comparator<Student> CompDept = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.dept.compareTo(s2.dept);
		}
	};

	public static Comparator<Student> CompGrade = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.grade - o2.grade;
		}
	};
}
