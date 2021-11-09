package co.edu.eam.mytestapp.model.pokemon

class Pokemon(var id:Int, var name:String, var weight:Int, var types:List<PokemonType>) {
    var image:String = ""
    var icon:String = ""
    var pokemonColor:String = ""

    override fun toString(): String {
        return "Pokemon(id=$id, name='$name', weight=$weight, image='$image')"
    }

}