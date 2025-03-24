# 第一题

version1.0:超时 通过36%

```java

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 手套数量
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = scanner.nextInt();
        }
        ArrayList<String> res = new ArrayList<>();
        while (q > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = l; i <= r; i++) {
                Integer count = map.getOrDefault(colors[i], 0) + 1;
                map.put(colors[i], count);
            }
            int min = 0;
            for (Integer value : map.values()) {
                if ((value & 1) == 1) break;
                else min += value / 2;
            }
            int total = (r - l + 1) / 2;
            if (min == total) {
                res.add("yes");
            } else {
                res.add("no");
            }
            q -= 1;
        }
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.println(res.get(i));
        }
        System.out.print(res.get(res.size() - 1));
    }
}

```

## 第二题
