import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int ans = 0;
		int min = arr[0][0];
		int max = arr[0][1];
		for (int i = 1; i < N; i++) {

			if (max < arr[i][0]) {
				ans += max - min;
				min = arr[i][0];
				max = arr[i][1];
			} else if (max >= arr[i][0]) {
				if (max < arr[i][1]) {
					max = arr[i][1];
				}
			}
		}
		ans += (max - min);
		System.out.println(ans);
	}

}
