package com.bruno.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private Integer statusCode;

	private String msg = new String();

	
}
