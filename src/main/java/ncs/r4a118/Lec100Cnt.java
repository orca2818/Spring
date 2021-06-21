package ncs.r4a118;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ncs.r4a118.shop.Product;

@Controller
public class Lec100Cnt {
	private static final String RESOURCE_NAME = "messages";
	private static ResourceBundle resource = ResourceBundle.getBundle(RESOURCE_NAME);

	@RequestMapping("/lec1")
	public String show(Model model) {
		//タイトル
		model.addAttribute("title1","Spring Boot");
		model.addAttribute("title2","Thymeleafについて");

		//オブジェクト
		var product = new Product(101,"チョコ",300,"１箱");
		model.addAttribute("product",product);

		//オブジェクトのリスト
		var producutList = new ArrayList<Product>();
		producutList.add(new Product(101,"チョコ",300,"１箱"));
		producutList.add(new Product(102,"ガム",100,"１箱"));
		producutList.add(new Product(103,"グミ",200,"１袋"));
		model.addAttribute("productList", producutList);

		//プロパティ
		model.addAttribute("msg",resource.getString("msg"));
		return "/lec1/lec101";
	}

	@RequestMapping("/lec1/input")
	public String input(Model model) {
		model.addAttribute(new Product());
		return "/lec1/lec102_input";
	}

	@RequestMapping("/lec1/result")
	public String result(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", "エラー");
			return "/lec1/lec102_input";
		}
		model.addAttribute("product", product);
		return "/lec1/lec102_result";
	}

	@RequestMapping("/")
	public String login() {
		return "/lec1/kanri_top";
	}

}
