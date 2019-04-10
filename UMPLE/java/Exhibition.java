/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

package expo;
import java.util.*;

// line 3 "../expo.ump"
public class Exhibition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Exhibition Attributes
  private String id;
  private String name;
  private String description;
  private List<User> creators;
  private List<String> photos;

  //Exhibition Associations
  private Vote vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Exhibition(String aId, String aName, String aDescription, Vote aVote)
  {
    id = aId;
    name = aName;
    description = aDescription;
    creators = new ArrayList<User>();
    photos = new ArrayList<String>();
    if (aVote == null || aVote.getExhibition() != null)
    {
      throw new RuntimeException("Unable to create Exhibition due to aVote");
    }
    vote = aVote;
  }

  public Exhibition(String aId, String aName, String aDescription, int aWeightForVote, User aUserForVote)
  {
    id = aId;
    name = aName;
    description = aDescription;
    creators = new ArrayList<User>();
    photos = new ArrayList<String>();
    vote = new Vote(aWeightForVote, aUserForVote, this);
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addCreator(User aCreator)
  {
    boolean wasAdded = false;
    wasAdded = creators.add(aCreator);
    return wasAdded;
  }

  public boolean removeCreator(User aCreator)
  {
    boolean wasRemoved = false;
    wasRemoved = creators.remove(aCreator);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addPhoto(String aPhoto)
  {
    boolean wasAdded = false;
    wasAdded = photos.add(aPhoto);
    return wasAdded;
  }

  public boolean removePhoto(String aPhoto)
  {
    boolean wasRemoved = false;
    wasRemoved = photos.remove(aPhoto);
    return wasRemoved;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template attribute_GetMany */
  public User getCreator(int index)
  {
    User aCreator = creators.get(index);
    return aCreator;
  }

  public User[] getCreators()
  {
    User[] newCreators = creators.toArray(new User[creators.size()]);
    return newCreators;
  }

  public int numberOfCreators()
  {
    int number = creators.size();
    return number;
  }

  public boolean hasCreators()
  {
    boolean has = creators.size() > 0;
    return has;
  }

  public int indexOfCreator(User aCreator)
  {
    int index = creators.indexOf(aCreator);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getPhoto(int index)
  {
    String aPhoto = photos.get(index);
    return aPhoto;
  }

  public String[] getPhotos()
  {
    String[] newPhotos = photos.toArray(new String[photos.size()]);
    return newPhotos;
  }

  public int numberOfPhotos()
  {
    int number = photos.size();
    return number;
  }

  public boolean hasPhotos()
  {
    boolean has = photos.size() > 0;
    return has;
  }

  public int indexOfPhoto(String aPhoto)
  {
    int index = photos.indexOf(aPhoto);
    return index;
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
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "vote = "+(getVote()!=null?Integer.toHexString(System.identityHashCode(getVote())):"null");
  }
}