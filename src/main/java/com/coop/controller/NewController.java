package com.coop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coop.dao.JdbcDao;
import com.coop.model.AddPayee;
import com.coop.model.MakeTransfer;

@Controller
public class NewController {
	
	@Autowired
	JdbcDao dao;
	
	@RequestMapping(value="/addPayee", method=RequestMethod.POST)
	public ModelAndView showpayeeform() {
		return new ModelAndView("payeeForm");
	}
	
	@RequestMapping(value="/addpayee1", method=RequestMethod.POST)
	public ModelAndView addpayee(@ModelAttribute() AddPayee ap) {
		int accno = 100000001;
		ap.setGa_accno(accno);
		System.out.println("Hello");
		int i = dao.addpayee(ap);
		if(i==1)
		{
			return new ModelAndView("index");
		}
		else
		{
			return new ModelAndView("error");
		}
		
	}

}
