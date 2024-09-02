package com.example.form;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class WorkInfoForm {
	private Integer userId;
	private Integer workPlaceId;
	private String workPlace;
	private Date workDay;
	private Time startTime;
	private Time  breakTime;
	private Time  endTime;
}
