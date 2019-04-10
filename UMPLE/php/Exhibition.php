<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Exhibition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Exhibition Attributes
  private $id;
  private $name;
  private $description;
  private $creators;
  private $photos;

  //Exhibition Associations
  private $vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId = null, $aName = null, $aDescription = null, $aVote = null)
  {
    if (func_num_args() == 0) { return; }

    $this->id = $aId;
    $this->name = $aName;
    $this->description = $aDescription;
    $this->creators = array();
    $this->photos = array();
    if ($aVote == null || $aVote->getExhibition() != null)
    {
      throw new Exception("Unable to create Exhibition due to aVote");
    }
    $this->vote = $aVote;
  }
  public static function newInstance($aId, $aName, $aDescription, $aWeightForVote, $aUserForVote)
  {
    $thisInstance = new Exhibition();
    $thisInstance->id = $aId;
    $thisInstance->name = $aName;
    $thisInstance->description = $aDescription;
    $thisInstance->creators = array();
    $thisInstance->photos = array();
    $thisInstance->vote = new Vote($aWeightForVote, $aUserForVote, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setDescription($aDescription)
  {
    $wasSet = false;
    $this->description = $aDescription;
    $wasSet = true;
    return $wasSet;
  }

  public function addCreator($aCreator)
  {
    $wasAdded = false;
    $this->creators[] = $aCreator;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeCreator($aCreator)
  {
    $wasRemoved = false;
    unset($this->creators[$this->indexOfCreator($aCreator)]);
    $this->creators = array_values($this->creators);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function addPhoto($aPhoto)
  {
    $wasAdded = false;
    $this->photos[] = $aPhoto;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removePhoto($aPhoto)
  {
    $wasRemoved = false;
    unset($this->photos[$this->indexOfPhoto($aPhoto)]);
    $this->photos = array_values($this->photos);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDescription()
  {
    return $this->description;
  }

  public function getCreator($index)
  {
    $aCreator = $this->creators[$index];
    return $aCreator;
  }

  public function getCreators()
  {
    $newCreators = $this->creators;
    return $newCreators;
  }

  public function numberOfCreators()
  {
    $number = count($this->creators);
    return $number;
  }

  public function hasCreators()
  {
    $has = creators.size() > 0;
    return $has;
  }

  public function indexOfCreator($aCreator)
  {
    $rawAnswer = array_search($aCreator,$this->creators);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getPhoto($index)
  {
    $aPhoto = $this->photos[$index];
    return $aPhoto;
  }

  public function getPhotos()
  {
    $newPhotos = $this->photos;
    return $newPhotos;
  }

  public function numberOfPhotos()
  {
    $number = count($this->photos);
    return $number;
  }

  public function hasPhotos()
  {
    $has = photos.size() > 0;
    return $has;
  }

  public function indexOfPhoto($aPhoto)
  {
    $rawAnswer = array_search($aPhoto,$this->photos);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getVote()
  {
    return $this->vote;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingVote = $this->vote;
    $this->vote = null;
    if ($existingVote != null)
    {
      $existingVote->delete();
    }
  }

}
?>