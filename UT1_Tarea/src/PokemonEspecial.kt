class PokemonEspecial(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val specialPower: Int
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        return "$superInfo, Special Power: $specialPower"
    }
}
