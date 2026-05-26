package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.MFizzBuzz;
import com.example.domain.service.impl.FizzbuzzService;
import com.example.form.FizzbuzzForm;

@Controller
@RequestMapping("/fizzbuzz")
public class FizzbuzzController {

	@Autowired
	private FizzbuzzService fizzbuzzService;
	
	@GetMapping("/home")
	public String getFizzbuzzHome(Model model,@ModelAttribute FizzbuzzForm form) {
		
		List<MFizzBuzz> inputNumberList = fizzbuzzService.getInputNumber();
		
		if(inputNumberList != null) {
			model.addAttribute("inputNumberList", inputNumberList);
		}
		return "fizzbuzz/home";
	}

	@PostMapping("/home")
	public String postFizzbuzzHome(Model model,
			 @ModelAttribute  @Validated FizzbuzzForm form,
			BindingResult bindingResult) {

		//バリデーションチェック
		if (bindingResult.hasErrors()) {
			return getFizzbuzzHome(model, form);
		}

		int startNumber = form.getInputNumber();
		int totalNumber = form.getInputNumber() + 100;
		
		fizzbuzzService.insertNumber(form.getInputNumber());
		
		//受け取った値をfizzbuzzに変換
		List<Integer> fizzNumber = fizzbuzzService.fizzList(startNumber, totalNumber);
		List<Integer> buzzNumber = fizzbuzzService.buzzList(startNumber, totalNumber);
		List<Integer> fizzbuzzNumber = fizzbuzzService.fizzbuzzList(startNumber, totalNumber);
		List<Integer> totalNumberList = fizzbuzzService.fizzbuzzTotalNumberList(startNumber, totalNumber);
		
		//計算結果を受け渡し
		model.addAttribute("fizz", fizzNumber);
		model.addAttribute("buzz", buzzNumber);
		model.addAttribute("fizzbuzz", fizzbuzzNumber);
		model.addAttribute("totalNumberList", totalNumberList);
		
		return "fizzbuzz/result";
	}

}
