class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] arr, int target, int idx,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        // target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // out of bounds or target negative
        if (idx == arr.length || target < 0) {
            return;
        }

        // pick current element
        temp.add(arr[idx]);

        backtrack(arr, target - arr[idx], idx, temp, ans);

        temp.remove(temp.size() - 1);

        // skip current element
        backtrack(arr, target, idx + 1, temp, ans);
    }
}