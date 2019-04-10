<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private $weight;

  //Vote Associations
  private $user;
  private $exhibition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aWeight = null, $aUser = null, $aExhibition = null)
  {
    if (func_num_args() == 0) { return; }

    $this->weight = $aWeight;
    if ($aUser == null || $aUser->getVote() != null)
    {
      throw new Exception("Unable to create Vote due to aUser");
    }
    $this->user = $aUser;
    if ($aExhibition == null || $aExhibition->getVote() != null)
    {
      throw new Exception("Unable to create Vote due to aExhibition");
    }
    $this->exhibition = $aExhibition;
  }
  public static function newInstance($aWeight, $aIdForUser, $aNameForUser, $aTypeForUser, $aIdForExhibition, $aNameForExhibition, $aDescriptionForExhibition)
  {
    $thisInstance = new Vote();
    $thisInstance->weight = $aWeight;
    $thisInstance->user = new User($aIdForUser, $aNameForUser, $aTypeForUser, $thisInstance);
    $thisInstance->exhibition = new Exhibition($aIdForExhibition, $aNameForExhibition, $aDescriptionForExhibition, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setWeight($aWeight)
  {
    $wasSet = false;
    $this->weight = $aWeight;
    $wasSet = true;
    return $wasSet;
  }

  public function getWeight()
  {
    return $this->weight;
  }

  public function getUser()
  {
    return $this->user;
  }

  public function getExhibition()
  {
    return $this->exhibition;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingUser = $this->user;
    $this->user = null;
    if ($existingUser != null)
    {
      $existingUser->delete();
    }
    $existingExhibition = $this->exhibition;
    $this->exhibition = null;
    if ($existingExhibition != null)
    {
      $existingExhibition->delete();
    }
  }

}
?>