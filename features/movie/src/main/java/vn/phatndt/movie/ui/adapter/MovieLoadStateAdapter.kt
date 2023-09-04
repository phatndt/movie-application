package vn.phatndt.movie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import vn.phatndt.movie.databinding.ItemLoadingBinding

class MovieLoadStateAdapter(
) : LoadStateAdapter<MovieLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ItemLoadingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false,
            ),
        )
    }

    inner class LoadStateViewHolder(private val binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(state: LoadState) {
            binding.progressBar.isVisible = state is LoadState.Error

        }
    }
}