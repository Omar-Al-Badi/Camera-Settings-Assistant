import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
  {
    
    int sensorSize;
  	int focalLength;
  	double aperture;
  	int lensStabilization;
  	int bodyStabilization;
    int tool;
    boolean restartReader = false;

    try (Scanner read = new Scanner(System.in)) { // Try to read from the console.
      do {
        
          System.out.println("\nYou are using my photography assistant V1.0.\n");
      
          System.out.println("Welcome!\n");
      
          System.out.println("What kind of Camera user are you?\n");
          System.out.println("1. Full frame user.");
          System.out.println("2. APSC user.");
          System.out.println("3. Micro Four Thirds user. ");
      
          System.out.println("\nEnter the number related to your camera: ");
      
          sensorSize = read.nextInt(); 
          //System.out.println(sensorSize);
        
          System.out.println("\nDoes your camera have in-body stabilization? (Please enter 'y' or 'n'.)"); 
      
          // Input Validation.
          Boolean bodyStabilizationReader = new Scanner(System.in).nextLine().equalsIgnoreCase("Y")?true:false;
      
          if(bodyStabilizationReader==true)
          {
            bodyStabilization = 1;
          }
          else
          {    
            bodyStabilization = 0;
          }
          //System.out.println(bodyStabilization);
      
          System.out.println("\nWhat kind of Lens are you going to be using? (Focal Length) "); 
        
      	  focalLength = read.nextInt();
          //System.out.println(focalLength);
      
          System.out.println("\nDoes your lens have stabilization? (Please enter 'y' or 'n'.) "); 
      
          // Input Validation.
          Boolean lensStabilizationReader = new Scanner(System.in).nextLine().equalsIgnoreCase("Y")?true:false;
          
          if(lensStabilizationReader==true)
          {
            lensStabilization = 1;
          }
          else
          {    
            lensStabilization = 0;
          }
          // System.out.println(lensStabilization);
      
          System.out.println("\nWhat is the widest aperture of your lens? (Lowest F-number) "); 
        
      		aperture = read.nextDouble();
          // System.out.println(aperture); 
          
          Calculator calcObj; // Creating a Calculator object.
      
          System.out.println("\nThank you! What tool would you like to use?");
        
      		System.out.println("\n1. DoF Calculator.");
      		System.out.println("2. Ideal Shutter Speed Calculator.");
      		System.out.println("\nEnter the number related to your desired tool: "); 
      		tool = read.nextInt();
          //System.out.println(tool);
      
          if(tool == 1)
          {
            DoFCalculator doFCalcObj = new DoFCalculator(sensorSize, bodyStabilization, focalLength, lensStabilization, aperture); // Creating a DoFCalculator object.
            //calcObj.calculate();
            calcObj = doFCalcObj; // Assigning the DoFCalculator object to the Calculator object.
            calcObj.calculate();  // Calling the calculate function.
      
          }
          else if(tool == 2)
          {
            ShutterSpeedCalculator shutterSpeedCalcObj = new ShutterSpeedCalculator(sensorSize, bodyStabilization, focalLength, lensStabilization, aperture); // Creating a ShutterSpeedCalculator object.
            //calcObj.calculate();
            calcObj = shutterSpeedCalcObj; // Assigning the ShutterSpeedCalculator object to the Calculator object.
            calcObj.calculate(); // Calling the calculate function.
          }
          else
          {
            System.out.println("\nInvalid input. Please try again.");
          }
      
          System.out.println("\nWould you like to use the photography assistant V1.0 again? (Please enter 'y' or 'n'.) ");
      
          restartReader = new Scanner(System.in).nextLine().equalsIgnoreCase("Y")?true:false; 
      
        } while (restartReader == true);
    }

System.out.println("\nI hope you found my assistance useful, bye! ");  			 
  
  }
}