package com.example.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.MFizzBuzz;
import com.example.repository.FizzBuzzMapper;

@Service
public class FizzbuzzService {

	@Autowired
	private FizzBuzzMapper mapper;
	
	public List<Integer> fizzbuzzList(int startNumber, int totalNumber) {

		List<Integer> fizzbuzzNumber = new ArrayList<>();

		for (int i = startNumber; i <= totalNumber; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzbuzzNumber.add(i);
			}
		}

		return fizzbuzzNumber;
	}

	public List<Integer> buzzList(int startNumber, int totalNumber) {

		List<Integer> buzzNumber = new ArrayList<>();

		for (int i = startNumber; i <= totalNumber; i++) {
			if (!(i % 3 == 0) && i % 5 == 0) {
				buzzNumber.add(i);
			}
		}

		return buzzNumber;
	}

	public List<Integer> fizzList(int startNumber, int totalNumber) {

		List<Integer> fizzNumber = new ArrayList<>();

		for (int i = startNumber; i <= totalNumber; i++) {
			if (!(i % 5 == 0) && i % 3 == 0) {
				fizzNumber.add(i);
			}
		}

		return fizzNumber;
	}
	
	public List<Integer> fizzbuzzTotalNumberList(int startNumber, int totalNumber) {
		
		List<Integer> totalNumberList = new ArrayList<>();
		
		for(int i = startNumber; i <= totalNumber; i++) {
			totalNumberList.add(i);
		}
		
		return totalNumberList;
	}
	
	public void insertNumber(int inputNumber) {
		mapper.insertOne(inputNumber);
	}
	
	public List<MFizzBuzz> getInputNumber(){
		return mapper.getInputNumber();
	}
}
