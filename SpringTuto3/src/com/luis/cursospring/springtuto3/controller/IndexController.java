package com.luis.cursospring.springtuto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @RequestMapping
 * Acepta una peticion http y nos resuelva un nombe logico para que el dispatcher
 * servlet se encargue de el resto
 */
@Controller
public class IndexController {
	
	
	@RequestMapping("/")
	public String showIndex(){
		System.out.println("call showIndex()");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout(){
		System.out.println("call showAbout()");
		return "about";
	}
	
	
	
}
