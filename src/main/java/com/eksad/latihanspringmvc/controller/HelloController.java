package com.eksad.latihanspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController 
{
	@RequestMapping("/hello")
	@ResponseBody //buat nampilin di web nya
	
	public String sayHello()
	{
		return "Hello World";
	}
	
	//pake parameter, jadi wajib untuk diisi
	@RequestMapping("/myName")
	@ResponseBody //buat nampilin di web nya
	
	public String myName(@RequestParam String myName)
	{
		return "Hello" +" " +  myName;
	}
	
	// pake path variable, semua langsung keluar tanpa pake param + ? 
	@RequestMapping("/namaSaya/{myName}")
	@ResponseBody //buat nampilin di web nya
	
	public String namaSaya(@PathVariable String myName)
	{
		return "Hello" +" " +  myName;
	}
	
	//request melalui domain source
	//
	@RequestMapping("/toGetLink")
	@ResponseBody //buat nampilin di web nya
	public String toGoogle()
	{
		return "<a href='https://www.youtube.com' target='_blank'> Klik disini menuju Youtube</a>"
				+ "</br> <a href='https://www.google.com' target='_blank'> Klik disini menuju Google </a>";
		//target='_blank' : untuk menampilkan di tab baru
	}
	
	
}
