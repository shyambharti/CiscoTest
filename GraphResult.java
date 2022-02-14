package cisco;

import java.util.ArrayList;
/**
 * For Compiling :Java(TM) SE Runtime Environment (build 1.8.0_72-b15)
 *
 * GnodeImp.java is a class that implements the GNode interface (GNode.java) provided.
 *
 *    Assuming the following graph:
 *    A
 *     B
 *      E
 *      F
 *     C
 *      G
 *      H
 *      I
 *     D
 *      J
 *    
 *   Result:
 *   walkGraph(A) = [A, B, E, F, C, G, H, I, D, J]
 *   paths(A) = ( (A B E) (A B F) (A C G) (A C H) (A C I) (A D J) ) 
 * 
 *
 * @author Shyam Bharti
 *
 */
public class GraphResult {



    public static void main(String[] args) {

        //Use the graph given in the conditions as a below:
        //instantiate the graph nodes
        GNodeImp nodeA = new GNodeImp("A");
        GNodeImp nodeB = new GNodeImp("B");
        GNodeImp nodeC = new GNodeImp("C");
        GNodeImp nodeD = new GNodeImp("D");
        GNodeImp nodeE = new GNodeImp("E");
        GNodeImp nodeF = new GNodeImp("F");
        GNodeImp nodeG = new GNodeImp("G");
        GNodeImp nodeH = new GNodeImp("H");
        GNodeImp nodeI = new GNodeImp("I");
        GNodeImp nodeJ = new GNodeImp("J");

        //set children
        GNode[] children_of_nodeA = new GNode[] {nodeB, nodeC, nodeD};
        nodeA.setChildren(children_of_nodeA);

        GNode[] children_of_nodeB = new GNode[] {nodeE, nodeF};
        nodeB.setChildren(children_of_nodeB);

        GNode[] children_of_nodeC = new GNode[] {nodeG, nodeH, nodeI};
        nodeC.setChildren(children_of_nodeC);

        GNode[] children_of_nodeD = new GNode[] {nodeJ};
        nodeD.setChildren(children_of_nodeD);

        
        /* Condition 1: Get an ArrayList of all nodes present in the graph*/
        System.out.println("Solutions to Conditions 1 & 2.");
 
        //walk the graph and get the list of all graph nodes
        ArrayList<GNode> resultNodes = nodeA.walkGraph(nodeA);
        System.out.println("ArrayList of all node in the graph is: " + resultNodes);

        /*Condition 2: Get an ArrayList of ArrayLists representing all sorted paths through the graph starting at 'node'*/
        ArrayList<ArrayList<GNode>> arrayListOfPaths = nodeA.paths(nodeA);
        System.out.println("Sorted paths are: " + arrayListOfPaths);
      
    }
	
}
