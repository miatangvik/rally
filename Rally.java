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

		final int 		MAX_SPEED = 900;
		final int 		LIGHT_THRESHOLD = 45;

		LightSensor lightSensor = new LightSensor(SensorPort.S3);
		Thread.sleep(1000);

		while (!Button.ENTER.isDown()) {
			Motor.A.setSpeed(MAX_SPEED * 2 / 3);
			Motor.B.setSpeed(MAX_SPEED);

			Motor.A.backward();
			Motor.B.backward();

			if (lightSensor.readValue() < LIGHT_THRESHOLD) {
//				Motor.A.setSpeed(0);
				Motor.B.setSpeed(0);
				Thread.sleep(100);
//				Motor.B.setSpeed(MAX_SPEED);
//				Thread.sleep(1000);


			}

		}
	}
}

