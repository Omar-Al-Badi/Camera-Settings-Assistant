class ShutterSpeedCalculator extends Calculator
{
  
  double sensorSize;
  int finalShutterSpeed;
  static int stops = 0;
  
  public ShutterSpeedCalculator(int sensorSize, int bodyStabilization, int focalLength, int lensStabilization, double aperture) // Constructor.
  {
    super(sensorSize, bodyStabilization, focalLength, lensStabilization, aperture);
    this.sensorSize = sensorSize;
    this.finalShutterSpeed = 0;
  }
  
    public void calculate()
    {
      // System.out.println("ShutterSpeedCalculator calculate method ran.\n");
      
    	if (getSensorSize() == 1)
    	{
    		sensorSize = 1;
    	}
    	else if (getSensorSize() == 2)
    	{
    		sensorSize = 1.5;
    	}
    	else if (getSensorSize() == 3)
    	{
    		sensorSize = 2;
    	}
       //System.out.println(sensorSize);
      
    	// Ideal Shutter Speed Calculations.
      finalShutterSpeed = (getFocalLength());
    	finalShutterSpeed *= (sensorSize);

      if (getLensStabilization() != 0)
      {
      ++stops;
      }

      if (getBodyStabilization() != 0)
      {
      ++stops;
      }

      if (stops == 1){
        finalShutterSpeed = finalShutterSpeed * 2; 
      }
      else if (stops == 0) {
          finalShutterSpeed = finalShutterSpeed * 3; 
      }
      // System.out.print(finalShutterSpeed);

      System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("\nThis is the Ideal Shutter Speed Calculator. \n");
      
      System.out.print("Your Ideal Shutter Speed is: 1/"+finalShutterSpeed); 
      // Hard coded the 1/ because all results will typically be decimals, but camera's usually display Shutter Speed in fractions.
      System.out.print( " seconds. \n");
    }

  public int getStops(int stops) 
  {
    return stops;
  }
  public void setStops(int stops_) 
  {
    ShutterSpeedCalculator.stops = stops_;
  }
      
}

