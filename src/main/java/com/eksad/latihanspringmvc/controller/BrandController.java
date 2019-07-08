package com.eksad.latihanspringmvc.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;

import groovy.transform.ThreadInterrupt;
import javassist.NotFoundException;


@Controller
@RequestMapping("/brand")
public class BrandController {
	
	
	
	//panggilDAO
	@Autowired
	BrandRepositoryDAO brandrepositorydao;
	
	@RequestMapping("/")
	public String index(Model model1) 
	{
		
		List<Brand> brandlist = brandrepositorydao.findAll();
		
		model1.addAttribute("Brandlist",brandlist);
		
		return "brandlist";
	}
	
	//SAVE
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) 
	{
		brandrepositorydao.save(brand);
		return "redirect:/brand/";
	}
	
	//Add
	@RequestMapping("/addbrand")
	public String createBrand(Model model) 
	{
		Brand brand = new Brand();
		
		model.addAttribute("brand", brand);
		
		return "addbrand";
	}
	
	//Edit/update
	@RequestMapping(value ="edit/{id}", method =  RequestMethod.GET)
	public String editBrand(@PathVariable("id") Long id, Model model) 
	{
		Brand brand = brandrepositorydao.findOne(id);
		model.addAttribute("brand", brand);
		return "addbrand";
	}
	
	//Delete
	@RequestMapping(value="delete/{id}",method = RequestMethod.GET)
    public String deleteBrand(@PathVariable ("id") Long id) {
        Brand brand = brandrepositorydao.getOne(id);
        if(brand==null)
        {
        	throw new EntityNotFoundException("entity.brand.NotFound");
        }
        brandrepositorydao.delete(brand);
        return "redirect:/brand/";
    }

	
}
