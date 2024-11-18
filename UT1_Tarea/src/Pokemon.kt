open class Pokemon(
    val trainer: Trainer,
    var level: Int,
    val id: String,
    val type: String
) : Printable {

    override fun returnInfoString(): String {
        return "Trainer: ${trainer.name} ${trainer.lastName},Level: $level, ID: $id, Type: $type"
    }
}
