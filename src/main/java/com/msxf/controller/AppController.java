package com.example.controller;

import com.example.dto.AppDto;
import com.example.service.AppService;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@Autowired
	private AppService appService;


	@GetMapping("/")
	public String app(Model model) {
		model.addAttribute("apps", appService.listApps());
		return "app/app";
	}

	@GetMapping("/addApp")
	@ResponseBody
	public Result addApp(AppDto appParams) {
		if(StringUtils.isEmpty(appParams.getContent())){
			return Result.fail("content is not null !");
		}
		appParams.setInsertTime(System.currentTimeMillis());
		appParams.setUpdateTime(null);
		return Result.success(true);
	}

	@GetMapping("/updateApp")
	public Result updateApp(AppDto appParams) {
		appParams.setInsertTime(null);
		appParams.setUpdateTime(System.currentTimeMillis());
		appService.addApp(appParams);
		return Result.success(true);
	}

}
