package kz.tezdet.lessons.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	private static final Logger logger = Logger.getLogger(HelloController.class) ;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String printWelcome(Model model) {
		model.addAttribute("message", "Hello world!");
		logger.info("Hello Controller is invoked!");
		return "hello";
	}
}