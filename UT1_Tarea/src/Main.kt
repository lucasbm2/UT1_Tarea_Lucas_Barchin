fun main() {
    val centerPokemon = PokemonCenter()

    val lucas = Trainer("Lucas", "Barchin Molina", 2)

    val pikachu1 = PokemonComun(lucas, 10, "1", "Electric", listOf("Ray", "Punch", "Vision"))
    val pikachu2 = PokemonEspecial(lucas, 10, "2", "Electric", "Highlight ray")
    val pikachu3 = PokemonLegendario(lucas, 10, "3", "Electric", "Attacked ray", "Invisibility")

    centerPokemon.registerPokemon(pikachu1)
    centerPokemon.registerPokemon(pikachu2)
    centerPokemon.registerPokemon(pikachu3)

    //TEST 1 METHOD
//    val pokemons = listOf(pikachu1, pikachu2, pikachu3)
//
//    for (pokemon in pokemons) {
//        println(pokemon.returnInfoString())
//    }

    //TEST 2 METHOD
//    val pokemonsInfo = centerPokemon.listPokemon()
//
//    for (infoPok in pokemonsInfo) {
//        println(infoPok)
//    }

}
