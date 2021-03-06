package model;
import java.io.File;
import java.io.Serializable;

/**
 * This class handles the reviews for each manuscript.
 * @author lorenzo pacis
 * @version 4.28.2017
 */
public class Review implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003250823600981704L;

	/**
	 * The reviewers myReviewerID.
	 */
	private String myReviewerID;
	
	/**
	 * The review file.
	 */
	private File review;
	
	/**
	 * Creates a new reviewe object using the myReviewerID.
	 * @param theUserID
	 */
	public Review(String theUserID) {
		
		myReviewerID = theUserID;
	}
	
	/**
	 * Gets the reviewers user ID.
	 * @return The myReviewerID of the reviewer.
	 */
	public String getUserID (){
		return myReviewerID;
	}
	
	/**
	 * Gets the review file for the manuscript.
	 * @return The review file.
	 */ 
	public File getReview() {
		
		return review;
	}
	
}
