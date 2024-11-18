class PokemonComun(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val objectsEquipped: List<String>
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        val objectsList = objectsEquipped.joinToString { "," }
        return "$superInfo, Equipped objects: ${objectsList}}"
    }
}