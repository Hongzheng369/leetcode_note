class Solution {
    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}


class UF {
    Map<Integer, Integer> parents;
    Map<Integer, Integer> lengths;
    int maxLength;
    public UF(Set<Integer> set) {
        parents = new HashMap<>();
        lengths = new HashMap<>();
        maxLength = 1;
        for (int i : set) {
            parents.put(i, i);
            lengths.put(i, 1);
        }
    }
    public int find(int x) {
        if (parents.get(x) == x) {
            return x;
        }
        parents.put(x, find(parents.get(x)));
        return parents.get(x);
    }
    public void union(int x, int y) {
        if (find(x) == find(y)) {
            return;
        }
        int parX = find(x), parY = find(y);
        parents.put(parX, parY);
        
        lengths.put(parY, lengths.get(parY) + lengths.get(parX));
        maxLength = Math.max(lengths.get(parY), maxLength);
        return;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        UF uf = new UF(set);
        for (int i : set) {
            if (set.contains(i-1)) {
                uf.union(i-1, i);
            }
            if (set.contains(i+1)) {
                uf.union(i, i+1);
            }
        }
        return uf.maxLength;
    }
}