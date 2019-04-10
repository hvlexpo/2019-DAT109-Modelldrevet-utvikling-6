<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private $id;
  private $name;
  private $type;

  //User Associations
  private $vote;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId = null, $aName = null, $aType = null, $aVote = null)
  {
    if (func_num_args() == 0) { return; }

    $this->id = $aId;
    $this->name = $aName;
    $this->type = $aType;
    if ($aVote == null || $aVote->getUser() != null)
    {
      throw new Exception("Unable to create User due to aVote");
    }
    $this->vote = $aVote;
  }
  public static function newInstance($aId, $aName, $aType, $aWeightForVote, $aExhibitionForVote)
  {
    $thisInstance = new User();
    $thisInstance->id = $aId;
    $thisInstance->name = $aName;
    $thisInstance->type = $aType;
    $thisInstance->vote = new Vote($aWeightForVote, $thisInstance, $aExhibitionForVote);
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

  public function setType($aType)
  {
    $wasSet = false;
    $this->type = $aType;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getType()
  {
    return $this->type;
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