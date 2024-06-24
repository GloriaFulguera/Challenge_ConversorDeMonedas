package Modelos;

import Conexion.ApiConsult;
import com.google.gson.Gson;

public class Moneda {
	String codigo;
	Object valor;
	
	public String ARS;
	public String BOB;
	public String BRL;
	public String CLP;
	public String COP;
	public String USD;
	public String EUR;
	public String THB;
	public String KRW;
	
	public Moneda(MonedaOmdb data) {
		this.codigo=data.base_code();
		this.valor=data.conversion_rates();
	}
	
	public Moneda() {
	}
	
	public String getValor(String codigo) {
		String valor="";
		codigo=codigo.toUpperCase();
		switch(codigo) {
		case "ARS":
			valor= this.ARS;
			break;
		case "BOB":
			valor= this.BOB;
			break;
		case "BRL":
			valor= this.BRL;
			break;
		case "CLP":
			valor= this.CLP;
			break;
		case "COP":
			valor= this.COP;
			break;
		case "USD":
			valor= this.USD;
			break;
		case "EUR":
			valor= this.EUR;
			break;
		case "THB":
			valor= this.THB;
			break;
		case "KRW":
			valor= this.KRW;
			break;
		default:
			System.out.println("Codigo de moneda INVALIDO");
			break;
		}
		return valor;
	}
	
	public float convertir(String codBase, String codConvertir, float monto) {
		ApiConsult req=new ApiConsult(codBase);
		
		String json=req.ApiResponse();
		Gson gson = new Gson();
		
		MonedaOmdb monedaRecord=gson.fromJson(json,MonedaOmdb.class);
		//Moneda monedaDatos=new Moneda(monedaRecord);
		//System.out.println("(ignore).valor de MonedaDatos: "+monedaDatos.getCodigo());
		
		Moneda monedaConvertir=gson.fromJson(monedaRecord.conversion_rates().toString(), Moneda.class);
		//System.out.println("(ignore)codigo base de MonedaConvertir: "+monedaConvertir.getValor(codConvertir));
		
		return convertirCalculo(monedaConvertir.getValor(codConvertir),monto);
	}
	
	private float convertirCalculo(String valorUnit, float monto) {
		return monto*(Float.parseFloat(valorUnit));
	}
	
	public int validarCod(String codigo) {
		int encontrado=1;
		codigo=codigo.toUpperCase();
		switch(codigo) {
		case "ARS":
		case "BOB":
		case "BRL":
		case "CLP":
		case "COP":
		case "USD":
		case "EUR":
		case "THB":
		case "KRW":
			break;
		default:
			System.out.println("Codigo de moneda INVALIDO");
			encontrado=-1;
			break;
		}
		return encontrado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public Object getValor() {
		return valor;
	}
}
