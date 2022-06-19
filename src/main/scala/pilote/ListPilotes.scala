package pilote

import myList._

class ListPilotes(pilotes: MyList[Pilote]) {

  override def toString: String = s"ListPilotes -> $pilotes"

  def filterPilotes() = println
  def ajoutePilotes() = println
  def supprimePilotes() = println()

}
