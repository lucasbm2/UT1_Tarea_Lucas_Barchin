class PokemonComun(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val objectsEquipped: String
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        return "$superInfo, Equipped objects: $objectsEquipped"
    }
}
