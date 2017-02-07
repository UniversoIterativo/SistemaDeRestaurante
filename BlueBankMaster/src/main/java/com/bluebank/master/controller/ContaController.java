package com.bluebank.master.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluebank.master.model.Conta;
import com.bluebank.master.service.ContaService;


@Controller
public class ContaController {
	
	private ContaService contaService;
	
	@Autowired(required=true)
	@Qualifier(value="contaService")
	public void setContaService(ContaService cs){
		this.contaService = cs;
	}
	
	@RequestMapping(value = "/contas", method = RequestMethod.GET)
	public String listContas(Model model) {
		model.addAttribute("conta", new Conta());
		model.addAttribute("listContas", this.contaService.listContas());
		return "conta";
	}
	
	//For add and update person both
	@RequestMapping(value= "/conta/add", method = RequestMethod.POST)
	public String addConta(@ModelAttribute("conta") Conta c){
		
		if(c.getId() == 0){
			//new person, add it
			this.contaService.addConta(c);
		}else{
			//existing person, call update
			this.contaService.updateConta(c);
		}
		
		return "redirect:/contas";
		
	}
	
	@RequestMapping("/conta/remove/{id}")
    public String removeConta(@PathVariable("id") int id){
		
        this.contaService.removeConta(id);
        return "redirect:/contas";
    }
 
    @RequestMapping("/conta/edit/{id}")
    public String editConta(@PathVariable("id") int id, Model model){
        model.addAttribute("conta", this.contaService.getContaById(id));
        model.addAttribute("listContas", this.contaService.listContas());
        return "conta";
    }
    
    @RequestMapping("/conta/origem")
    public String buscarContaOrigem(@ModelAttribute("conta") Conta c, Model model){
        Conta conta = this.contaService.getContaByAgenciaNumeroCPF(c);
        model.addAttribute("conta", conta);
        return "conta";
    }
    
    @RequestMapping("/conta/destino")
    public String buscarContaDestino(@ModelAttribute("conta") Conta c, Model model){
        Conta conta = this.contaService.getContaByAgenciaNumero(c);
        model.addAttribute("conta", conta);
        return "conta";
    }

	@RequestMapping(value= "/conta/popular", method = RequestMethod.GET)
	public String popularConta(){
			
		Conta conta1 = new Conta();
		conta1.setAgencia("123-4");
		conta1.setNumero("123456-7");
		conta1.setCpf("123.456.789-90");
		conta1.setSaldo(new BigDecimal("1980.00"));
			
		Conta conta2 = new Conta();
		conta2.setAgencia("223-4");
		conta2.setNumero("223456-7");
		conta2.setCpf("223.456.789-90");
		conta2.setSaldo(new BigDecimal("2980.00"));
			
		Conta conta3 = new Conta();
		conta3.setAgencia("323-4");
		conta3.setNumero("323456-7");
		conta3.setCpf("323.456.789-90");
		conta3.setSaldo(new BigDecimal("3980.00"));
			
		Conta conta4 = new Conta();
		conta4.setAgencia("423-4");
		conta4.setNumero("423456-7");
		conta4.setCpf("423.456.789-90");
		conta4.setSaldo(new BigDecimal("4980.00"));
			
		Conta conta5 = new Conta();
		conta5.setAgencia("523-4");
		conta5.setNumero("523456-7");
		conta5.setCpf("523.456.789-90");
		conta5.setSaldo(new BigDecimal("5980.00"));

		Conta conta6 = new Conta();
		conta6.setAgencia("623-4");
		conta6.setNumero("623456-7");
		conta6.setCpf("623.456.789-90");
		conta6.setSaldo(new BigDecimal("6980.00"));

		Conta conta7 = new Conta();
		conta7.setAgencia("723-4");
		conta7.setNumero("723456-7");
		conta7.setCpf("723.456.789-90");
		conta7.setSaldo(new BigDecimal("7980.00"));
			
		this.contaService.addConta(conta1);
		this.contaService.addConta(conta2);
		this.contaService.addConta(conta3);
		this.contaService.addConta(conta4);
		this.contaService.addConta(conta5);
		this.contaService.addConta(conta6);
		this.contaService.addConta(conta7);
			
		return "redirect:/";
			
	}	
    
}
