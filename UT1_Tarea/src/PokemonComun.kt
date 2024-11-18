class PokemonComun(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val objectsEquipped: List<String>
) : Pokemon(trainer, level, id, type), Printable {
    override fun returnInfoString(): String {
        return "Pokemon Comun: $id, Tipo: $type, Nivel: $level"
    }
}
