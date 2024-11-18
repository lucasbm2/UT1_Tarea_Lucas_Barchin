class PokemonComun(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val objectsEquipped: List<String>
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        //USE OF IT BECAUSE IT REFERS TO EACH OBJECT OF THE LIST
        val objectsList = objectsEquipped.joinToString { it }
        return "$superInfo, Equipped objects: $objectsList"
    }
}