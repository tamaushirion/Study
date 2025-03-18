package com.example.domain.user.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
@Data
public class MWork {
	private Integer workInfoId;
	private Integer userId;
	private Integer workPlaceId;
	private Date workDay;
	private Time startTime;
	private Time  breakTime;
	private Time  endTime;
	private String workPlace;
}
