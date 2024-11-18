fun main() {
    val centerPokemon = PokemonCenter()

    val lucas = Trainer("Lucas", "Barchin Molina", 2)

    val pikachu1 = PokemonComun(lucas, 10, "1", "Electric", listOf("Ray", "Punch", "Vision"))
    val pikachu2 = PokemonEspecial(lucas, 10, "2", "Electric", "Highlight ray")
    val pikachu3 = PokemonLegendario(lucas, 10, "3", "Electric", "Attacked ray", "Invisibility")

    //TEST 1 METHOD
    centerPokemon.registerPokemon(pikachu1)
    centerPokemon.registerPokemon(pikachu2)
    centerPokemon.registerPokemon(pikachu3)

    //TEST 2 METHOD
    println(centerPokemon.listPokemon())

    //TEST 3 METHOD
//    println(centerPokemon.pokemonInfo("2"))
//    println(centerPokemon.pokemonInfo("1232"))

}
