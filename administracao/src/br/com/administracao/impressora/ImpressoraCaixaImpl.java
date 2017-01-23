package br.com.administracao.impressora;

import java.util.List;

import br.com.administracao.util.ImpressaoJAVA;

public class ImpressoraCaixaImpl implements ImpressoraCaixa {
	
	@Override
	public void impressoras() {
		ImpressaoJAVA impressaoDao = new ImpressaoJAVA();
		List<String> listarResultados = impressaoDao.retornaImpressoras();
		for(String i: listarResultados){
			System.out.println(i);
		}
	}
	
	@Override
	public void impressora(){
		ImpressaoJAVA impressaoDao = new ImpressaoJAVA();
		impressaoDao.detectaImpressoras("caixa");
	}
	
	@Override
	public void imprimir(String texto){
		ImpressaoJAVA impressaoDao = new ImpressaoJAVA();
		impressaoDao.imprime("CAIXA \n" + texto);
	}
}
