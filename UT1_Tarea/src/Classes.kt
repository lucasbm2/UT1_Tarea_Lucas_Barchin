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

class PokemonEspecial(
    trainer: Trainer,
    level: Int,
    id: String,
    type: String,
    val specialPower: String
) : Pokemon(trainer, level, id, type), Printable {

    override fun returnInfoString(): String {
        val superInfo = super.returnInfoString()
        return "$superInfo, Special Power: $specialPower"
    }
}

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
