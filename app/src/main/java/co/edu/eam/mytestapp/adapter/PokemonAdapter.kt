package co.edu.eam.mytestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.mytestapp.databinding.ItemPokemonBinding
import co.edu.eam.mytestapp.model.pokemon.Pokemon
import com.bumptech.glide.Glide

class PokemonAdapter(var lista:Array<Pokemon?>):RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemPokemonBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPokemon(lista.get(position))
    }

    override fun getItemCount(): Int = lista.size

    inner class ViewHolder(var view:ItemPokemonBinding):RecyclerView.ViewHolder(view.root){

        fun bindPokemon(pokemon: Pokemon?){
            if(pokemon!=null) {
                Glide.with(view.imgPoke.context)
                    .load(pokemon.image)
                    .into(view.imgPoke)
                view.numPoke.text = pokemon.id.toString()
                view.namePoke.text = pokemon.name
            }
        }
    }
}