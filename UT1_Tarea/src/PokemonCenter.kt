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

        for (pokemon in pokemons) {
            //CHECK THAT POKEMON ISN´T NULL TO SHOW HIS INFO, NULL SPACES WON´T BE SHOWED
            if (pokemon != null) {
                listResul.add(pokemon.returnInfoString())
                println("List of registered Pokémon:")
                listResul.forEach { println(it) }
            }
        }
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

class Menu(val pokemonCenter: PokemonCenter) {

    fun displayMenu() {
        var option: Int
        do {
            println(
                """
    1. Register a Pokémon
    2. List of registered pokemon
    3. Obtain detailed information about a Pokémon
    4. Increase the level of a Pokémon
    5. Decrease the level of a Pokémon
    6. Check the current level of a Pokémon
    7. Exit
    Choose an option:
    """
            )
            option = readLine()?.toIntOrNull() ?: 0

            when (option) {
                1 -> {
                    println("Trainer name:")
                    val trainerName = readLine() ?: ""

                    println("Trainer Lastname:")
                    val trainerLastName = readLine() ?: ""

                    println("Trainer Number:")
                    val numberTrainer = readLine()?.toIntOrNull() ?: 0

                    println("Pokémon ID:")
                    val idPokemon = readLine()?.trim() ?: ""

                    val regex = Regex("^P\\d{4}$")
                    if (idPokemon.isEmpty() || !regex.matches(idPokemon)) {
                        println("Error registering Pokémon, format PXXXX")
                        return
                    }

                    println("Pokémon name:")
                    val name = readLine() ?: ""

                    println("Pokémon Level:")
                    val level = readLine()?.toIntOrNull() ?: 1

                    println("Pokémon type (Common, Special, Legendary):")
                    val pokemonType = readLine() ?: ""

                    val pokemon: Pokemon? = when (pokemonType) {
                        "Common" -> {
                            println("Objects equipped:")
                            val objectsEquipped = readLine() ?: ""
                            PokemonComun(
                                Trainer(trainerName, trainerLastName, numberTrainer),
                                level,
                                idPokemon,
                                name,
                                objectsEquipped
                            )
                        }

                        "Special" -> {
                            println("Special power:")
                            val specialPower = readLine() ?: ""
                            PokemonEspecial(
                                Trainer(trainerName, trainerLastName, numberTrainer),
                                level,
                                idPokemon,
                                name,
                                specialPower
                            )
                        }

                        "Legendary" -> {
                            println("Special attack:")
                            val specialAttack = readLine() ?: ""
                            println("Hidden ability:")
                            val hiddenAbility = readLine() ?: ""
                            PokemonLegendario(
                                Trainer(trainerName, trainerLastName, numberTrainer),
                                level,
                                idPokemon,
                                name,
                                specialAttack,
                                hiddenAbility
                            )
                        }

                        else -> {
                            println("Error type pokemon")
                            return
                        }
                    }

                    if (pokemon != null && pokemonCenter.registerPokemon(pokemon)) {
                        println("Pokémon registered successfully!")
                    } else {
                        println("Failed to register Pokémon.")
                    }
                }

                2 -> pokemonCenter.listPokemon()
                3 -> {
                    println("Pokémon ID:")
                    val id = readLine() ?: ""
                    println(pokemonCenter.pokemonInfo(id))
                }

                4 -> {
                    println("Pokémon ID:")
                    val id = readLine() ?: ""
                    println("Level increase:")
                    val levelIncrease = readLine()?.toIntOrNull() ?: 0
                    pokemonCenter.increaseLevel(id, levelIncrease)

                }

                5 -> {
                    println("Pokémon ID:")
                    val id = readLine() ?: ""
                    println("Level decrease:")
                    val levelDecrease = readLine()?.toIntOrNull() ?: 0
                    pokemonCenter.decreaseLevel(id, levelDecrease)
                }
                6 -> {
                    println("Pokémon ID:")
                    val id = readLine() ?: ""
                    pokemonCenter.checkLevel(id)
                }

                7 -> println("Exit")
                else -> println("Invalid option. Please try again.")
            }
        } while (option != 7)
    }
}