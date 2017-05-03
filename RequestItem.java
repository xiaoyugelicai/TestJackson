package vo;

/**
 * This class was used to generate item content of body message.
 * @author hualei
 *
 */
public class RequestItem {
	private String id;
	private String content;
	private String tele;
	private String model;
	private String timing;
	private String reply;
	private String priority;
	
	/**
	 * Constructor
	 * @param id
	 * @param content
	 * @param tele
	 * @param model
	 * @param timing
	 * @param reply
	 * @param priority
	 */
	public RequestItem(String id, String content, String tele, String model, String timing, String reply,
			String priority) {
		super();
		this.id = id;
		this.content = content;
		this.tele = tele;
		this.model = model;
		this.timing = timing;
		this.reply = reply;
		this.priority = priority;
	}

	/**
	 * Default Constructor
	 */
	public RequestItem() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the tele
	 */
	public String getTele() {
		return tele;
	}

	/**
	 * @param tele the tele to set
	 */
	public void setTele(String tele) {
		this.tele = tele;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the timing
	 */
	public String getTiming() {
		return timing;
	}

	/**
	 * @param timing the timing to set
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}

	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestItem [id=" + id + ", content=" + content + ", tele=" + tele + ", model=" + model + ", timing="
				+ timing + ", reply=" + reply + ", priority=" + priority + "]";
	}
	
}
