package Tiralabra.domain;

/**
 * Basic building block of labyrinths
 * 
 * @author samisaukkonen
 */
public class Node {
    public int x;
    public int y;
    public int value;
    public Node parent;
    
    /**
     * 
     * @param x x-placement in labyrinth
     * @param y y-placement in labyrinth
     * @param value value in this node, color codes found in LabyrinthDrawer
     * @param parent parent of this node, at start it is null but when we reach a node we replace it with the previous node
     */
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
