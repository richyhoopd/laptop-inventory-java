
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class archivo {
	File inv = new File("inventario.txt");
	FileWriter accesoEscribir;
	PrintWriter escribeLinea;
	FileReader accesoLeer;
	BufferedReader leeLinea;
	float precioFinal=0, precioCompra, precioIVA;
	String aux1, aux2, aux3, aux4, aux5, aux6;

	public void calculo(String linea4) {
		precioIVA = Integer.parseInt (linea4);
		precioCompra = Integer.parseInt (linea4);
		precioFinal=(float) (precioIVA +(precioCompra*0.16));
	}
	
	public void escribir(String linea1, String linea2, String linea3, String linea4, String linea5, String linea5a, String linea5b) {
		if(!inv.exists()) {
			try {
				inv.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
			try {
				accesoEscribir = new FileWriter(inv, true);
				escribeLinea = new PrintWriter(accesoEscribir);
				escribeLinea.println(linea1+"\n"+linea2+"\n"+linea3+"\n$"+linea4+"\n"+linea5+"   "+linea5a+"   "+linea5b+"\n"+precioFinal);
				escribeLinea.close();
				accesoEscribir.close();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
	}

	
	public void mostrar() {
		try {
			if(!inv.exists()) {
				JOptionPane.showMessageDialog(null, "El inventario esta vacio");
			} else {
				accesoLeer = new FileReader(inv);
				leeLinea = new BufferedReader(accesoLeer);
				do {
					aux1=leeLinea.readLine();aux2=leeLinea.readLine();aux3=leeLinea.readLine();aux4=leeLinea.readLine(); aux5=leeLinea.readLine(); aux6=leeLinea.readLine();
					if(aux1!=null) {
						JOptionPane.showMessageDialog(null, "Marca: "+aux1+"\nModelo: "+aux2+"\nPantalla: "+aux3+"\nPrecio compra"+aux4+"\nPuertos: "+aux5+"\nPrecio en Venta: $"+aux6);
					}
				}while(aux6!=null);
				accesoLeer.close();
				leeLinea.close();
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public void busqueda() {
		try {
			if(!inv.exists()) {
				JOptionPane.showMessageDialog(null, "El inventario esta vacio");
				inv.createNewFile();
			} 
				String opmarca = JOptionPane.showInputDialog("Ingrese marca de la laptop:");
				accesoLeer = new FileReader(inv);
				leeLinea = new BufferedReader(accesoLeer);
				do {
					System.out.println("hola");
					aux1=leeLinea.readLine(); 
					aux2=leeLinea.readLine(); 
					aux3=leeLinea.readLine();
					aux4=leeLinea.readLine();
					aux5=leeLinea.readLine();
					aux6=leeLinea.readLine();

					if((aux1!=null)&&(aux1.equals(opmarca))) {
						JOptionPane.showMessageDialog(null, "Marca: "+aux1+"\nModelo: "+aux2+"\nPantalla: "+aux3+"\nPrecio compra"+aux4+"\nPuertos: "+aux5+"\nPrecio en Venta: $"+aux6);
					}
				}while(aux5!=null);
				accesoLeer.close();
				leeLinea.close();
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void borrarArchivo() {
		if(inv.exists()) {
			inv.delete();
		}
	} 
}
