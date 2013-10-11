package secondDay;

public abstract class Plant //if no public auto protected
{
	private String leaves;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Plant [leaves=" + leaves + "]";
	}
	private String roots;
	
	/**
	 * @return the leaves
	 */
	public String getLeaves() 
	{
		return this.leaves;
	}
	/**
	 * @param leaves the leaves to set
	 */
	public void setLeaves(String leaves) 
	{
		this.leaves = leaves;
	}
	/**
	 * @return the roots
	 */
	public String getRoots() 
	{
		return this.roots;
	}
	/**
	 * @param roots the roots to set
	 */
	public void setRoots(String roots) 
	{
		this.roots = roots;
	}
}