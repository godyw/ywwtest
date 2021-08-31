package com.godv;

import java.util.ArrayList;
import java.util.List;

public class TestDiyList {
	public static void main(String[] args) {
		Student stu1 = new Student(1, "stu1");
		Student stu2 = new Student(2, "stu2");
		Student stu3 = new Student(3, "stu3");
		
		DiyList<Student> stus1 = new DiyArrayList<Student>();
		stus1.add(stu1);
	}
	
}
