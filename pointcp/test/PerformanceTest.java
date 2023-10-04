import java.util.Random;
import java.util.Arrays;
/*
 * PerformanceTest.java
 * This class tests the performance of the different designs
 *
 */
public class PerformanceTest{

    public static void main(String[] args){

        Integer arraySize = 10_000_000; //change to adjust time taken to run

        // random number generator for x and y
        Random rX = new Random();
		Random rY = new Random();
        Random rCP = new Random();

		// array of 10 million random doubles between 0 and 10
		double[] arrayX   = new double[arraySize];
		double[] arrayY   = new double[arraySize];
		char[]   arrayCP  = new char[arraySize];
        //
        for(int i = 0; i < arraySize; i++){
			arrayX[i] = 10.0 * rX.nextDouble(); //random double between 0 and 10
			arrayY[i] = 10.0 * rY.nextDouble(); //random double between 0 and 10
			// randomly assign C or P
            int randomCP = rCP.nextInt(2);
            if(randomCP == 0){
                arrayCP[i] = 'C';
            }
            else{
                arrayCP[i] = 'P';
            }
		}

		//arrays to store times 10 iterations
        // design 1
		long[] pointCP1Instantiating    = new long[10];
		long[] pointCPX                 = new long[10];
		long[] pointCPY                 = new long[10];
		long[] pointCPRho               = new long[10];
		long[] pointCPTheta             = new long[10];
		long[] pointCPDistance          = new long[10];
		long[] pointCPRotate            = new long[10];
        // design 2
		long[] pointCP2Instantiating    = new long[10];
		long[] pointCP2X                = new long[10];
		long[] pointCP2Y                = new long[10];
		long[] pointCP2Rho              = new long[10];
		long[] pointCP2Theta            = new long[10];
		long[] pointCP2Distance         = new long[10];
		long[] pointCP2Rotate           = new long[10];
        // design 3
		long[] pointCP3Instantiating    = new long[10];
		long[] pointCP3X                = new long[10];
		long[] pointCP3Y                = new long[10];
		long[] pointCP3Rho              = new long[10];
		long[] pointCP3Theta            = new long[10];
		long[] pointCP3Distance         = new long[10];
		long[] pointCP3Rotate           = new long[10];
        // design 5
		long[] pointCP5Instantiating    = new long[10];
		long[] pointCP5X                = new long[10];
		long[] pointCP5Y                = new long[10];
		long[] pointCP5Rho              = new long[10];
		long[] pointCP5Theta            = new long[10];
		long[] pointCP5Distance         = new long[10];
		long[] pointCP5Rotate           = new long[10];

        // change iterations to get more accurate results
        Integer iterations = 10;

        // run each test 10 times
		for(int j = 0; j < iterations; j++){
			System.out.println("Starting iteration: " + j + " of " + iterations);

            /*
             * Testing Design 1
                */
                // start time
                final long startTimeCP = System.currentTimeMillis();
                // array of 10 million points
                PointCPT[] point1 = new PointCPT[arraySize];
                // instantiate 10 million points
                for(int i = 0 ; i < arraySize; i++){
                    point1[i] = new PointCPT(arrayCP[i], arrayX[i], arrayY[i]);
                }
                // end time
                final long endTime1 = System.currentTimeMillis();
                // store time in array
                pointCP1Instantiating[j] = endTime1 - startTimeCP;

                /************ Testing get(X) for design 1 ******************/
                final long startGetXCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point1[i].getX();
                }
                final long endGetXCP = System.currentTimeMillis();
                pointCPX[j] = endGetXCP - startGetXCP;

                /************ Testing get(Y) for design 1 ******************/
                final long startGetYCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point1[i].getY();
                }
                final long endGetYCP = System.currentTimeMillis();
                pointCPY[j] = endGetYCP - startGetYCP;

