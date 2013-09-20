/*
 * Rally.java
 *
 * Main-klassen
 *
 * Gruppe 8
 */

import java.io.File;
import lejos.nxt.*;

public class Rally {
	public static void main(String[] args) throws Exception {

		final int 		MAX_SPEED = 400;
		final int 		LIGHT_THRESHOLD = 45;

		LightSensor lightSensor = new LightSensor(SensorPort.S3);
		TouchSensor touchSensor1 = new TouchSensor(SensorPort.S1);
		TouchSensor touchSensor4 = new TouchSensor(SensorPort.S4);

		Thread.sleep(1000);

		Motor.A.setSpeed(MAX_SPEED * 3 / 4);
		Motor.B.setSpeed(MAX_SPEED);

		Motor.A.backward();
		Motor.B.backward();

		while (!Button.ENTER.isDown()) {

			if (lightSensor.readValue() < LIGHT_THRESHOLD) {
				Motor.B.setSpeed(0);
				Thread.sleep(300);
				Motor.B.setSpeed(MAX_SPEED);
				Motor.B.backward();
			}

			if (touchSensor1.isPressed() || touchSensor4.isPressed()) {
				Motor.A.forward();
				Motor.B.forward();
				Thread.sleep(250);
				Motor.B.setSpeed(0);
				Motor.A.backward();
				Thread.sleep(500);
				Motor.B.setSpeed(MAX_SPEED);
				Motor.B.backward();


			}
		}
	}
}

