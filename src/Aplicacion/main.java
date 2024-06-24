package Aplicacion;

import java.io.IOException;
import java.util.Scanner;
import Modelos.Moneda;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
			Scanner sc=new Scanner(System.in);
			int opcion;
			menu();
			opcion=sc.nextInt();
			opcion=validarOpcion(opcion);
			while(opcion!=0){
				Moneda transaccion=new Moneda();
				
				System.out.println("ingrese moneda base");
				String codBase=sc.nextLine().toUpperCase();
				while(transaccion.validarCod(codBase)==-1) {
					System.out.println("Reingrese moneda base");
					codBase=sc.nextLine().toUpperCase();
				}
				
				System.out.println("ingrese moneda a convertir");
				String codBuscar=sc.nextLine().toUpperCase();
				while(transaccion.validarCod(codBuscar)==-1) {
					System.out.println("Reingrese moneda a convertir");
					codBuscar=sc.nextLine().toUpperCase();
				}
				
				System.out.println("Ingrese monto a convertir");
				float monto=sc.nextFloat();
				while(monto<0) {
					System.out.println("Reingrese monto a convertir");
					monto=sc.nextFloat();
				}
				
				System.out.println(codBase+" "+monto+" ---- "+codBuscar+" "+transaccion.convertir(codBase, codBuscar, monto));
				
				menu();
				opcion=sc.nextInt();
				opcion=validarOpcion(opcion);
			}
		}


	public static void menu() {
		System.out.println("--------------------------CONVERSOR DE MONEDAS--------------------------");
		System.out.println("Ingrese una opcion para continuar: \n1.Convertir\n2.Historial de conversiones\n0.Salir");
	}
	public static int validarOpcion(int op) {
		Scanner sc=new Scanner(System.in);
		while(op<0||op>2) {
			System.out.println("Opcion INVALIDA, reIngrese la opcion");
			op=sc.nextInt();
		}
		return op;
	}
}
