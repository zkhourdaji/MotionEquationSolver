
/**
 * Created by ZaferSamir on 1/25/2016.
 */
public class Data {

	// -999 means that the value is not known

	// TODO make a method to set the booleans to true when they variables are known
	// TODO automate some tests

	private double initialVelocity, velocity, acceleration, initialPosition,
	finalPosition, time;

	private boolean initialVelocityKnown, velocityKnown, accelerationKnown,
	initialPositionKnown, finalPositionKnown, timeKnown;

	public Data(double initialVelocity, double finalVelocity, double acceleration, 
			double initialPosition,  double finalPosition, double time) {

		this.initialVelocity = initialVelocity;
		this.velocity = finalVelocity;
		this.acceleration = acceleration;
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
		this.time = time;

		if (this.initialVelocity != -999)
			this.initialVelocityKnown = true;

		if (this.velocity != -999)
			this.velocityKnown = true;

		if (this.acceleration != -999)
			this.accelerationKnown = true;

		if (this.initialPosition != -999)
			this.initialPositionKnown = true;

		if (this.finalPosition != -999)
			this.finalPositionKnown = true;

		if (this.finalPosition != -999)
			this.finalPositionKnown = true;

		if (this.time != -999)
			this.timeKnown = true;

	}



	public double getInitialVelocity() {
		return initialVelocity;
	}

	public double getVelocity() {
		return velocity;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public double getFinalPosition() {
		return finalPosition;
	}

	public double getInitialPosition(){
		return initialPosition;

	}

	public double getTime() {
		return time;
	}

	//	public void calculateVelocityTD(){
	//		velocity = finalPosition / time;
	//		System.out.println("Used velocity TD");
	//	}

	//	private void calculateTimeVD(){
	//		time = finalPosition / velocity;
	//		System.out.println("Used TimeVD");
	//	}




	public String toString() {
		String returnedString = "";

		if (initialVelocityKnown)
		returnedString += "Initial Velocity: " + this.initialVelocity + "\n";

		if (velocityKnown)
		returnedString += "Velocity: " + this.velocity + "\n";

		if (accelerationKnown)
		returnedString += "Acceleration: " + this.acceleration + "\n";

		if (initialPositionKnown)
		returnedString += "Initial Position: " + this.initialPosition + "\n";

		if (finalPositionKnown)
		returnedString += "Final Position: " + this.finalPosition + "\n";

		if (timeKnown)
		returnedString += "Time: " + this.time + "\n";

		return returnedString;
	}


	private void findFinalVelocity(){

		//		if (!velocityKnown() && finalPositionKnown() && timeKnown() )
		//			calculateVelocityTD();

		if (!this.velocityKnown && this.initialVelocityKnown 
				&& this.accelerationKnown && this.timeKnown){
			velocity = MotionEquationsSolver.calculateVelocityVoAT(initialVelocity, acceleration, time);
			this.velocityKnown = true;
		}
		else if (!this.velocityKnown && this.initialVelocityKnown 
				&& this.accelerationKnown && this.finalPositionKnown 
				&& this.initialPositionKnown){
			velocity = MotionEquationsSolver.calculateVelocityVoAXoX(initialVelocity, acceleration, initialPosition, finalPosition);
			this.velocityKnown = true;
		}
	}



	private void findFinalPosition(){

		if (!this.finalPositionKnown && this.initialPositionKnown 
				&& this.initialVelocityKnown && this.timeKnown
				&& this.accelerationKnown){
			this.finalPosition = MotionEquationsSolver.calculateFinalPositionVoAXoT(initialVelocity, acceleration, initialPosition, time);
			this.finalPositionKnown = true;
		}
		else if (!this.finalPositionKnown && this.velocityKnown && this.initialVelocityKnown
				&& this.accelerationKnown && this.initialPositionKnown){
			this.finalPosition = MotionEquationsSolver.calculateFinalPositionVoVAXo(initialVelocity, velocity, acceleration, initialPosition);
			this.finalPositionKnown = true;
		}
	}



	private void findTime(){

		if (!this.timeKnown && this.velocityKnown && this.initialVelocityKnown 
				&& this.accelerationKnown){
			this.time = MotionEquationsSolver.calculateTimeVoVA(initialVelocity, velocity, acceleration);
			this.timeKnown = true;
		}
		else if (!this.timeKnown && this.accelerationKnown && this.initialVelocityKnown&&
				this.initialPositionKnown && this.finalPositionKnown){
			this.time = MotionEquationsSolver.calculateTimeVoAXoX(initialVelocity, acceleration, initialPosition, finalPosition);
			this.timeKnown = true;
		}
	}



	private void findAcceleration(){

		if (!accelerationKnown && velocityKnown && initialVelocityKnown && timeKnown){
			this.acceleration = MotionEquationsSolver.calculateAccelerationVoVT(initialVelocity, velocity, time);
			this.accelerationKnown = true;
		}
		if (!accelerationKnown && velocityKnown && initialVelocityKnown
				&& finalPositionKnown && initialPositionKnown){
			this.acceleration = MotionEquationsSolver.calculateAccelerationVoVXoX(initialVelocity, velocity, initialPosition, finalPosition);
			this.accelerationKnown = true;
		}
		
		if (!accelerationKnown && initialVelocityKnown && timeKnown 
		&& initialPositionKnown && finalPositionKnown){
			this.acceleration = MotionEquationsSolver.calculateAccelerationVoXoXT(initialVelocity, initialPosition, finalPosition, time);
			this.accelerationKnown = true;
			}
	}



	private void findInitialPosition(){

		if (!this.initialPositionKnown && this.accelerationKnown && this.timeKnown
				&& initialVelocityKnown){
			this.initialPosition = MotionEquationsSolver.calculateInitialPositionVoAXT(initialVelocity, acceleration, finalPosition, time);
			this.initialPositionKnown = true;
		}
		else if (!this.initialPositionKnown && this.finalPositionKnown && this.velocityKnown &&
				this.initialVelocityKnown && this.accelerationKnown){
			this.initialPosition = MotionEquationsSolver.calculateInitialPositionVoVAX(initialVelocity, velocity, acceleration, finalPosition);
			this.initialPositionKnown = true;
		}
	}



	private void findInitialVelocity(){

		if (!initialVelocityKnown && velocityKnown && accelerationKnown && timeKnown){
			this.initialVelocity = MotionEquationsSolver.calculateInitialVelocityVAT(velocity, acceleration, time);
			this.initialVelocityKnown = true;
		}
		else if(!initialVelocityKnown && initialPositionKnown && finalPositionKnown
				&& timeKnown && accelerationKnown){
			this.initialVelocity = MotionEquationsSolver.calculateInitialVelocityAXoXT(
					acceleration, initialPosition, finalPosition, time);
			this.initialVelocityKnown = true;
		}

		else if (!initialVelocityKnown && velocityKnown && accelerationKnown
				&& finalPositionKnown && initialPositionKnown){
			this.initialVelocity = MotionEquationsSolver.calculateInitialVelocityVXoXA(
					velocity, initialPosition, finalPosition, acceleration);
			this.initialVelocityKnown = true;
		}


	}

	private boolean checkData(){
		if (accelerationKnown && timeKnown
				&& finalPositionKnown && velocityKnown
				&& initialPositionKnown && initialVelocityKnown)
			return false;
		return true;
	}

	public void solveData(){
		System.out.println("solve date called ");
		int tries = 0;

		while(checkData() && tries < 6)
		{
			findAcceleration();
			findFinalPosition();
			findFinalVelocity();
			findInitialPosition();
			findInitialVelocity();
			findTime();
			tries++;

		}
	}
}


