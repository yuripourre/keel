package br.com.etyllica.motion.filter.color.skin;

import br.com.etyllica.motion.filter.SoftPixelStrategy;
import br.com.etyllica.motion.filter.color.ColorStrategy;
import br.com.etyllica.motion.filter.color.SimpleToleranceStrategy;
import br.com.etyllica.util.EtyllicaMath;

/**
 * Based on: Jure Kovač, Peter Peer, and Franc Solina - Human Skin Colour Clustering for Face Detection
 *
 */
public class SkinColorKovacStrategy extends SimpleToleranceStrategy implements SoftPixelStrategy {
		
	public SkinColorKovacStrategy() {
		super();
	}
	
	public SkinColorKovacStrategy(int tolerance) {
		super(tolerance);
	}

	@Override
	public boolean validateColor(int rgb) {
		return isSkin(rgb, tolerance);
	}
	
	public static boolean isSkin(int rgb) {
		return isSkin(rgb, 0);
	}
	
	public static boolean isSkin(int rgb, int tolerance) {
		
		final int R = ColorStrategy.getRed(rgb);
		final int G = ColorStrategy.getGreen(rgb);
		final int B = ColorStrategy.getBlue(rgb);
		
		final int R_MIN = 95-tolerance/2;//Default is 95
		final int G_MIN = 40-tolerance/3;//Default is 40
		final int B_MIN = 20-tolerance/4;//Default is 20
		
		final double RG_MOD = EtyllicaMath.diffMod(R, G);
		
		boolean firstRule = (R > R_MIN && G > G_MIN && B > B_MIN) &&
				             EtyllicaMath.max(R,G,B) - EtyllicaMath.min(R,G,B) > 15 &&
				             RG_MOD > 15 && 
				             R > G && R > B;
		
		boolean secondRule = R > 220 && G > 210 && B > 170 &&
							 RG_MOD <= 15 && R > B && G > B;
		
		return firstRule || secondRule;
	}

	@Override
	public boolean strongValidateColor(int baseColor, int rgb) {
		return validateColor(rgb);
	}
	
}
