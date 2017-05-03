package vo;

import java.util.Arrays;
import java.util.List;

/**
 * This class was used to generate body message.
 * @author hualei
 *
 */
public class RequestReq {
	
	private String op;
	private RequestH h;
	private List<RequestItem> items;
	
	/**
	 * constructor
	 * @param op
	 * @param h
	 * @param items
	 */
	public RequestReq(String op, RequestH h, List<RequestItem> items) {
		super();
		this.op = op;
		this.h = h;
		this.items = items;
	}
	
	/**
	 * Default constructor
	 */
	public RequestReq() {
		super();
	}

	/**
	 * @return the op
	 */
	public String getOp() {
		return op;
	}

	/**
	 * @param op the op to set
	 */
	public void setOp(String op) {
		this.op = op;
	}

	/**
	 * @return the h
	 */
	public RequestH getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(RequestH h) {
		this.h = h;
	}

	/**
	 * @return the items
	 */
	public List<RequestItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<RequestItem> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestReq [op=" + op + ", h=" + h.toString() + ", items=" + Arrays.toString(items.toArray()) + "]";
	}
	
	
}
