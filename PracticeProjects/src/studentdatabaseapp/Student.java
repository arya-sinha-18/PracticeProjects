package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;// value not specific to object
	private static int id = 1000;
	
	// constructor: enter student's name and year
	public Student(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter last name: ");
		this.lastName = in.nextLine();

		System.out.print("1: Freshman\n2: Sophomore\n3: Junior\n4: Senior\nEnter student class level: ");
		this.gradeYear = in.nextInt();
		setStudentId();
	}
	// generate a unique id
	private void setStudentId() {
		id++;
		this.studentId =  gradeYear + "" + id;
	}
	// enroll in courses
	public void enroll() {
		// hit 0 after enrolling
		System.out.println("Enter q to exit after enrolling in courses");
		do {
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses += "\n   " + course;
				tuitionBalance += costOfCourse;
			}else {
				break;
			}
		} while(true);
	}
	// view balance
	public void viewBalance() {
		System.out.println("Your balance is: "+tuitionBalance);
	}
	// pay tuition
	public void payTution() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $"+payment);
		viewBalance();
	}
	// show status
	public String showInfo() {
		return "Name: "+firstName+" "+lastName+
				"\nGrade level: "+gradeYear+
				"\nStudentId: "+studentId+
				"\nCourses Enrolled:" + courses +
				"\nBalance: $"+tuitionBalance;
	}
}
