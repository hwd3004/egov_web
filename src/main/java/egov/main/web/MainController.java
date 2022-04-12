package egov.main.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egov.main.service.MainService;

@Controller
public class MainController {

	@Resource(name = "MainService")
	MainService mainService;

	@RequestMapping(value = "/main.do")
	public String main(HttpServletRequest request, ModelMap model) {
//		HttpServletRequest - 사용자의 요청을 받을 수 있음, 로그인 등
//		ModelMap - 사용자에게 데이터를 전달

		return "main/main";
	}

	@RequestMapping(value = "/main2.do")
	public String main2(HttpServletRequest request, ModelMap model) {

		return "main/main2";
	}

//	@RequestMapping(value = "/main3.do", method = RequestMethod.POST)
	@RequestMapping(value = "/main3.do")
	public String main3(@RequestParam("pw") String pw, HttpServletRequest request, ModelMap model) {

		int userNo = Integer.parseInt(request.getParameter("userNo").toString());

		String id = request.getParameter("id").toString();

		if (id.equals("asd")) {
			model.addAttribute("userid", id);
		} else {
			model.addAttribute("userid", "잘못된 입력");
		}

		userNo += 5;

		model.addAttribute("userNo", userNo);

		return "main/main3";
	}

	@RequestMapping(value = "/main4/{userNo}.do")
	public String main4(@PathVariable String userNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("userNo", userNo);

		return "main/main3";
	}

	@RequestMapping(value = "/main5.do")
	public String main5(HttpServletRequest request, ModelMap model) throws Exception {
		String userid = "";

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		resultMap = mainService.selectMain(paramMap);

		userid = resultMap.get("user_id").toString();

		model.addAttribute("serverId", userid);

		return "main/main3";
	}

}
