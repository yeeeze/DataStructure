package DS.Tree;

public class UnionFind {

    public class Node {
        int parent;
        int rank;

        public Node(int newParent, int newRank) {
            this.parent = newParent;
            this.rank = newRank;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    protected Node[] a;

    public UnionFind(Node[] iarray) {
        a = iarray;
    }

    protected int find(int i) {
        if (i != a[i].getParent()) {
            a[i].setParent(find(a[i].getParent()));
        }
        return a[i].getParent();
    }

    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);

        if (iroot == jroot) {
            return;
        }
        if (a[iroot].getRank() > a[jroot].getRank()) {
            a[jroot].setParent(iroot);
        } else if (a[iroot].getRank() < a[jroot].getRank()) {
            a[iroot].setRank(jroot);
        } else {
            a[jroot].setParent(iroot);
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t);
        }
    }
}
