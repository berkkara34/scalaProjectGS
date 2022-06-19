package pilote

import competition._
import cars._
class Pilote(historique: Map[Course, Int], nom: String, prenom: String, age: Int, voiture: Voiture, experience: Int) {

  override def toString: String = {
    s"Pilote -> historique: $historique, " +
    s"nom: $nom, " +
    s"prenom: $prenom, " +
    s"age: $age, " +
    s"voiture: $voiture, " +
    s"experience: $experience"
    
  def dejaChampion() = println
  def nombreDeVictoire(historique: Map[Course, Int]) =
    historique.values.count(_ == 1)
  def nombreDeFoisEnPodium() = println
  def totalDesGain() = println
  def informationPalmares() = println


}
