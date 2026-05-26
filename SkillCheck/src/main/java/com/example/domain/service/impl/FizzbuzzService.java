package com.example.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzbuzzService {

	public List<Integer> fizzbuzzLogic(int number) {

		int totalNumber = number + 100;

		List<Integer> fizzbuzzNumber = new ArrayList<>();

		for (int i = 0; i <= totalNumber; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzbuzzNumber.add(i);
			}
		}

		return fizzbuzzNumber;
	}

	public List<Integer> buzzLogic(int number) {

		int totalNumber = number + 100;

		List<Integer> buzzNumber = new ArrayList<>();

		for (int i = 0; i <= totalNumber; i++) {
			if (!(i % 3 == 0) && i % 5 == 0) {
				buzzNumber.add(i);
			}
		}

		return buzzNumber;
	}

	public List<Integer> fizzLogic(int number) {

		int totalNumber = number + 100;

		List<Integer> fizzNumber = new ArrayList<>();

		for (int i = 0; i <= totalNumber; i++) {
			if (!(i % 5 == 0) && i % 3 == 0) {
				fizzNumber.add(i);
			}
		}

		return fizzNumber;
	}
}
