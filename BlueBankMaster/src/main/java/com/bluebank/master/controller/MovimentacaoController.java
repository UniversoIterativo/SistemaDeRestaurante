package com.bluebank.master.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluebank.master.model.Conta;
import com.bluebank.master.model.Movimentacao;
import com.bluebank.master.model.TipoMovimentacao;
import com.bluebank.master.service.ContaService;
import com.bluebank.master.service.MovimentacaoService;


@Controller
public class MovimentacaoController {
	
	private MovimentacaoService movimentacaoService;
	private ContaService contaService;
	
	@Autowired(required=true)
	@Qualifier(value="movimentacaoService")
	public void setMovimentacaoService(MovimentacaoService ms){
		this.movimentacaoService = ms;
	}
	
	@Autowired(required=true)
	@Qualifier(value="contaService")
	public void setContaService(ContaService cs){
		this.contaService = cs;
	}
	
	@RequestMapping(value = "/movimentacoes", method = RequestMethod.GET)
	public String listMovimentacoes(Model model) {
		model.addAttribute("movimentacao", new Movimentacao());
		model.addAttribute("conta", new Conta());
		model.addAttribute("listMovimentacoes", this.movimentacaoService.listMovimentacoes());
		model.addAttribute("listContas", this.contaService.listContas());
		return "movimentacao";
	}
	
	@RequestMapping(value= "/movimentacao/add", method = RequestMethod.POST)
	public String addMovimentacao(@ModelAttribute("movimentacaoService") Movimentacao m, BindingResult result){
		
		if(m.getId() == 0){
			Conta conta = contaService.getContaById(1);
			m.setConta(conta);
			this.movimentacaoService.addMovimentacao(m);
		}else{
			this.movimentacaoService.updateMovimentacao(m);
		}
		return "redirect:/movimentacoes";
	}
	
	@RequestMapping(value = "/transferencia", method = RequestMethod.GET)
	public String transferencia() {
		return "movimentacao";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value= "/transferir", method = RequestMethod.POST)
	public String transferir(
			@RequestParam("origemAgencia") String origemAgencia, 
			@RequestParam("origemNumero") String origemNumero, 
			@RequestParam("origemCPF") String origemCPF, 
			@RequestParam("destinoAgencia") String destinoAgencia, 
			@RequestParam("destinoNumero") String destinoNumero, 
			@RequestParam("valor") String valor, Model model){
		
		BigDecimal creditar = new BigDecimal(valor);
		
		// Busca a conta de origem
		Conta origem = new Conta();
		origem.setAgencia(origemAgencia);
		origem.setNumero(origemNumero);
		origem.setCpf(origemCPF);
		Conta contaOrigem = this.contaService.getContaByAgenciaNumeroCPF(origem);
		if(contaOrigem != null){
			// Instancia uma movimentacao de débito
			Movimentacao d = new Movimentacao();
			d.setTipo(TipoMovimentacao.DEBITO);
			d.setConta(contaOrigem);
			d.setValor(creditar);
			// Busca a conta de destino
			Conta destino = new Conta();
			destino.setAgencia(destinoAgencia);
			destino.setNumero(destinoNumero);
			Conta contaDestino = this.contaService.getContaByAgenciaNumero(destino);
			BigDecimal saldo = contaDestino.getSaldo();
			saldo = saldo.subtract(creditar);
			if(saldo.compareTo(creditar) > 0){
				if(contaDestino != null){
					// Instancia uma movimentacao de débito
					Movimentacao c = new Movimentacao();
					c.setTipo(TipoMovimentacao.CREDITO);
					c.setConta(contaDestino);
					c.setValor(creditar);
					// Envia as movimentacoes para o service
					this.movimentacaoService.transferir(d, c);
				} else {
					model.addAttribute("msg", "Erro com a Conta de Destino!");
					return "redirect:/";
				}
			} else {
				model.addAttribute("msg", "Saldo Insuficiente!");
				return "redirect:/";
			}
		} else {
			model.addAttribute("msg", "Erro com a Conta de Origem!");
			return "redirect:/";
		}

        return "redirect:/";
	}
	
	@RequestMapping("/movimentacao/remove/{id}")
    public String removeMovimentacao(@PathVariable("id") int id){
        this.movimentacaoService.removeMovimentacao(id);
        return "redirect:/movimentacoes";
    }
 
    @RequestMapping("/movimentacao/edit/{id}")
    public String editMovimentacao(@PathVariable("id") int id, Model model){
        model.addAttribute("conta", this.movimentacaoService.getMovimentacaoById(id));
        model.addAttribute("listMovimentacaos", this.movimentacaoService.listMovimentacoes());
        return "movimentacao";
    }
	
}
