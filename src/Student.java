
public class Student extends Person {
	String major;
	
	Student(String fn, String ln, int mb, int db, int yb, String newMajor){
		super(fn,ln,mb,db,yb);
		major = newMajor;
	}

}
