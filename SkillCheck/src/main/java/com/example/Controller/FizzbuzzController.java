package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.service.impl.FizzbuzzService;
import com.example.form.FizzbuzzForm;

@Controller
@RequestMapping("/fizzbuzz")
public class FizzbuzzController {

	@Autowired
	private FizzbuzzService fizzbuzzService;
	
	
	@GetMapping("/home")
	public String getFizzbuzzHome() {
		return "fizzbuzz/home";
	}

	@PostMapping("/home")
	public String postFizzbuzzHome(Model model, @RequestParam int inputNumber,
			@Validated FizzbuzzForm form,
			BindingResult bindingResult) {

		//バリデーションチェック
		if (bindingResult.hasErrors()) {
			//NGユーザー登録画面に戻ります
			return getFizzbuzzHome();
		}
		
		//受け取った値をfizzbuzzに変換
		List<Integer> fizzNumber = fizzbuzzService.fizzLogic(inputNumber);
		List<Integer> buzzNumber = fizzbuzzService.buzzLogic(inputNumber);
		List<Integer> fizzbuzzNumber = fizzbuzzService.fizzbuzzLogic(inputNumber);
		
		//計算結果を受け渡し
		model.addAttribute("fizz", fizzNumber);
		model.addAttribute("buzz", buzzNumber);
		model.addAttribute("fizzbuzz", fizzbuzzNumber);
		
		return "fizzbuzz/result";
		
	}

}
