class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length / 3;

        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > n)
                result.add(entry.getKey());
        }

        return result;
    }
}
