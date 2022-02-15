package br.imd.vacinacao.util;

public class VacinacaoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VacinacaoException() {
		super();
	}
	
	public VacinacaoException(String msg, Throwable thr) {
		super(msg,thr);
	}
	
	public VacinacaoException(String msg) {
		super(msg);
	}
	
	public VacinacaoException(Throwable thr) {
		super(thr);
	}

}
