package kr.spring.lecture.domain;

import java.util.ArrayList;
import java.util.Collections;

public class LecturePointCommand {
	private int point1;
	private int point2;
	private int point3;
	private int point4;
	private int point5;
	private int maxpoint;
	
	public void calcMaxPoint() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(point1);
		list.add(point2);
		list.add(point3);
		list.add(point4);
		list.add(point5);
		
		setMaxpoint(Collections.max(list));
	}
	
	public int getMaxpoint() {
		return maxpoint;
	}



	public void setMaxpoint(int maxpoint) {
		this.maxpoint = maxpoint;
	}



	public int getPoint1() {
		return point1;
	}
	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	public int getPoint2() {
		return point2;
	}
	public void setPoint2(int point2) {
		this.point2 = point2;
	}
	public int getPoint3() {
		return point3;
	}
	public void setPoint3(int point3) {
		this.point3 = point3;
	}
	public int getPoint4() {
		return point4;
	}
	public void setPoint4(int point4) {
		this.point4 = point4;
	}
	public int getPoint5() {
		return point5;
	}
	public void setPoint5(int point5) {
		this.point5 = point5;
	}
}
