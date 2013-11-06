/*
 * Class Highway contains algorithm (methods) to solve problem 
 * if it is possible to build expected highways
 */
public class Highway {

	/*
	 *  public int possible_to_build() - method give an answer to question that is possible
	 *  to build highway on the north or south of the existing road.
	 *  
	 *  return 0 or 1
	 *  0 if building highways is impossible
	 *  1 if building highways is possible
	 *  
	 *  city_connection - two dimensional array with expected road connections 
	 *  (e.g. city_connection[[1,3][4,2]) means that is wanted to build connection between cities 1,3 and 4,2)
	 */
	public static int possible_to_build(int[][] city_connection) {
		
		int[][] builded_highways_north = new int[city_connection.length][2];
		int[][] builded_highways_south = new int[city_connection.length][2];
		builded_highways_north[0] = city_connection[0];
		
		for (int i = 1; i < city_connection.length; i++) {
			int counter_north = 1;
			int counter_south = 0;
			if (check_if_cross(builded_highways_north, city_connection[i])) {
				if (check_if_cross(builded_highways_south, city_connection[i])) {
					return 0;
				} else {
					builded_highways_south[counter_south] = city_connection[i];
					counter_south++;
				}
			} else {
				builded_highways_south[counter_north] = city_connection[i];
				counter_north++;
			}
		}
		return 1;
	}

	/*
	 * public boolean check_if_cross() - check if it is possible to build the highway on north or south
	 * 
	 * return 0 or 1
	 * 0 if building highway is impossible
	 * 1 if building highway is possible
	 * 
	 * existing_highways - array with highways which are already builded
	 * expected_highway - array with number of cities which we want to build highway between
	 */
	public static boolean check_if_cross(int[][] existing_highways,
			int[] expected_highway) {

		for (int i = 0; i < existing_highways.length; i++) {

			if (((expected_highway[0] > existing_highways[i][0] && expected_highway[0] < existing_highways[i][1]) || (expected_highway[1] > existing_highways[i][0] && expected_highway[1] < existing_highways[i][1]))
					&& !(expected_highway[0] >= existing_highways[i][0] && expected_highway[1] <= existing_highways[i][1])) {
				return true;
			}
		}
		return false;
	}

}
