
public class University implements School, java.io.Serializable {
	String universityName = "California State University Northridge";
	String motto = "Go Matadors!";
	Person[] people;
	String[] majors;
	String[] courses;
	University(String newUniName, String newMotto){
		universityName = newUniName;
		motto = newMotto;
		courses = new String[] {"Computers","Advance Physics","Quantum Entanglement",
				"Parallel Programming","Advance Algorithms","FPGA Programming","Hardware Design",
				"Embedded Systems","Signal Processing","Artificial Intelligence","Bayesian Logic",
				"Probability"};
		majors = new String[] {"Hardware Architecture","Information Analytics",
				"Quantum Computing","Undecided"};
		people = new Person[100];
		people[0] = new Faculty("Bruce", "Wayne", 9,27,1995,new String[]{"Bayesian Logic","Artificial Intelligence","Hardware Design"});
		people[1] = new Faculty("Diana","Prince",11,5,2006, new String[] {"Hardware Design","FPGA Programming","Embedded Systems"});
		people[2] = new Faculty("Barbara","Gordon",5,23,1980, new String[] {"Probability","Signal Processing","Advance Algorithms"});
		people[3] = new Faculty("Charles","Xavier",11,5,1966,new String[] {"Signal Processing","Embedded Systems","Parallel Programming"});
		people[4] = new Student("Billy","Baston",7,12,1990,"Information Analytics");
		people[5] = new Student("Carol","Danvers", 4,9,1992,"Quantum Computing");
		people[6] = new Student("Clark","Kent",5,5,1994,"Hardware Architecture");
		people[8] = new Student("Kara","Zorel",4,13,1989,"Hardware Architecture");
		people[9] = new Student("Peter","Parker",6,25,1997,"Quantum Computing");
		people[10] = new Student("Tony","Stark",2,2,2004,"Hardware Architecture");
		people[11] = new Student("Stephen","Strange",12,15,1976,"Quantum Computing");
		people[12] = new Student("Bruce","Banner",9,9,2000,"Undecided");
		}
	//Checks if user Input from "doHire" @UniversitDriver is a Valid Course
	public boolean facultyCourseChecker(String[] course, String in) {
		for(int i = 0; i<course.length; i++) {
			if(courses[i].equals(in)) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if user Input from "doAdmit" @UniversityDriver is a valid Major
	public boolean studentMajorChecker(String in) {
		for(int i = 0; i<majors.length; i++) {
			if(majors[i].equals(in)) {
				return true;
			}
		}
		return false;
	}
	
	//returns the Student specified by fn(firstName) and ln (lastName)
	public Student findStudent(String fn, String ln) {
		for(int i = 0; i < people.length; i++) {
			if(people[i] != null && people[i].firstName.equals(fn) && people[i].lastName.equals(ln) && people[i] instanceof Student) {
				return (Student)people[i];
			}
			
		}
		return null;
	}
	
	//returns the Faculty specified by fn(firstName) and ln (lastName)
	public Faculty findFaculty(String fn, String ln) {
		for(int i = 0; i < people.length; i++) {
			if(people[i] != null && people[i].firstName.equals(fn) && people[i].lastName.equals(ln) && people[i] instanceof Faculty) {
				return (Faculty)people[i];
			}
			
		}
		return null;
	}
	
	//adds a Faculty object to the Person []
	public Faculty hire(Person p) {
		for (int i=0; i<people.length; i++) {
			if (people[i] == null) {
				people[i] = p;
				break;
			}
		}
		return (Faculty)p;
	}
	
	//adds a Student object to the Person []
	public Student admit(Person p) {
		for (int i=0; i<people.length; i++) {
			if (people[i] == null) {
				people[i] = p;
				break;
			}
		}
		return (Student)p;
	}
	
	//returns the people variable for the university
	public Person[] getAllPersons() {
		return people;
	}
	
	//returns the majors variable for the university
	public String[] getAllMajors() {
		return majors;
	}
	
	//returns the courses variable for the university
	public String[] getAllCourses() {
		return courses;
	}
	
	//returns a Person [] of all Students only
	public Person[] getStudents() {
		Person[] studentReturn = new Person[people.length];
		int arrayIndex = 0;
		for(int i =0; i<people.length; i++) {
			if(people[i] instanceof Student) {
			studentReturn[arrayIndex] = (Student)people[i];
			arrayIndex++;
			}
		}
		return studentReturn;
	}
	
	//returns a Person [] of all Faculty only
	public Person[] getFaculty() {
		Person[] facultyReturn = new Person[people.length];
		int arrayIndex = 0;
		for(int i =0; i<people.length; i++) {
			if(people[i] instanceof Faculty) {
			facultyReturn[arrayIndex] = (Faculty)people[i];
			arrayIndex++;
			}
		}
		return facultyReturn;
	}
}
