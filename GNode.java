package cisco;

/**
 * This interface definition is given as defining a graph. The GNode is acyclic by definition.
 * 
 * @author Shyam Bharti
 */
public interface GNode {

	public String getName();
	  /**
     * This method returns an array of children GNodes. When a GNode has no children,
     * it returns an array of size 0.
     *
     * @return
     */
    public GNode[] getChildren();

}
