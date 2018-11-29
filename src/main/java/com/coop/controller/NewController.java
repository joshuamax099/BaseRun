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
import com.coop.model.FlagStatus;
import com.coop.model.TransferDetails;

@Controller
public class NewController {
	
	@Autowired
	JdbcDao dao;
	
	@RequestMapping(value="/payeeDash", method=RequestMethod.POST)
	public ModelAndView showpayeedash() {
		String accno = "100000002";//get through session
		ModelAndView mv = null;
		FlagStatus reg = dao.validateBalance(accno);
		//modified code
		if (null != reg) {
			System.out.println("logtest4");
			//HttpSession session = request.getSession(true);
			String getbalance = dao.getbalancenow(accno);
			System.out.println(getbalance);
			System.out.println(reg.getGa_transfer_amount());
			int newbal = Integer.parseInt(getbalance) + Integer.parseInt(reg.getGa_transfer_amount());
			System.out.println(newbal);
			dao.updatenewbalance(accno,newbal);
			mv = new ModelAndView("payeeDashboard");
			
			return mv;
		} else {
			System.out.println("logTest5");
			return new ModelAndView("payeeDashboard");
		}
		
	}
	
	@RequestMapping(value="/addPayee", method=RequestMethod.POST)
	public ModelAndView showpayeeform() {
		return new ModelAndView("payeeForm");
	}
	@RequestMapping(value="/makeTransfer", method=RequestMethod.POST)
	public ModelAndView makeTransfer() {
		return new ModelAndView("paymentDashboard");
	}
	@RequestMapping(value="/neftTransfer", method=RequestMethod.POST)
	public ModelAndView neftTransfer() {
		return new ModelAndView("transferForm");
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
		String accno = "100000002";
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
	@RequestMapping(value="/transferAmount", method=RequestMethod.POST)
	public ModelAndView transfer(@ModelAttribute() TransferDetails ap) {
		//session.getAttribute("user"); 
		//ap.setGa_sender_accno(User.getUname);
		ap.setGa_sender_accno("100000002");
		ap.setGa_transaction_no("1");
		FlagStatus ap1 = new FlagStatus();
		ap1.setGa_transaction_no(ap.getGa_transaction_no());
		ap1.setGa_sender_accno(ap.getGa_sender_accno());
		ap1.setGa_receiver_accno(ap.getGa_receiver_accno());
		ap1.setGa_transfer_amount(ap.getGa_transfer_amount());
		ap1.setGa_flag_status("1");
		System.out.println("Hello");
		String ano = ap.getGa_sender_accno();
		int i = dao.addtransactionlog(ap);
		if(i==1)
		{
			int j = dao.addflagstatus(ap1);
			if(j==1)
			{
				System.out.println("Falcon1");
				String getbalance = dao.getbalancenow(ano);
				int newbal = Integer.parseInt(getbalance) - Integer.parseInt(ap1.getGa_transfer_amount());
				String newbal1 = String.valueOf(newbal);
				System.out.println(newbal1);
				int k = dao.updatebal(newbal1,ano);
				if(k == 1)
				{
					
					System.out.println("HelloPrbht");
					return new ModelAndView("index");
				}
				else
				{
					return new ModelAndView("error");
				}
			}
			else
			{
				return new ModelAndView("error");
			}
		}
		else
		{
			return new ModelAndView("error");
		}
		
	}

}
