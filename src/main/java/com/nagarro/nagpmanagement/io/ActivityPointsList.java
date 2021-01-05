package com.nagarro.nagpmanagement.io;

import java.util.ArrayList;
import java.util.List;

public class ActivityPointsList {

	public List<Integer> points;
	public List<String> activityName;
	public int totalPoints;
	
	public ActivityPointsList() {
		this.points= new ArrayList<Integer>();
		this.activityName=new ArrayList<String>();
		this.totalPoints=0;
	}
	
	
}
