import java.util.Scanner;

class DoFCalculator extends Calculator
{

  private double circleOfConfusion;
  private double distance;
	private double hyperfocal;
	private double nearLimit;
	private double farLimit;
	private double totalDoF;

  public DoFCalculator(int sensorSize, int bodyStabilization, int focalLength, int lensStabilization, double aperture) // Default Constructor.
  {
    super(sensorSize, bodyStabilization, focalLength, lensStabilization, aperture);
    this.circleOfConfusion = 0;
    this.distance = 0;
    this.hyperfocal = 0;
    this.nearLimit = 0;
    this.farLimit = 0;
    this.totalDoF = 0;
  }

    public void calculate()
    {
      //System.out.println("DoFCalculator calculate method ran.\n");

    	if (getSensorSize() == 1)
    	{
    		circleOfConfusion = 0.03;
    	}
    	else if (getSensorSize() == 2)
    	{
    		circleOfConfusion = 0.02;
    	}
    	else if (getSensorSize() == 3)
    	{
    		circleOfConfusion = 0.015;
    	}

      try (Scanner read = new Scanner(System.in)) {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nThis is the Depth of Field Calculator. \n\n");
        
        System.out.println("Thank you for your input, I just need to ask you one more question, what would your distance from the subject be in meters? ");
        distance = read.nextDouble();
      }
      distance = distance * 1000; // Convert to mm.
      //System.out.println(distance); 

      // DoF Calculations.
    	hyperfocal = ((getFocalLength() * getFocalLength()) / (getAperture() * circleOfConfusion) + getFocalLength()); 
    	nearLimit = (distance * (hyperfocal - getFocalLength())) / (hyperfocal + distance - (2.0 * getFocalLength()));
    	farLimit = (distance * (hyperfocal - getFocalLength())) / (hyperfocal - distance);
    	totalDoF = farLimit - nearLimit;
    
      System.out.println("\nNegative values for far limit and total depth of field means your camera and lens combo can focus to infinity, which is great for landscapes, but not very desirable for portraits. \n");
			System.out.println("Your Hyperfocal distance is: " + hyperfocal/1000 + " m");
			System.out.println("\nThe near limit of acceptable focus is: "+ nearLimit/1000 + " m");
			System.out.println("\nThe far limit of acceptable focus is: "+ farLimit/1000 + " m");
			System.out.println("\nThe total depth of field is: " +totalDoF/1000 + " m"); 
    }

  public double getDistance() 
  {
    return distance;
  }
  public void setDistance(double distance_) 
  {
    distance = distance_;
  }

  public double getHyperfocal() 
  {
    return hyperfocal;
  }
  public void setHyperfocal(double hyperfocal_) 
  {
    hyperfocal = hyperfocal_;
  }

  public double getNearLimit() 
  {
    return nearLimit;
  }
  public void setNearLimit(double nearLimit_) 
  {
    nearLimit = nearLimit_;
  }

  public double getFarLimit() 
  {
    return farLimit;
  }
  public void setFarLimit(double farLimit_) 
  {
    farLimit = farLimit_;
  }
  
  public double getTotalDoF() 
  {
    return totalDoF;
  }
  public void setTotalDoF(double totalDoF_) 
  {
    totalDoF = totalDoF_;
  }  
  
}