package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		// ask how many students to be added
		System.out.print("Enter number of students");
		Scanner in = new Scanner(System.in);
		int noOfStudents = in.nextInt();
		Student[] students = new Student[noOfStudents];
		
		// create n number of new students
		for(int n=0; n<noOfStudents;n++) {
			students[n] = new Student();
			students[n].enroll();
			students[n].payTution();
		}
		for(int i=0; i<noOfStudents; i++) {
			System.out.println(students[i].showInfo()); 
		}
	}

}
