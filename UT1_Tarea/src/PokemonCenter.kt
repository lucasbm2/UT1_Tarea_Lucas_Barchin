class PokemonCenter {
    private val pokemons = Array<Pokemon?>(100) { null }

    fun registerPokemon(pokemon: Pokemon): Boolean {
        for (i in 0..99) {
            if (pokemons[i] == null) {
                pokemons[i] = pokemon
                println("Pokemon registered successfully")
                return true
            }
        }
        println("Error registering pokemon, full capacity")
        return false
    }

    fun listPokemon(): List<String> {
        val resultList = mutableListOf<String>()

        for (pokemon in pokemons) {
            //CHECK THAT POKEMON ISN´T NULL TO SHOW HIS INFO, NULL SPACES WON´T BE SHOWED
            if (pokemon != null) {
                resultList.add(pokemon.returnInfoString())
            }
        }

        return resultList
    }
}
