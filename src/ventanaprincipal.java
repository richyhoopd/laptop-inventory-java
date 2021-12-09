import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ventanaprincipal extends JFrame implements ActionListener{
	
	
	JPanel ventana = new JPanel();
	JLabel ltitulo, ltexto, lmarca, lmodelo, lpan, lprecio, lpuerto, logo, l1, l2, l3, l4;
	JTextField modelo, precio;
	JRadioButton pan13, pan15, pan17;
	JComboBox<String> marca;
	ButtonGroup pantalla;
	JCheckBox hdmi, vga, dvi;
	JButton guardar, salir;
	JMenuBar bar;
	JMenu mostrar, buscar, limpiar;
	JMenuItem laptops, pmarca, archivo;
	String linea1, linea2, linea3, linea4, linea5, linea5a, linea5b;
	archivo inv = new archivo();
	
	public ventanaprincipal() {
		this.setSize(800,600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Inventario Laptops");
		setLocationRelativeTo(null); 
		setResizable(false); 
		etiquetas();
		componentes();
		barramenu();
		add();

	}
	
	public void etiquetas() {
		ventana.setLayout(null);
		this.getContentPane().add(ventana); 
		ltitulo = new JLabel("Inventario de Laptop"); 
		ltitulo.setBounds(50, 30, 350,30); ltitulo.setFont(new java.awt.Font("Arial", 1,30 ));
		ltexto  = new JLabel("Resgistrar laptop en el inventario"); 
		ltexto.setBounds(50,70,350,30); ltexto.setFont(new java.awt.Font("Arial", 1,20));
		lmarca = new JLabel("Marca:");
		lmarca.setBounds(50,150,200,30); lmarca.setFont(new java.awt.Font("Arial", 0, 20));
		lmodelo = new JLabel("Modelo:");
		lmodelo.setBounds(50,200,150,30); lmodelo.setFont(new java.awt.Font("Arial", 0, 20));
		lpan = new JLabel("Tamaño de la pantalla:");
		lpan.setBounds(50,250,250,30); lpan.setFont(new java.awt.Font("Arial", 0, 20));
		lprecio = new JLabel("Precio:");
		lprecio.setBounds(50,320,150,30); lprecio.setFont(new java.awt.Font("Arial", 0, 20));
		lpuerto = new JLabel("Puertos: "); 
		lpuerto.setBounds(50,370,150,30); lpuerto.setFont(new java.awt.Font("Arial", 0, 20));
		logo = new JLabel(new ImageIcon("iconoLap.png"));
		logo.setBounds(450,0,300,300);
		l1 = new JLabel("Registra en el inventario computadoras portatiles");
		l1.setBounds(410,280,450,30); l1.setFont(new java.awt.Font("Arial", 0,15));
		l2 = new JLabel("revisa el inventario y precio de venta al publico");
		l2.setBounds(410,300,450,30); l2.setFont(new java.awt.Font("Arial", 0,15));
		l3 = new JLabel("(El precio de venta se genera aumentando");
		l3.setBounds(410,320,450,30); l3.setFont(new java.awt.Font("Arial", 0,15));
		l4 = new JLabel("%16 del precio ingresado.)");
		l4.setBounds(410,340,450,30); l4.setFont(new java.awt.Font("Arial", 0,15));
	}
	
	
	public void componentes() {
		marca =  new JComboBox<String>();
		marca.setBounds(125,150,100,30);
		marca.addItem("Asus"); marca.addItem("Lenovo"); marca.addItem("Dell"); marca.addItem("HP"); marca.addItem("Acer");
		
		
		marca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(marca.getSelectedItem()=="Asus") {
					linea1=(String) marca.getSelectedItem();
				}
				if(marca.getSelectedItem()=="Lenovo") {
					linea1=(String) marca.getSelectedItem();
				}
				if(marca.getSelectedItem()=="Dell") {
					linea1=(String) marca.getSelectedItem(); 
				}
				if(marca.getSelectedItem()=="HP") {
					linea1=(String) marca.getSelectedItem();
				}
				if(marca.getSelectedItem()=="Acer") {
					linea1=(String) marca.getSelectedItem(); 
				}
			}	
		});
		
		modelo = new JTextField(50);
		modelo.setBounds(135,200,100,30);
				
		pan13 =  new JRadioButton("13\"");
		pan13.setBounds(50,280,80,30);
		pan15 =  new JRadioButton("15\"");
		pan15.setBounds(150,280,80,30);
		pan17 =  new JRadioButton("17\"");
		pan17.setBounds(250,280,80,30);
		
		ManejadorCarrera pan = new ManejadorCarrera();
		pan13.addItemListener((ItemListener) pan); pan15.addItemListener(pan); pan17.addItemListener(pan); 

		
		pantalla = new ButtonGroup();
		pantalla.add(pan13); pantalla.add(pan15); pantalla.add(pan17);
		
		precio = new JTextField(50);
		precio.setBounds(125,320,100,30);
				
		hdmi = new JCheckBox("HDMI"); 
		hdmi.setBounds(50,400,100,50);
		vga = new JCheckBox("VGA"); 
		vga.setBounds(150,400,100,50);
		dvi = new JCheckBox("DVI");
		dvi.setBounds(250,400,100,50);
		
		ManejadorCheckBox var = new ManejadorCheckBox();
		hdmi.addItemListener((ItemListener) var); 
		vga.addItemListener(var); 
		dvi.addItemListener(var); 
		
		guardar = new JButton(); ImageIcon iguardar=new ImageIcon("guardar.png"); 
		guardar.setIcon(iguardar); guardar.setBounds(50,470,60,60);
		salir = new JButton(); ImageIcon isalir=new ImageIcon("salir.png"); 
		salir.setIcon(isalir); salir.setBounds(150,470,60,60);
		
		ManejadorBoton manejador = new ManejadorBoton();
		guardar.addActionListener(manejador);
		salir.addActionListener(manejador);

	}
	
	//Manejador Linea pantalla
	private class ManejadorCarrera implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			if(event.getSource()==pan13) {
				linea3=pan13.getText();
			}
			if(event.getSource()==pan15) {
				linea3=pan15.getText();
			}
			if(event.getSource()==pan17) {
				linea3=pan17.getText();
			}
		}
	}		
	
	//Manejador Linea puertos
	private class ManejadorCheckBox implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==hdmi) {
				linea5=hdmi.getText();  
			} else {
				linea5="   ";
			}

			if (e.getSource()==vga) {
				linea5a=vga.getText();
			} else {
				linea5a="   ";
			}
			if(e.getSource()==dvi) {
				linea5b=dvi.getText();
			} else {
				linea5b="   ";
			}

		}
	}
	
	//Manejador Boton
	private class ManejadorBoton implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==guardar) {
				linea2=modelo.getText();
				linea4=precio.getText();
				inv.calculo(linea4);
				inv.escribir(linea1, linea2, linea3, linea4, linea5, linea5a, linea5b);

			} else if(evento.getSource()==salir) {
				setVisible(false);
			} 		
		}
	}

	
	public void barramenu(){
		bar=new JMenuBar();
		setJMenuBar(bar);
		
		mostrar=new JMenu("Mostrar"); 
		limpiar=new JMenu("Limpiar"); 
		buscar=new JMenu("Buscar"); 
		
		bar.add(mostrar);bar.add(buscar); bar.add(limpiar); 
		
		laptops = new JMenuItem("Inventario de Laps");
		mostrar.add(laptops);
		laptops.addActionListener(this);
		
		pmarca = new JMenuItem("Por Marca");
		buscar.add(pmarca);
		pmarca.addActionListener(this);
		
		archivo = new JMenuItem("Inventario");
		limpiar.add(archivo);
		archivo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource()==laptops) {
            inv.mostrar();
        } 
        else if(e.getSource()==pmarca) {
        	inv.busqueda();
        }
        else if(e.getSource()==archivo) {
        	inv.borrarArchivo();
        }    
    }

	
	public void add() {
		ventana.add(ltitulo);
		ventana.add(ltexto);
		ventana.add(lmodelo);
		ventana.add(lmarca);
		ventana.add(lpan);
		ventana.add(lprecio);
		ventana.add(lpuerto);
		ventana.add(logo);
		ventana.add(marca);
		ventana.add(modelo);
		ventana.add(pan13);
		ventana.add(pan15);
		ventana.add(pan17);
		ventana.add(precio);
		ventana.add(hdmi);
		ventana.add(vga);
		ventana.add(dvi);
		ventana.add(guardar);
		ventana.add(salir);
		ventana.add(l1);
		ventana.add(l2);
		ventana.add(l3);
		ventana.add(l4);

	}
	

	
}
