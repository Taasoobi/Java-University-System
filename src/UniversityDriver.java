/* Taaseen Chowdhury 
 * Computer Science 182
 * Project 1*/

//Line to import Scanner, in order to get User Input. And File input
import java.util.Scanner;
import java.io.*;

public class UniversityDriver {
	public static University HeroSchool;
	public static Scanner scan = new Scanner(System.in);
	public static boolean runAgain = true;
	
	public static void main(String[] args) {
		HeroSchool = new University("HERO UNIVERSITY","ex tenebris ad lucem alis novis volabimus");
		
		
		
		//Java IO Streams
		try {
	         FileInputStream fileIn = new FileInputStream("UniversityPersons.per");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         HeroSchool = (University) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	    	  System.out.println("a \"UniverstyPersons.per\" file is not available.");
	         //i.printStackTrace();
	         
	      } catch (ClassNotFoundException c) {
	         System.out.println("University class not found");
	         c.printStackTrace();
	      }
		
		//Menu
		System.out.println("Welcome to " +HeroSchool.universityName);
		System.out.println(HeroSchool.motto);
		System.out.println("What would you like to do?");
		
		System.out.println("1. Enter \"hire\" to hire a new faculty member. \n"
				+ "2. Enter \"admit\" to admit a new student. \n"
				+ "3. Enter \"find student\" to list information about a student. \n"
				+ "4. Enter \"find faculty\" to list information about a faculty member. \n"
				+ "5. Enter \"list students\" to list the names of all students. \n"
				+ "6. Enter \"list faculty\" to list the names of all faculty members. \n"
				+ "7. Enter \"quit\" to end this program and save data.");
		//While loop to repeat options in case of choice error
	while(runAgain == true) {
		String userInput = scan.nextLine();
		//System.out.println("You Chose: " + userInput);
		
		//Uppercase and Delete any Space
		userInput = userInput.toUpperCase();
		userInput = userInput.replaceAll("\\s","");
		
		if(userInput.equals("HIRE")) {
			doHire();
			runAgain=true;
		} else if(userInput.equals("ADMIT")) {
			doAdmit();
			runAgain=true;
		} else if(userInput.equals("FINDSTUDENT")) {
			findStudent();
			runAgain=true;
		} else if(userInput.equals("FINDFACULTY")) {
			findFaculty();
			runAgain=true;
		} else if(userInput.equals("LISTSTUDENTS")) {
			listStudents();
			runAgain=true;
		} else if(userInput.equals("LISTFACULTY")) {
			listFaculty();
			runAgain=true;
		} else if(userInput.equals("QUIT")) {
			quitProgram();
			runAgain=false;
		} else {
			System.out.println("Error, Try an Option again.");
			runAgain=true;
		}
		
	}
}
	static void doHire() {
		//System.out.println("Hire Method Commenced");
		System.out.println("What is this new Faculty's first name?");
		String fn = scan.nextLine();
		System.out.println("What is this new Faculty's last name?");
		String ln = scan.nextLine();
		System.out.println("What is this new Faculty's month of birth?");
		System.out.println( "Enter an integer to represent the month.");
		int mb = scan.nextInt();
		System.out.println("What is this new Faculty's day of birth?");
		System.out.println( "Enter an integer to represent the day.");
		int db = scan.nextInt();
		System.out.println("What is this new Faculty's year of birth?");
		System.out.println( "Enter an integer to represent the year. (Enter 4 Digits)");
		int yb = scan.nextInt();
		
		
		System.out.println("Assign course(s) to this new Faculty member. Enter 'done' if you have completed assigning courses");
		String[] selectedCourses = new String[12];
		System.out.println("The courses offered are:\nComputers \nAdvance Physics \nQuantum Entanglement \nParallel Programming \nAdvance Algorithms"
				+ "\nFPGA Programming \nHardware Design \nEmbedded Systems \nSignal Processing \nArtificial Intelligence \nBayesian Logic"
				+ "\nProbability");
		for(int i=0; i<selectedCourses.length; i++) {
			String chosenCourse = scan.nextLine();
				if(chosenCourse.equals("done")) {
					break;
				} else {
					if(HeroSchool.facultyCourseChecker(selectedCourses, chosenCourse)) {
						selectedCourses[i] = chosenCourse;
						i++;
						System.out.println("Assign course(s) to this new Faculty member. Enter 'done' if you have completed assigning courses");
						
					} else {
						System.out.println("This is not an available course.");
						System.out.println("Assign course(s) to this new Faculty member. Enter 'done' if you have completed assigning courses");
					}
				}
		}
		Faculty newFacultyAdmission = new Faculty(fn, ln, mb, db, yb, selectedCourses);
		HeroSchool.hire(newFacultyAdmission);
	}
	static void doAdmit() {
		//System.out.println("Admit Method Commenced");
		String majorChosen = null;
		boolean condition = true;
		System.out.println("What is this new Student's Major");
		System.out.println("The Majors Offered are: \nHardware Architecture \nInformation Analytics \nQuantum Computing \nUndecided");
			while(condition == true) {
				String checkMajor = scan.nextLine();
				if(HeroSchool.studentMajorChecker(checkMajor)) {
					majorChosen = checkMajor;
					break;
				} else {
					System.out.println("That is not an offered Major");
					System.out.println("What is this new Student's Major?");
				}
			}
		
		
		System.out.println("What is this new Student's first name?");
		String fn = scan.nextLine();
		System.out.println("What is this new Student's last name?");
		String ln = scan.nextLine();
		System.out.println("What is this new Student's month of birth?");
		System.out.println( "Enter an integer to represent the month.");
		int mb = scan.nextInt();
		System.out.println("What is this new Student's day of birth?");
		System.out.println( "Enter an integer to represent the day.");
		int db = scan.nextInt();
		System.out.println("What is this new Student's year of birth?");
		System.out.println( "Enter an integer to represent the year.(4 Digits)");
		int yb = scan.nextInt();
		scan.nextLine();
		System.out.println("   ");
		
		Student newStudentAdmssion = new Student(fn,ln,mb,db,yb,majorChosen);
		HeroSchool.admit(newStudentAdmssion);
		
	}
	static void findStudent() {
		//System.out.println("Find Student Method Commenced");
		System.out.println("What is the students first name?");
		String fn = scan.nextLine();
		System.out.println("What is the students last name?");
		String ln = scan.nextLine();
		Student foundStudent = HeroSchool.findStudent(fn,ln);
		if (foundStudent == null) {
			System.out.println("Student Not Found");
		} else {
			System.out.println("Student: " + foundStudent.firstName + " " + foundStudent.lastName);
			System.out.println("DOB: " + foundStudent.monthBirth + "/" +foundStudent.dayBirth+ "/" +foundStudent.yearBirth);
			System.out.println("Major: " +foundStudent.major);
		}
	}
	static void findFaculty() {
		//System.out.println("Find Faculty Method Commenced");
		System.out.println("What is the faculty's first name?");
		String fn = scan.nextLine();
		System.out.println("What is the faculty's last name?");
		String ln = scan.nextLine();
		Faculty foundFaculty = HeroSchool.findFaculty(fn, ln);
		if (foundFaculty == null) {
			System.out.println("Faculty Member not found.");
		} else {
			System.out.println("Faculty: "+foundFaculty.firstName+" "+foundFaculty.lastName);
			System.out.println("DOB: "+foundFaculty.monthBirth+"/"+foundFaculty.dayBirth+"/"+foundFaculty.yearBirth);
			System.out.println("Courses: ");
				for(int i = 0; i<foundFaculty.courses.length; i++) {
					while(foundFaculty.courses[i] != null) {
						System.out.println(foundFaculty.courses[i]);
						break;
					}
				}
		}
	}
	static void listStudents() {
		//System.out.println("List Student Method Commenced");
		Person[] studentList = HeroSchool.getStudents();
		for (int i = 0; i<studentList.length; i++) {
			if(studentList[i] != null) {
				System.out.println(studentList[i].firstName+ " " +studentList[i].lastName);
			}
		}
	}
	static void listFaculty() {
		//System.out.println("List Faculty Method Commenced");
		Person[] facultyList = HeroSchool.getFaculty();
		for (int i = 0; i<facultyList.length; i++) {
			if(facultyList[i] != null) {
				System.out.println(facultyList[i].firstName+ " " +facultyList[i].lastName);
			}
		}
	}
	static void quitProgram() {
		//System.out.println("Quit Method Commenced");
		try {
	         FileOutputStream fileOut = new FileOutputStream("UniversityPersons.per");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(HeroSchool);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in UniversityPersons.per");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
			System.exit(0);
	}
}