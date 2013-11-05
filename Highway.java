public class Highway {

	public static int possible_to_build(int[][] city_connection,
			int[][] builded_highways_north, int[][] builded_highways_south) {
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
