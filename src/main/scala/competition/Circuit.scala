package competition

class Circuit(nom: String, lieu: String, longueur: Double, difficulte: Int) {

  override def toString: String =
    s"Circuit -> nom: $nom, " +
    s"lieu: $lieu, " +
    s"longueur: $longueur, " +
    s"difficulte: $difficulte,"

}
