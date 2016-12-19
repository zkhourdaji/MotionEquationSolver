

public class MotionEquationsSolver {

	public static double calculateTimeVoVA(double initialVelocity, double velocity, 
			double acceleration){
		double time = (velocity - initialVelocity) / acceleration;
		return time;
	}

	public static double calculateTimeVoAXoX(double initialVelocity, double acceleration, 
			double initialPosition, double finalPosition) {
		double a, b, c, discriminant, r1, r2;

		a = acceleration / 2;
		b = initialVelocity;
		c = initialPosition - finalPosition;
		System.out.println("a " + a);
		System.out.println("b " + b);
		System.out.println("C " + c);

		discriminant = (b * b) - (4 * a * c);
		r1 = 0;
		r2 = 0;

		if (discriminant > 0)
		{
			r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		}
		else if (discriminant == 0)
		{
			r1 = -b / (2 * a);
			r2 = -b / (2 * a);
		}
		System.out.println("Root 1 " + r1);
		System.out.println("Root 2 " + r2);

		if (r1 < 0 && r2 > 0)
			return r2;
		if (r2 < 0 && r1 > 0)
			return r1;

		return r1;
	}
	
	public static double calculateAccelerationVoVT(double initialVelocity, double velocity, 
			 double time){
		
		double acceleration = (velocity - initialVelocity) / time;
		System.out.println("Used accVoVT");
		return acceleration;

	}
	
	public static double calculateAccelerationVoVXoX(double initialVelocity, double velocity, 
			double initialPosition, double finalPosition) {
		
		double acceleration = ((velocity * velocity) - (initialVelocity * initialVelocity) /
				(2*(finalPosition - initialPosition)));
		return acceleration;

	}
	
	public static double calculateAccelerationVoXoXT(double initialVelocity, 
			double initialPosition, double finalPosition, double time){
		
		double distance = finalPosition - initialPosition;
		
		if (initialVelocity == 0){
			return (distance / (0.5 * (time * time)));
		}
		else{
			System.out.println("Fatal Error at calculateAccelerationVoXoXT");
			System.out.println("Initial velocity must be zero");
			return -999;
		}
	}
	
	public static double calculateInitialPositionVoAXT(double initialVelocity, double acceleration, 
			double finalPosition, double time) {
		
		double initialPosition = finalPosition - (initialVelocity * time)
				- ((1/2) * acceleration * time * time);
		return initialPosition;
	}
	
	public static double calculateInitialVelocityVXoXA(double velocity, double initialPosition, 
			double finalPosition, double acceleration) {
		
		double initialVelocity = Math.sqrt(((velocity*velocity)
				- (2* acceleration*(finalPosition - initialPosition))));
		return initialVelocity;

	}
	
	public static double calculateFinalPositionVoVAXo(double initialVelocity, double velocity, double acceleration, double initialPosition) {
		double finalPosition = ((velocity * velocity) - (initialVelocity * initialVelocity)) /
				(2 * acceleration) - initialPosition;
		return finalPosition;

	}
	
	public static double calculateVelocityVoAXoX(double initialVelocity, double acceleration, double initialPosition, double finalPosition) {
		double velocity = Math.sqrt(((initialVelocity * initialVelocity) +
				2 * acceleration*(finalPosition - initialPosition)));
		return velocity;

	}
	
	public static double calculateVelocityVoAT(double initialVelocity, double acceleration, double time){
		double velocity = initialVelocity + (acceleration * time);
		System.out.println("Used VelocityAVoT");
		
		return velocity;
	}
	
	public static double calculateInitialVelocityAXoXT(double acceleration, double initialPosition, double finalPosition, double time) {

		double initialVelocity = ((finalPosition - initialPosition) / time )
				- 	((acceleration * time) / 2);
		return initialVelocity;
	}
	
	public static double calculateFinalPositionVoAXoT(double initialVelocity, double acceleration, double initialPosition, double time) {
		
		double finalPosition = initialPosition +
				(initialVelocity * time) +
				((acceleration * time * time) / 2);
		System.out.println("Used final Position VoAXoT");
		
		return finalPosition;

	}
	
	public static double calculateInitialPositionVoVAX(double initialVelocity, double velocity, double acceleration, double finalPosition) {
		double initialPosition = finalPosition - (((velocity * velocity) -
				(initialVelocity * initialVelocity)) /
				(2 * acceleration));
		System.out.println("Used initialPosition XVVoA");

		return initialPosition;
	}
	
	public static double calculateInitialVelocityVAT(double velocity, double acceleration, double time) {
		
		double initialVelocity = velocity - (acceleration * time);
		return initialVelocity;

	}
	

}
