import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class 카드섞기 {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i <= 9; i++) {
            if (Math.pow(2, i) >= n) {
                break;
            }
            for (int j = 0; j <= 9; j++) {
                if (Math.pow(2, j) >= n) {
                    break;
                }
                Queue<Integer> queue = new LinkedList<>();
                for (int k = n; k >= 1; k--) {
                    queue.add(k);
                }
                dfs(i, queue);
                dfs(j, queue);
                boolean isOk = true;
                for (int k = n - 1; k >= 0; k--) {
                    if (arr[k] != queue.poll()) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    static void dfs(int x, Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>();
        int num = (int) Math.pow(2, x);
        for (int i = 0; i < num; i++) {
            temp.add(queue.poll());
        }
        while (num > 1) {
            num /= 2;
            for (int i = 0; i < num; i++) {
                temp.add(temp.poll());
            }
            for (int i = 0; i < num; i++) {
                queue.add(temp.poll());
            }
        }
        queue.add(temp.poll());
    }
}