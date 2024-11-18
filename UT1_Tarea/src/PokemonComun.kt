class PokemonComun(
    entrenador: Entrenador,
    nivel: Int,
    id: String,
    tipo: String,
    val objetosEquipados: List<String>
) : Pokemon(entrenador, nivel, id, tipo), Imprimible {
    override fun devolverInfoString(): String {
        return "Pokemon Comun: $id, Tipo: $tipo, Nivel: $nivel"
    }
}
