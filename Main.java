import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner in;

	public static void main(String[] args) throws FileNotFoundException {

		// Check number of arguments.
		if (args.length != 1) {
			System.err.println("Usage: java Main <input_file>");
			System.exit(1);
		}

		int counter = 0;

		in = new Scanner(new BufferedInputStream(new FileInputStream(args[0])));

		int n = in.nextInt();
		int k = in.nextInt();
		int[][] city_connection = new int[k][2];

		while (in.hasNextInt()) {

			int a = in.nextInt();
			int b = in.nextInt();

			city_connection[counter][0] = a;
			city_connection[counter][1] = b;

			counter++;

		}

		for (int i = 0; i < city_connection.length; i++) {
			Arrays.sort(city_connection[i]);
		}

		System.out.println(Highway.possible_to_build(city_connection));
	}
}