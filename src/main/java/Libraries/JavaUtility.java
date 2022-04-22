package Libraries;

import java.util.Random;



public class JavaUtility {


	public int random()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
}
