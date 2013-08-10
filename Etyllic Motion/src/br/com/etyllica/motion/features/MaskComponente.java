package br.com.etyllica.motion.features;

import br.com.etyllica.linear.Ponto2D;

public class MaskComponente extends Componente{

	boolean[][] mask;
	
	public MaskComponente(int w, int h){
		super(w,h);
		
		mask = new boolean[w][h];
		
	}
	
	protected void resetMask(){
		
		int w = mask.length; 
		int h = mask.length;
		
		for(int j=0;j<h;j++){
			
			for(int i=0;i<w;i++){
				mask[i][j] = false;
			}
			
		}
	}
	
	@Override
	public void addLogic(Ponto2D p){
		mask[(int)p.getX()][(int)p.getY()] = true;
	}
				
}
