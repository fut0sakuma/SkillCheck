package com.example.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class FizzbuzzForm {

	@Max(100)
	@Min(1)
	private Integer inputNumber;
}
