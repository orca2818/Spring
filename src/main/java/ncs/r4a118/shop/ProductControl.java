package ncs.r4a118.shop;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductControl {

	@Autowired
	private ProductDBManage manage;
	@Autowired
	private HttpSession session;

	public static final String PHOTO_DIR = "D:\\R4A118\\R4A118_app\\www\\webshop\\img\\product";

	@RequestMapping("/select")
	public String select(Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}

		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "SelectAll");
		model.addAttribute("productList", manage.select());
		return "/shop/pro_select";
	}

	@RequestMapping("/insert")
	public String insert(Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}


		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "Insert Product");
		model.addAttribute(new Product());
		return "/shop/pro_insert";
	}

	@RequestMapping("/insert_confirm")
	public String insert(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Spring boot データベース");
			model.addAttribute("subTitle", "Insert Product");
			return "/shop/pro_insert";
		}
		int code = manage.insert(product);
		model.addAttribute("msg", DBControlMessage(code, product, "登録"));
		return select(model);
	}

	@RequestMapping("/search")
	public String search(Product product, Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}

		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "Update Product");
		model.addAttribute(manage.search(product));
		return "/shop/pro_update";
	}

	@RequestMapping(value = "/update", params = "update", method = RequestMethod.POST)
	public String update(@Valid Product product, BindingResult result, Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}

		if (result.hasErrors()) {
			model.addAttribute("title", "Spring boot データベース");
			model.addAttribute("subTitle", "Update Product");
			return "/shop/pro_update";
		}
		int code = manage.update(product);
		model.addAttribute("msg", DBControlMessage(code, product, "更新"));
		return select(model);
	}


	@RequestMapping(value = "/update", params = "delete", method = RequestMethod.POST)
	public String update(Product product, Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}

		int code = manage.delete(product);
		model.addAttribute("msg", DBControlMessage(code, product, "削除"));
		return select(model);
	}

	private String DBControlMessage(int resultCode, Product product, String controlString) {
		String msg = controlString + "できませんでした";
		if (resultCode > 0) {
			msg = String.format("商品名「%s」を%sしました", product.getName(), controlString);
		}
		return msg;
	}

	@RequestMapping("/photo")
	public String photo(Model model) {

		if (Objects.isNull(session.getAttribute("userInfo"))) {
			return "redirect:http://127.0.0.1:8080";
		}

		model.addAttribute("title", "Spring boot データベース");
		model.addAttribute("subTitle", "Photo Gallery");

		//ファイルクラスを使い写真が格納されているディレクトリを取得
		File directory = new File(PHOTO_DIR);

		//FileNameFilterでフィルタリングしたファイルの名前のリストを作成
		List<String> photoChunk = Arrays.asList(directory.list((dir, name) -> name.toLowerCase().matches(".+(.jpg|.png|.jpeg)$")));

		model.addAttribute("photoChunk", photoChunk);
		return "/shop/pro_photo";
	}

}
