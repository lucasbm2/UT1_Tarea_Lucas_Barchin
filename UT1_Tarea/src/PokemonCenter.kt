class PokemonCenter {
    private val pokemons = Array<Pokemon?>(100) { null }

    fun registerPokemon(pokemon: Pokemon): Boolean {
        for (i in 0..99) {
            //IF THE POKEMON SPACE IS NULL, IT MEANS THAT CAPACITY IS FULL
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
        val resultList = ArrayList<String>()

        for (pokemon in pokemons) {
            //CHECK THAT POKEMON ISN´T NULL TO SHOW HIS INFO, NULL SPACES WON´T BE SHOWED
            if (pokemon != null) {
                resultList.add(pokemon.returnInfoString())
            }
        }
        return resultList
    }

    //STRING? BECAUSE ID COULD BE NULL
    fun pokemonInfo(id: String): String? {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (pokemon.id == id) {
                    return pokemon.returnInfoString()
                }
            }
        }
        println("The pokemon not exists")
        return null
    }

}
