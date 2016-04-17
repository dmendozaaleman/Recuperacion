package com.mendoza.arredondo.daniel.estadosdeanimo;

public class PrototipoBalon extends Balon implements Clonable{

	@Override
	public Object clonar() {
		// TODO Auto-generated method stub
		Balon bal  = new Balon();
		
		bal.setColor(this.getColor());
		bal.setMedida(this.getMedida());
		return bal;
	}
}
