package vo;

/**
 * This class was used to generate head content of body message.
 * @author hualei
 *
 */
public class RequestH {
	
	/**
	 * The variable was used to receive version.
	 */
	private String ver;
	/**
	 * The variable was used to receive user. 
	 */
	private String user;
	/**
	 * The variable was used to receive password. 
	 */
	private String pass;
	
	/**
	 * Constructor
	 * @param ver
	 * @param user
	 * @param pass
	 */
	public RequestH(String ver, String user, String pass) {
		super();
		this.ver = ver;
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * Default constructor
	 */
	public RequestH() {
		super();
	}

	/**
	 * @return the ver
	 */
	public String getVer() {
		return ver;
	}

	/**
	 * @param ver the ver to set
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestH [ver=" + ver + ", user=" + user + ", pass=" + pass + "]";
	}
	
}
