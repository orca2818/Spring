package ncs.r4a118.shop;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@RequestMapping("/insert_confirm")
	public String insert(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/shop/pro_insert";
		}
		manage.insert(product);
		return select(model);
	}

	@RequestMapping("/search")
	public String search(Product product, Model model) {
		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "Update Product");
		model.addAttribute("searchItem", manage.search(product));
		return "/shop/pro_update";
	}

	@RequestMapping(value = "/update", params = "update")
	public String update(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return search(product,model);
		}
		manage.update(product);
		return select(model);
	}


	@RequestMapping(value = "/update", params = "delete")
	public String update(Product product, Model model) {
		manage.delete(product);
		return select(model);
	}



}
