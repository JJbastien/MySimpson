package com.example.code_base_sdk.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.code_base_sdk.R
import com.example.code_base_sdk.databinding.CharacterItemBinding
import com.example.code_base_sdk.model.domain.DomainChar

class AppAdapter(
    private val characters: MutableList<DomainChar> = mutableListOf(),
    private val itemClicked: (DomainChar) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    fun updateItems(newItems: List<DomainChar>) {
        characters.clear()
        characters.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bindCharacter(characters[position], itemClicked)
}

class ItemViewHolder(
    private val binding: CharacterItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindCharacter(item: DomainChar, itemClicked: (DomainChar) -> Unit) {
        binding.charName.text = item.name

        when(item.color) {
            1 -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
            2 -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
            3 -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
            4 -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
            5  -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
            6 -> {
                binding.root.setCardBackgroundColor(
                    binding.root.context.getColor(R.color.purple_200)
                )
            }
        }

        itemView.setOnClickListener {
            itemClicked(item)
        }
    }

}