package cisco;

import java.util.ArrayList;
import java.util.Stack;
/**
 * This class implements GNode Interface to solve the conditions given by the query.
 *
 * @author Shyam Bharti
 *
 */
public class GNodeImp implements GNode {

    //Name of the graph node
    private String nodeName;

    //Children in the node
    private GNode[] children;

    //An array of size zero to represent no child in node
    GNode[] EMPTY_LIST = new GNode[0];


    //ArrayList of nodes present in the graph
    private ArrayList<GNode> listOfGNodes = new ArrayList<>();

    //Stack data structure used to implement DFS for getting paths in the graph
    private Stack<GNode> stack = new Stack<>();

    //ArrayList of ArrayList of GNodes representing all possible paths in the graph
    private ArrayList<ArrayList<GNode>> finalNodeList = new ArrayList<>(); //final result

    //ArrayList of GNodes temporarily capturing the possible paths in the graph
    private ArrayList<GNode> tempNodeList = new ArrayList<>(); //temp result


    //constructor
    public GNodeImp(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Setter for the children nodes in the graph
     *
     * @param children
     */
    public void setChildren(GNode[] children) {
        int arrLength = children.length;
        int index = 0; 
        //counter for array index
        this.children = new GNode[arrLength];

        for (GNode child : children) {
            this.children[index] = child;
            index = index + 1;
        }
    }

    @Override
    public String getName() {

        return this.nodeName;
    }

    @Override
    public GNode[] getChildren() {

        if (this.children == null) {
            return EMPTY_LIST;

        } else {
            return this.children;
        }

    }


    /**
     * Returns an ArrayList containing every GNode in the graph
     *
     * @param node
     * @return the Arraylist of every GNode in the graph.
     */
    public ArrayList walkGraph(GNode node) {

        //name of current node
        String currentNodeName = node.getName();

        //add node to the ArrayList
        listOfGNodes.add(node);

        //for each child node, check if it has children nodes and add to list (recursive action)
        for (GNode child : node.getChildren()) {

            walkGraph(child);
        }

        return listOfGNodes;
    }




    /**
     * Returns a ArrayList of ArrayLists of GNodes representing all possible paths through the graph starting at 'node'.
     *
     *
     * @param node
     * @return ArrayList of ArrayLists of GNodes of all possible paths starting at node in the graph
     */
    public ArrayList paths(GNode node) {

        stack.push(node);
        tempNodeList.add(node);

        //recursively explore each node and child nodes
        while (!stack.isEmpty()) {
            GNode currentNode = stack.peek();
            GNode[] children = currentNode.getChildren();
            if (children.length == 0) {
                finalNodeList.add(new ArrayList<GNode>(tempNodeList));
            }
            for(GNode child : children) {
                paths(child);
                //backtrack one step, since we're doing DFS
                stack.pop();
                tempNodeList.remove(tempNodeList.size() - 1);
            }

            break;
        }

        return finalNodeList;
    }




    @Override
    public String toString() {

        return this.getName();
    }


    /**
     * For printing the name of a node to screen
     *
     * @param node
     */
    public void printNode (GNode node) {

        String nodeName = node.getName();
        System.out.println("Node here is " + nodeName);
    }


    /**
     * For printing messages to screen
     *
     * @param msg
     */
    public void printMsg (String msg) {
        System.out.println(msg);
    }
}
