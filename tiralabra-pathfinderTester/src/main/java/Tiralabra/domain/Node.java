package Tiralabra.domain;

/**
 * Basic building block of labyrinths
 * 
 * @author samisaukkonen
 */
public class Node implements Comparable<Node> {
    public int x;
    public int y;
    public int value;
    public Node parent;
    public int distanceToGoal;
    public int shortestPath;
    
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
        this.distanceToGoal = Integer.MAX_VALUE;
        this.shortestPath = Integer.MAX_VALUE;
    }
    
    /**
     * return current path length plus length to goal
     * 
     * @return current path length plus length to goal
     */
    public int getCombinedPosValue() {
        return shortestPath + distanceToGoal;
    }
    
    /**
     * @param target target node
     * @return distance to targetNode from this node
     */
    public int distanceToNode(Node target) {
        int currentDistance = x + y;
        int currentTargetDistance = target.x + target.y;
        
        return Math.abs(currentTargetDistance - currentDistance);
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

    @Override
    public int compareTo(Node o) {
        return getCombinedPosValue() - o.getCombinedPosValue();
    }
}
