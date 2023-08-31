
public class Person implements java.io.Serializable{
	String firstName;
	String lastName;
	int monthBirth;
	int dayBirth;
	int yearBirth;
	
	//Constructor
	Person(String fn, String ln, int mb, int db, int yb){
		firstName = fn;
		lastName = ln;
		monthBirth = mb;
		dayBirth = db;
		yearBirth = yb;
	}
	
}
