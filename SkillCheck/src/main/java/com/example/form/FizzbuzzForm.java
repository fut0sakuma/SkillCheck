package com.example.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FizzbuzzForm {

	@Max(100)
	@Min(1)
	@NotNull
	private Integer inputNumber;
}
