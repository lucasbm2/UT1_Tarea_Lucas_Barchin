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
                                pokemonType,
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
                                pokemonType,
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