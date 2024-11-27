class PokemonCenter {
    private val pokemons = Array<Pokemon?>(100) { null }

    //Register a pokemon
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

    //List of registered pokemon
    fun listPokemon(): List<String> {
        val listResul = ArrayList<String>()
        println("List of registered Pokémon:")

        for (pokemon in pokemons) {
            if (pokemon != null) {
                val info = "${pokemon.idPokemon}, ${pokemon.trainer.name}, ${pokemon.level}"
                println(info)
                with(listResul) { add(info) }
            }
        }
        return listResul
    }

    // Obtain detailed information about a pokemon
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

    // Increase the level of a pokemon
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

    // Decrease the level of a pokemon
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

    // Check the current level of a pokemon
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
