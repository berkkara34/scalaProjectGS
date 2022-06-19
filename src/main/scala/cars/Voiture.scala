package cars

  abstract class Voiture(vitesse: Int,
                         nom: String,
                         acceleration: Int,
                         moteur: Int,
                         prix: Double,
                         nombreDeCourse: Int,
                         marque: String) {

    override def toString: String = {
      s"Voiture -> vitesse: $vitesse, " +
        s"nom: $nom, " +
        s"acceleration: $acceleration, " +
        s"moteur: $moteur, " +
        s"prix: $prix, " +
        s"nombreDeCourse: $nombreDeCourse, " +
        s"marque: $marque"
    }

    def affichage(): Unit = println("In class Voiture")

  }

  class VoitureClassic(vitesse: Int,
                       nom: String,
                       acceleration: Int,
                       moteur: Int,
                       prix: Double,
                       nombreDeCourse: Int,
                       marque: String) extends Voiture(vitesse,
    nom,
    acceleration,
    moteur,
    prix,
    nombreDeCourse,
    marque) {
  }

  class VoitureSport(vitesse: Int,
                     nom: String,
                     acceleration: Int,
                     moteur: Int,
                     prix: Double,
                     nombreDeCourse: Int,
                     marque: String) extends Voiture(vitesse,
    nom,
    acceleration,
    moteur,
    prix,
    nombreDeCourse,
    marque) {
  }

  class VoitureSuperSport(vitesse: Int,
                          nom: String,
                          acceleration: Int,
                          moteur: Int,
                          prix: Double,
                          nombreDeCourse: Int,
                          marque: String) extends Voiture(vitesse,
    nom,
    acceleration,
    moteur,
    prix,
    nombreDeCourse,
    marque) {
  }

  class Test