package com.mendoza.arredondo.daniel.estadosdeanimo;

public class Balon {
		
	private static Balon balon;
	private String color;
	private int medida;
	
	
	public Balon() {
		// TODO Auto-generated constructor stub
		this.color = "Blanco";
		this.medida = 5;
	}

	
	public static Balon getBalon(){
		//Nos aseguramos que se crea un solo objeto de tipo Balon 
		if(balon == null){
			balon = new Balon();
		}
		return balon;
	}
	public static void setBalon(Balon balon) {
		Balon.balon = balon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMedida() {
		return medida;
	}

	public void setMedida(int medida) {
		this.medida = medida;
	}
	
	
	
}
