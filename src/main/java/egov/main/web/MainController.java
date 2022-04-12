package egov.main.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do")
	public String main(HttpServletRequest request, ModelMap model) {
//		HttpServletRequest - 사용자의 요청을 받을 수 있음, 로그인 등
//		ModelMap - 사용자에게 데이터를 전달

		return "main/main";
	}

}
