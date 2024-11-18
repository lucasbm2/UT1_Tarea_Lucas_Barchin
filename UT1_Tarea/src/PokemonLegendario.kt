class PokemonLegendario(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val specialAttack: String,
    val hiddenAbility: String
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        return "$superInfo, Special Attack: $specialAttack, Hidden Ability: $hiddenAbility"
    }
}
