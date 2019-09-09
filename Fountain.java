/**
 * @author Jake Musleh
 * Email: jmusleh@wisc.edu
 * Title: Fountain
 * Description: This program creates a fountain that continuously spits out particles. Its center is controlled
 * by the mouse.
 */

import java.util.Random;
public class Fountain {
	
	private static Random randGen = new Random(5);
	private static Particle[] particles;
	private static int positionX; //middle of the screen (left to right): 400
	private static int positionY; //middle of the screen (top to bottom): 300
	private static int startColor; //Utility.color(23, 141, 235): blue
	private static int endColor; //Utility.color(23, 200, 255): lighter blue
	
	/**
	 * Runs the program, creating a graphical fountain
	 * @param args - Unused
	 */
	public static void main(String[] args)
	{
		Utility.runApplication();
	}
	
	
	/**
	 * Runs a test to ensure the program's functionality then initializes the private variables
	 */
	public static void setup()
	{
		
		//Ensures that particles can correctly be updated and removed
		particles = new Particle[800];
		boolean doesItWork = (testUpdateParticle() && testRemoveOldParticles());
		if(!doesItWork)
			{
				System.out.println("FAILED");
			}
			
				
		positionX = 400;
		positionY = 300;
		startColor = Utility.color(23, 141, 235); //blue
		endColor = Utility.color(23, 200, 255); //lighter blue
		
		//Creates the first particle
		particles[0] = new Particle();
		particles[0].setVelocityX(-6f);
		particles[0].setVelocityY(-6f);
		
	}
	
	/**
	 * Creates up to 10 new particles, removes old ones, and updates the current ones
	 */
	public static void update()
	{
		createNewParticles(10);
		int backgroundColor = Utility.color(235, 213, 186);
		Utility.background(backgroundColor);
		
		for(int i = 0; i < particles.length; i++)
		{
			if(!(particles[i] == null)) //There must be an existing particle in order to update it
			{
				updateParticle(i);
			}
		}
		removeOldParticles(80); //Removes particles whose age > 80
		
	}
	
	/**
	 * Moves the average spawning point of the particles to the position of the pressed mouse
	 * @param x - The x position of the mouse
	 * @param y - The y position of the mouse
	 */
	
	public static void mousePressed(int x, int y)
	{
		positionX = x;
		positionY = y;
	}
	
	/**
	 * Saves a screenshot of the current state of the fountain if 'p' is pressed
	 * @param pressedKey - The key pressed
	 */
	public static void keyPressed(char pressedKey)
	{
		if(pressedKey == 'p')
		{
			Utility.save("screenshot.png");
		}
	}
	
	/**
	 * Updates a particle by changing its position, velocity, and age
	 * @param index - The index of the particle to be updated
	 */
	private static void updateParticle(int index)
	{
		Utility.circle(particles[index].getPositionX(), particles[index].getPositionY(), particles[index].getSize());
		Utility.fill(particles[index].getColor(), particles[index].getTransparency());
		particles[index].setVelocityY(particles[index].getVelocityY() + 0.3f);
		particles[index].setPositionX(particles[index].getPositionX() + particles[index].getVelocityX());
		particles[index].setPositionY(particles[index].getPositionY() + particles[index].getVelocityY());
		particles[index].setAge(particles[index].getAge() + 1);
	}
	
	/**
	 * Creates a given number of new particles, then gives them random characteristics
	 * @param numParticles - The number of particles to be created
	 */
	private static void createNewParticles(int numParticles)
	{
		for(int i = 0; i < particles.length; i++)
		{
			if(numParticles == 0)
			{
				break;
			}
			if(particles[i] == null)
			{
				float xPosition = (positionX - 3) + (randGen.nextFloat() * 6);
				float yPosition = (positionY - 3) + (randGen.nextFloat() * 6);
				float size = 4 + (randGen.nextFloat() * 7);
				float xVelocity = -1 + (randGen.nextFloat() * 2);
				float yVelocity = -5 + (randGen.nextFloat() * -5);
				int age = randGen.nextInt(41);
				int color = Utility.lerpColor(startColor, endColor, randGen.nextFloat());
				int transparency = 32 + randGen.nextInt((127 - 32) + 1);
				particles[i] = new Particle(xPosition, yPosition, size, color);
				particles[i].setVelocityX(xVelocity);
				particles[i].setVelocityY(yVelocity);
				particles[i].setAge(age);
				particles[i].setTransparency(transparency);
				numParticles--;
			}
			
		}
	}
	
	/**
	 * Removes particles whose age is greater than or equal to than a given age
	 * @param maxAge - The given age
	 */
	private static void removeOldParticles(int maxAge)
	{
		for(int i = 0; i < particles.length; i++)
		{
			if(!(particles[i] == null))
			{
				if(particles[i].getAge() >= maxAge)
				{
					particles[i] = null;
				}
			}
		}
	}
	
	/**
	 * Creates a new particle at position (3, 3) and velocity (-1, -2), then checks whether calling updateParticle
	 * correctly changes its position to (2, 1.3)
	 * @return - True if the position was correctly updated, false otherwise
	 */
	
	private static boolean testUpdateParticle()
	{
		particles[0] = new Particle(3, 3, 10, startColor);
		particles[0].setVelocityX(-1f);
		particles[0].setVelocityY(-2f);
		updateParticle(0);
		boolean doesItWork = ((particles[0].getPositionX() == 2f) && (particles[0].getPositionY() == 1.3f));
		particles[0] = null;
		return doesItWork;
	}
	
	/**
	 * Creates three particles, two with age 6 and one with age 3, then tries removing all particles with age 6
	 * @return - Whether or not two of the particles were correctly removed
	 */
	private static boolean testRemoveOldParticles()
	{
		particles[0] = new Particle();
		particles[0].setAge(6);
		particles[1] = new Particle();
		particles[1].setAge(6);
		particles[2] = new Particle();
		particles[2].setAge(3);
		removeOldParticles(6);
		boolean doesItWork = ((particles[0] == null) && (particles[1] == null) && (particles[2] != null));
		particles[2] = null;
		return doesItWork;
		
	}
	
	}



