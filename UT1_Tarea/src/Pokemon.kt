abstract class Pokemon(
    val trainer: Trainer,
    var level: Int,
    val idPokemon: String,
    val type: String
) : Printable {

    override fun returnInfoString(): String {
        return "Trainer: Name: ${trainer.name} Lastname: ${trainer.lastName} Number ${trainer.numberTrainer}, Pokemon Level: $level,Pokemon ID: $idPokemon, Pokemon type: $type"
    }
}
