package com.coop.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coop.dao.JdbcDao;
import com.coop.model.AddPayee;

@Controller
public class NewController {
	
	@Autowired
	JdbcDao dao;
	
	@RequestMapping(value="/payeeDash", method=RequestMethod.POST)
	public ModelAndView showpayeedash() {
		return new ModelAndView("payeeDashboard");
	}
	
	@RequestMapping(value="/addPayee", method=RequestMethod.POST)
	public ModelAndView showpayeeform() {
		return new ModelAndView("payeeForm");
	}
	
	@RequestMapping(value="/viewPayee", method=RequestMethod.POST)
	public ModelAndView viewemp(){  
        List<AddPayee> list=dao.getallpayees();  
        return new ModelAndView("viewPayeeDash","list",list);  
    }
	@RequestMapping(value="/editPayee/{id}")
	public ModelAndView editpayee(@PathVariable String id) {
		AddPayee emp=dao.getPayeeById(id);  
        return new ModelAndView("payeeeditform","command",emp);
	}
	@RequestMapping(value="/deletePayee/{id}")
	public ModelAndView deletepayee(@PathVariable int id) {
		System.out.println(id);
		 dao.deletePayee(id);  
	     return new ModelAndView("payeeDashboard"); 
	}
	
	 @RequestMapping(value="/editsave", method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") AddPayee emp){  
		    System.out.println("Helllo1");
		    String payee_ano = emp.getGa_payee_accno();
		    System.out.println(payee_ano);
	        dao.update(emp,payee_ano);
	        System.out.println("Helllo2");
	        return new ModelAndView("payeeDashboard");  
	    } 
	
	@RequestMapping(value="/addpayee1", method=RequestMethod.POST)
	public ModelAndView addpayee(@ModelAttribute() AddPayee ap) {
		String accno = "100000001";
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
