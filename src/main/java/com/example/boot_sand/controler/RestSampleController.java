package com.example.boot_sand.controler;

import java.io.IOException;
import java.io.Writer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.boot_sand.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Controller
@RestController // Bodyをレスポンスとする
public class RestSampleController {
	static Logger logger = LoggerFactory.getLogger(RestSampleController.class);

	@RequestMapping(value="/test", method=RequestMethod.GET, headers="Accept=application/*", params="id=002")
	public String test() {
		return "test";
	}

	// リクエストメソッドの設定、必須パラメータの取得
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Item getItemList(@RequestParam("userId") String userId, // 必須でないときは、引数にrequired=falseを追加
	@RequestParam("seq") String seq) {
		return new Item();
	}
	
	// 戻り値をそのままレスポンスのボディの内容とする
	@RequestMapping("/directWrite")
	public void directWrite(@RequestBody String body, Writer writer) throws IOException {
	   writer.write(body);
	}

	// View に対して渡す Model も同時に返す
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(ModelAndView mav) {
	    mav.addObject("model", "model");
	    mav.setViewName("test");
	    return mav;
	}
}

