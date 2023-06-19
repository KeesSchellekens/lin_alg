import java.util.Random;
import org.apache.commons.math3.linear.*;

public class Algebra {
    public static void main(String[] args) {
		final int SIZE = 2000;
        Random rand = new Random();
		double[][] array = new double[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				array[i][j] = rand.nextDouble();
			}
		}
        computeEigenvalues(array);
		//computeRREF(array);
    }

    static void computeEigenvalues(double[][] array) {
        EigenDecomposition decomposition;
		long begin = System.currentTimeMillis();
		RealMatrix testMatrix = MatrixUtils.createRealMatrix(array);
		decomposition = new EigenDecomposition (testMatrix);
		long time = System.currentTimeMillis() - begin;
		System.out.println(time);

    }

    void loopSimple() {

    }

    static void computeRREF(double[][] array) {
		long begin = System.currentTimeMillis();
		RREF.rref(array);
		long time = System.currentTimeMillis() - begin;
		System.out.println(time);
    }

    
}