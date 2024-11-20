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

    fun increaseLevel(id: String, levelIncrease: Int): Boolean {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (pokemon.id == id) {
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
                if (levelDecrease > 1) {
                    pokemon.level -= levelDecrease
                    println("Level decreased successfully")
                    return true
                } else {
                    println("Error decreasing should be at less of 1 level")
                    return false
                }
            }
        }
        println("Error decreasing level")
        return false
    }

    fun checkLevel(id: String): Int {
        for (pokemon in pokemons) {
            if (pokemon != null) {
                if (pokemon.id == id) {
                    return pokemon.level
                }
            }
        }
        println("The pokemon not exists")
        return -1

    }
}


