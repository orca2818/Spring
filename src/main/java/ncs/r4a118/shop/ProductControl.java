package ncs.r4a118.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductControl {

	@Autowired
	private ProductDBManage manage;

	@RequestMapping("/select")
	public String select(Model model) {
		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "SelectAll");
		model.addAttribute("productList", manage.select());
		return "/shop/pro_select";
	}

	@RequestMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "Insert Product");
		model.addAttribute(new Product());
		return "/shop/pro_insert";
	}

}
