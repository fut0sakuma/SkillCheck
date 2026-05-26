package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.MFizzBuzz;

@Mapper
public interface FizzBuzzMapper {

	//入力値登録
	public int insertOne(Integer inputNumber);
	
	//入力値取得
	public List<MFizzBuzz> getInputNumber();

}
