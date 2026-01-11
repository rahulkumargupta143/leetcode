class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                heap.add(new int[]{distance(points, i, j), i, j});
            }
        }
        int minCost = 0;
        UnionFind uf = new UnionFind(points.length);
        while(!heap.isEmpty()) {
            int[] edge = heap.poll();
            if (uf.union(edge[1], edge[2])) {
                minCost += edge[0];
            }
        }
        
        return minCost;
    }
    
    public int distance(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // return true if we do not get a cycle 
    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return false;
        if (rank[parentX] == rank[parentY]) {
            parent[parentX] = parentY;
            rank[parentY] += 1;
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
        }
        return true;
    }
}