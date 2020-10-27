package com.edu.dto;

import	lombok.Getter;
import	lombok.Setter;
import	lombok.ToString;
import	lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
@ToString(exclude= {"val3"})
public class SampleDTO {
	private	String	val1;
	private	String	val2;
	private	String	val3;
}













