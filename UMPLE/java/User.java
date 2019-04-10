/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

package expo;

// line 11 "../expo.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String id;
  private String name;
  private String type;

  //User Associations
  private Vote vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aId, String aName, String aType, Vote aVote)
  {
    id = aId;
    name = aName;
    type = aType;
    if (aVote == null || aVote.getUser() != null)
    {
      throw new RuntimeException("Unable to create User due to aVote");
    }
    vote = aVote;
  }

  public User(String aId, String aName, String aType, int aWeightForVote, Exhibition aExhibitionForVote)
  {
    id = aId;
    name = aName;
    type = aType;
    vote = new Vote(aWeightForVote, this, aExhibitionForVote);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetOne */
  public Vote getVote()
  {
    return vote;
  }

  public void delete()
  {
    Vote existingVote = vote;
    vote = null;
    if (existingVote != null)
    {
      existingVote.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "vote = "+(getVote()!=null?Integer.toHexString(System.identityHashCode(getVote())):"null");
  }
}