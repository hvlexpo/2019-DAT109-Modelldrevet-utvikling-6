/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

package expo;
import java.util.*;

// line 17 "../expo.ump"
public class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private int weight;

  //Vote Associations
  private User user;
  private Exhibition exhibition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vote(int aWeight, User aUser, Exhibition aExhibition)
  {
    weight = aWeight;
    if (aUser == null || aUser.getVote() != null)
    {
      throw new RuntimeException("Unable to create Vote due to aUser");
    }
    user = aUser;
    if (aExhibition == null || aExhibition.getVote() != null)
    {
      throw new RuntimeException("Unable to create Vote due to aExhibition");
    }
    exhibition = aExhibition;
  }

  public Vote(int aWeight, String aIdForUser, String aNameForUser, String aTypeForUser, String aIdForExhibition, String aNameForExhibition, String aDescriptionForExhibition)
  {
    weight = aWeight;
    user = new User(aIdForUser, aNameForUser, aTypeForUser, this);
    exhibition = new Exhibition(aIdForExhibition, aNameForExhibition, aDescriptionForExhibition, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWeight(int aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public int getWeight()
  {
    return weight;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetOne */
  public Exhibition getExhibition()
  {
    return exhibition;
  }

  public void delete()
  {
    User existingUser = user;
    user = null;
    if (existingUser != null)
    {
      existingUser.delete();
    }
    Exhibition existingExhibition = exhibition;
    exhibition = null;
    if (existingExhibition != null)
    {
      existingExhibition.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "weight" + ":" + getWeight()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "exhibition = "+(getExhibition()!=null?Integer.toHexString(System.identityHashCode(getExhibition())):"null");
  }
}