package Tiralabra.domain;

public class Node {
    public int x;
    public int y;
    public int value;
    public Node parent;
    
    public Node(int x, int y, int value, Node parent) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.parent = parent;
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt(x + "" + y);
    }
    
    @Override
    public boolean equals(Object object) {
        Node comparedNode = (Node) object;
        return this.hashCode() == comparedNode.hashCode();
    }
}
