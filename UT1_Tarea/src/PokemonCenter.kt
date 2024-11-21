class PokemonCenter {
    private val pokemons = Array<Pokemon?>(100) { null }

    fun registerPokemon(pokemon: Pokemon): Boolean {
        for (i in 0 until pokemons.size) {
            if (pokemons[i] == null) {
                pokemons[i] = pokemon
                return true
            }
        }
        println("Error registering Pokémon: The Pokémon center is full.")
        return false
    }


    fun listPokemon(): List<String> {
        val listResul = ArrayList<String>()
        println("List of registered Pokémon:")
        for (pokemon in pokemons) {
            //CHECK THAT POKEMON ISN´T NULL TO SHOW HIS INFO, NULL SPACES WON´T BE SHOWED
            if (pokemon != null) {
                listResul.add(pokemon.returnInfoString())
            }
        }
        listResul.forEach { println(it) }

        return listResul
    }

    //STRING? BECAUSE ID COULD BE NULL
    fun pokemonInfo(id: String): String? {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (pokemon.idPokemon == id) {
                    return pokemon.returnInfoString()
                }
            }
        }
        println("The pokemon not exists")
        return null
    }

    fun increaseLevel(id: String, levelIncrease: Int): Boolean {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (pokemon.idPokemon == id) {
                    pokemon.level += levelIncrease
                    println("Level increased successfully")
                    return true
                }
            }
        }
        println("The pokemon not exists")
        return false
    }

    //CHECK THAT POKEMON ISN’T NULL AND CHECK THAT THE LEVEL DECREASE IS AT LEAST 1
    fun decreaseLevel(id: String, levelDecrease: Int): Boolean {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (levelDecrease > 1 && levelDecrease < pokemon.level) {
                    pokemon.level -= levelDecrease
                    println("Level decreased successfully")
                    return true
                } else {
                    println("Error decreasing should be at less of 1 level and should be less than the current level")
                    return false
                }
            }
        }
        println("Error decreasing level")
        return false
    }

    fun checkLevel(id: String): Int {
        for (pokemon in pokemons) {
            if (pokemon != null && pokemon.idPokemon == id) {
                println("Level: ${pokemon.level}")
                return pokemon.level
            }
        }
        println("The pokemon not exists")
        return -1
    }

}
