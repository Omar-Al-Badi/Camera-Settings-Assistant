public class Calculator
{

  static int nOCalculatorRuns;
  private int sensorSize;
  private int bodyStabilization;
  private int focalLength;
  private int lensStabilization;
  private double aperture; 

  public Calculator(int sensorSize, int bodyStabilization, int focalLength, int lensStabilization, double aperture) // Constructor.
  {
    this.sensorSize = sensorSize;
    this.bodyStabilization = bodyStabilization;
    this.focalLength = focalLength;
    this.lensStabilization = lensStabilization;
    this.aperture = aperture;
  }

  public void calculate() 
  {
    System.out.println("Calculator calculate function ran.\n");
    System.out.println("\nYou ran my tools " + ++nOCalculatorRuns + " times.");
  } 

  public int getSensorSize() 
  {
    return sensorSize;
  }
  public void setSensorSize(int sensorSize_) 
  {
    sensorSize = sensorSize_;
  }

  public int getBodyStabilization() 
  {
    return bodyStabilization;
  }
  public void setBodyStabilization(int bodyStabilization_) 
  {
    bodyStabilization = bodyStabilization_;
  }

  public int getFocalLength() 
  {
    return focalLength;
  }
  public void setFocalLength(int focalLength_) 
  {
    focalLength = focalLength_;
  }

  public int getLensStabilization() 
  {
    return lensStabilization;
  }
  public void setLensStabilization(int lensStabilization_) 
  {
    lensStabilization = lensStabilization_;
  }

  public double getAperture() 
  {
    return aperture;
  }
  public void setAperture(double aperture_) 
  {
    aperture = aperture_;
  }

  public static int getnOCalculatorRuns()
  {
    return nOCalculatorRuns;
  }
  public static void setnOCalculatorRuns(int nOCalculatorRuns_)
  {
    nOCalculatorRuns = nOCalculatorRuns_;
  }
  
}