                /************ Testing get(Rho) for design 1 ****************/
                final long startRhoCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point1[i].getRho();
                }
                final long endRhoCP = System.currentTimeMillis();
                pointCPRho[j] = endRhoCP - startRhoCP;

                /************ Testing get(Theta) for design 1 **************/
                final long startThetaCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point1[i].getTheta();
                }
                final long endThetaCP = System.currentTimeMillis();
                pointCPTheta[j] = endThetaCP - startThetaCP;

                /************ Testing get(Distance) for design 1 ***********/
                final long startDistanceCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point1[i].getDistance(point1[0]);
                    }else{
                        point1[i].getDistance(point1[i-1]);
                    }
                }
                final long endDistanceCP = System.currentTimeMillis();
                pointCPDistance[j] = endDistanceCP - startDistanceCP;

                /************ Testing get(Rotation) for design 1 ***********/
                final long startRotationCP = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point1[i].rotatePoint(0.0);
                    }else{
                        point1[i].rotatePoint((double)i);
                    }
                }
                final long endRotationCP = System.currentTimeMillis();
                pointCPRotate[j] = endRotationCP - startRotationCP;

            /*
             * Testing Design 2
                */
                final long startTimeCP2 = System.currentTimeMillis();
                PointCP2T[] point2 = new PointCP2T[arraySize];
                for(int i=0;i<arraySize;i++){
                    point2[i]=new PointCP2T(arrayCP[i], arrayX[i], arrayY[i]);
                }
                final long endTimeCP2 = System.currentTimeMillis();
                pointCP2Instantiating[j] = endTimeCP2 - startTimeCP2;

                /************ Testing get(X) for design 2 ******************/
                final long startGetXCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point2[i].getX();
                }
                final long endGetXCP2 = System.currentTimeMillis();
                pointCP2X[j] = endGetXCP2 - startGetXCP2;

                /************ Testing get(Y) for design 2 ******************/
                final long startGetYCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point2[i].getY();
                }
                final long endGetYCP2 = System.currentTimeMillis();
                pointCP2Y[j] = endGetYCP2 - startGetYCP2;

                /************ Testing get(Rho) for design 2 ****************/
                final long startRhoCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point2[i].getRho();
                }
                final long endRhoCP2 = System.currentTimeMillis();
                pointCP2Rho[j] = endRhoCP2 - startRhoCP2;

                /************ Testing get(Theta) for design 2 **************/
                final long startThetaCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point2[i].getTheta();
                }
                final long endThetaCP2 = System.currentTimeMillis();
                pointCP2Theta[j] = endThetaCP2 - startThetaCP2;

                /************ Testing get(Distance) for design 2 ***********/
                final long startDistanceCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point2[i].getDistance(point2[0]);
                    }else{
                        point2[i].getDistance(point2[i-1]);
                    }
                }
                final long endDistanceCP2 = System.currentTimeMillis();
                pointCP2Distance[j] = endDistanceCP2 - startDistanceCP2;

                /************ Testing get(Rotation) for design 2 ***********/
                final long startRotationCP2 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point2[i].rotatePoint(0.0);
                    }else{
                        point2[i].rotatePoint((double)i);
                    }
                }
                final long endRotationCP2 = System.currentTimeMillis();
                pointCP2Rotate[j] = endRotationCP2 - startRotationCP2;

            /*
             * Testing Design 3
                */
                final long startTimeCP3 = System.currentTimeMillis();
                PointCP3T[] point3 = new PointCP3T[arraySize];
                for(int i=0;i<arraySize;i++){
                    point3[i]=new PointCP3T(arrayCP[i], arrayX[i], arrayY[i]);

                }
                final long endTimeCP3 = System.currentTimeMillis();
                pointCP3Instantiating[j] = endTimeCP3 - startTimeCP3;

                /************ Testing get(X) for design 3 *****************/
                final long startGetXCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point3[i].getX();
                }
                final long endGetXCP3 = System.currentTimeMillis();
                pointCP3X[j] = endGetXCP3 - startGetXCP3;

                /************ Testing get(Y) for design 3 *****************/
                final long startGetYCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point3[i].getY();
                }
                final long endGetYCP3 = System.currentTimeMillis();
                pointCP3Y[j] = endGetYCP3 - startGetYCP3;

                /************ Testing get(Rho) for design 3 ***************/
                final long startRhoCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point3[i].getRho();
                }
                final long endRhoCP3 = System.currentTimeMillis();
                pointCP3Rho[j] = endRhoCP3 - startRhoCP3;

                /************ Testing get(Theta) for design 3 *************/
                final long startThetaCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point3[i].getTheta();
                }
                final long endThetaCP3 = System.currentTimeMillis();
                pointCP3Theta[j] = endThetaCP3 - startThetaCP3;

                /************ Testing get(Distance) for design 3 **********/
                final long startDistanceCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point3[i].getDistance(point3[0]);
                    }else{
                        point3[i].getDistance(point3[i-1]);
                    }
                }
                final long endDistanceCP3 = System.currentTimeMillis();
                pointCP3Distance[j] = endDistanceCP3 - startDistanceCP3;

                /************ Testing get(Rotation) for design 3 **********/
                final long startRotationCP3 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point3[i].rotatePoint(0.0);
                    }else{
                        point3[i].rotatePoint((double)i);
                    }
                }
                final long endRotationCP3 = System.currentTimeMillis();
                pointCP3Rotate[j] = endRotationCP3 - startRotationCP3;

            /*
             * Testing Design 5
                */
                final long startTimeCP5 = System.currentTimeMillis();
                PointCP5T[] point5 = new PointCP5T[arraySize];
                for(int i=0;i<arraySize;i++){
                    point5[i]=new PointCP2modT(arrayCP[i], arrayX[i], arrayY[i]);
                }
                final long endTimeCP5 = System.currentTimeMillis();
                pointCP5Instantiating[j] = endTimeCP5 - startTimeCP5;

                /************ Testing get(X) for design 5 ****************/
                final long startGetXCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point5[i].getX();
                }
                final long endGetXCP5 = System.currentTimeMillis();
                pointCP5X[j] = endGetXCP5 - startGetXCP5;

                /************ Testing get(Y) for design 5 ****************/
                final long startGetYCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point5[i].getY();
                }
                final long endGetCP5 = System.currentTimeMillis();
                pointCP5Y[j] = endGetCP5 - startGetYCP5;

                /************ Testing get(Rho) for design 5 **************/
                final long startRhoCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point5[i].getRho();
                }
                final long endRhoCP5 = System.currentTimeMillis();
                pointCP5Rho[j] = endRhoCP5 - startRhoCP5;

                /************ Testing get(Theta) for design 5 *************/
                final long startThetaCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    point5[i].getTheta();
                }
                final long endThetaCP5 = System.currentTimeMillis();
                pointCP5Theta[j] = endThetaCP5 - startThetaCP5;

                /************ Testing get(Distance) for design 5 **********/
                final long startDistanceCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point5[i].getDistance(point5[0]);
                    }else{
                        point5[i].getDistance(point5[i-1]);
                    }
                }
                final long endDistanceCP5 = System.currentTimeMillis();
                pointCP5Distance[j] = endDistanceCP5 - startDistanceCP5;

                /************ Testing get(Rotation) for design 5 **********/
                final long startRotationCP5 = System.currentTimeMillis();
                for(int i=0;i<arraySize;i++){
                    if(i == 0){
                        point5[i].rotatePoint(0.0);
                    }else{
                        point5[i].rotatePoint((double)i);
                    }
                }
                final long endRotationCP5 = System.currentTimeMillis();
                pointCP5Rotate[j] = endRotationCP5 - startRotationCP5;
		}

        long[][] arraysToSort = {
            pointCP1Instantiating, pointCPX,  pointCPY,  pointCPRho,  pointCPTheta,  pointCPDistance,  pointCPRotate,
            pointCP2Instantiating, pointCP2X, pointCP2Y, pointCP2Rho, pointCP2Theta, pointCP2Distance, pointCP3Rotate,
            pointCP3Instantiating, pointCP3X, pointCP3Y, pointCP3Rho, pointCP3Theta, pointCP3Distance, pointCP3Rotate,
            pointCP5Instantiating, pointCP5X, pointCP5Y, pointCP5Rho, pointCP5Theta, pointCP5Distance, pointCP5Rotate
        };

        for (long[] array : arraysToSort) {
            Arrays.sort(array);
        }


        System.out.println("Metric                      | Design 1 | Design 2 | Design 3 | Design 5");
        System.out.println("----------------------------|----------|----------|----------|----------");

        // Median times
        printRow("Median| Instantiating Time",  pointCP1Instantiating[4],   pointCP2Instantiating[4],   pointCP3Instantiating[4],   pointCP5Instantiating[4]);
        printRow("      | Getting X Time",      pointCPX[4],                pointCP2X[4],               pointCP3X[4],               pointCP5X[4]            );
        printRow("      | Getting Y Time",      pointCPY[4],                pointCP2Y[4],               pointCP3Y[4],               pointCP5Y[4]            );
        printRow("      | Getting Rho Time",    pointCPRho[4],              pointCP2Rho[4],             pointCP3Rho[4],             pointCP5Rho[4]          );
        printRow("      | Getting Theta Time",  pointCPTheta[4],            pointCP2Theta[4],           pointCP3Theta[4],           pointCP5Theta[4]        );
        printRow("      | Distance Time",       pointCPDistance[4],         pointCP2Distance[4],        pointCP3Distance[4],        pointCP5Distance[4]     );
        printRow("      | Rotation Time",       pointCPRotate[4],           pointCP2Rotate[4],          pointCP3Rotate[4],          pointCP5Rotate[4]       );
        System.out.println("-----------------------------------------------------------------------");

        // Minimum times
        printRow("Min   | Instantiating Time",  pointCP1Instantiating[0],   pointCP2Instantiating[0],   pointCP3Instantiating[0],   pointCP5Instantiating[0]);
        printRow("      | Getting X Time",      pointCPX[0],                pointCP2X[0],               pointCP3X[0],               pointCP5X[0]            );
        printRow("      | Getting Y Time",      pointCPY[0],                pointCP2Y[0],               pointCP3Y[0],               pointCP5Y[0]            );
        printRow("      | Getting Rho Time",    pointCPRho[0],              pointCP2Rho[0],             pointCP3Rho[0],             pointCP5Rho[0]          );
        printRow("      | Getting Theta Time",  pointCPTheta[0],            pointCP2Theta[0],           pointCP3Theta[0],           pointCP5Theta[0]        );
        printRow("      | Distance Time",       pointCPDistance[0],         pointCP2Distance[0],        pointCP3Distance[0],        pointCP5Distance[0]     );
        printRow("      | Rotation Time",       pointCPRotate[0],           pointCP2Rotate[0],          pointCP3Rotate[0],          pointCP5Rotate[0]       );
        System.out.println("-----------------------------------------------------------------------");

        // Maximum times
        printRow("Max   | Instantiating Time",  pointCP1Instantiating[9],   pointCP2Instantiating[9],   pointCP3Instantiating[9],   pointCP5Instantiating[9]);
        printRow("      | Getting X Time",      pointCPX[9],                pointCP2X[9],               pointCP3X[9],               pointCP5X[9]            );
        printRow("      | Getting Y Time",      pointCPY[9],                pointCP2Y[9],               pointCP3Y[9],               pointCP5Y[9]            );
        printRow("      | Getting Rho Time",    pointCPRho[9],              pointCP2Rho[9],             pointCP3Rho[9],             pointCP5Rho[9]          );
        printRow("      | Getting Theta Time",  pointCPTheta[9],            pointCP2Theta[9],           pointCP3Theta[9],           pointCP5Theta[9]        );
        printRow("      | Distance Time",       pointCPDistance[9],         pointCP2Distance[9],        pointCP3Distance[9],        pointCP5Distance[9]     );
        printRow("      | Rotation Time",       pointCPRotate[9],           pointCP2Rotate[9],          pointCP3Rotate[9],          pointCP5Rotate[9]       );
        System.out.println("-----------------------------------------------------------------------");
	}

    /*
     * Prints a row of the table
     */
    public static void printRow(String label, long value1, long value2, long value3, long value5) {
        System.out.printf("%-27s | %8d | %8d | %8d | %8d%n", label, value1, value2, value3, value5);
    }
}