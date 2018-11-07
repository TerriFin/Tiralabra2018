package Tiralabra.domain;

public class Node {
    private int x;
    private int y;
    private int value;
    
    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }
    
    @Override
    public boolean equals(Object object) {
        Node comparedNode = (Node) object;
        if (comparedNode.hashCode() == this.hashCode()) {
            return true;
        } else {
            return false;
        }
    }
}
