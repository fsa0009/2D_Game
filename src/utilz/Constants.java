package utilz;

public class Constants {
	
	public static class Directions{
		public static final int LEFT  = 0 ; 
		public static final int UP    = 1 ; 
		public static final int RIGHT = 2 ; 
		public static final int DOWN  = 3 ; 

	}
	public static class EllieConstants {
		
		public static final int ELLIE_IDLE = 0; 
		public static final int ELLIE_SHOOT = 1; 
		public static final int ELLIE_RUN = 2; 
		public static final int ELLIE_DIE = 3;
		public static final int ELLIE_JUMP = 4; 
		public static final int ELLIE_FALL = 5;
		public static final int ELLIE_ATTACK_BOMB = 0; 


		public static int getSpriteAmount(int Player_Action) {
			
			switch(Player_Action) {
			
			case ELLIE_IDLE:
				return 6; 
			case ELLIE_SHOOT:
				return 8; 
			case ELLIE_RUN:
				return 6; 
			case ELLIE_DIE:
				return 6; 
			default:
				return 0; 
			}
		}
		

	}

}
