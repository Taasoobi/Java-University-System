
public interface School {
	Student findStudent(String fn, String ln);//returns the Student specified by fn(firstName) and ln (lastName)
	Faculty findFaculty(String fn, String ln);//returns the Faculty specified by fn(firstName) and ln (lastName)
	Faculty hire(Person p);//adds a Faculty object to the Person []
	Student admit(Person p);//adds a Student object to the Person []
	Person[] getAllPersons();//returns the people variable for the university
	String[] getAllMajors();//returns the majors variable for the university
	String[] getAllCourses();//returns the courses variable for the university
	Person []getStudents();//returns a Person [] of all Students only
	Person []getFaculty();//returns a Person [] of all Faculty only	
}
