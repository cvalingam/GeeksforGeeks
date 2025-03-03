class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> obj = new ArrayList<>();
        int max = arr[0];
        int min = arr[0];
        dq.addFirst(0);

        Deque<Integer> ans = new LinkedList<>();
        int maxc = 0;

        for (int i = 1; i < arr.length; i++) {
            if ((Math.abs(arr[i] - max) <= x) && (Math.abs(arr[i] - min) <= x)) {
                dq.addLast(i);
                min = (min < arr[i]) ? min : arr[i];
                max = (max > arr[i]) ? max : arr[i];
            } else {
                if (dq.size() > maxc) {
                    maxc = dq.size();
                    ans = new LinkedList<>(dq);
                } else if (dq.size() == maxc && ans.getFirst() > dq.getFirst())
                    ans = new LinkedList<>(dq);

                Deque<Integer> dq2 = new LinkedList<>();
                min = arr[i];
                max = arr[i];
                while (dq.peekLast() != null && Math.abs(arr[dq.peekLast()] - arr[i]) <= x) {
                    dq2.addFirst(dq.pollLast());
                    if (arr[dq2.peekFirst()] > max)
                        max = arr[dq2.getFirst()];
                    if (arr[dq2.peekFirst()] < min)
                        min = arr[dq2.getFirst()];
                }
                dq2.addLast(i);
                dq.clear();
                dq = dq2;
            }
            // System.out.println(dq+" "+ans);
        }

        if (dq.size() > maxc) {
            maxc = dq.size();
            ans = new LinkedList<>(dq);
        } else if (dq.size() == maxc && ans.getFirst() > dq.getFirst())
            ans = new LinkedList<>(dq);

        for (int i : ans)
            obj.add(arr[i]);

        return obj;
    }
}