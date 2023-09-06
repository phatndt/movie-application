package vn.phatndt.movie.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import vn.phatndt.model.entity.Movie
import vn.phatndt.movie.databinding.ItemMovieBinding

class MovieAdapter : PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil) {

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movie: Movie, position: Int) {
            binding.tvMovieName.text = "$position ${movie.title}"
            binding.tvOverview.text = "${movie.overview}"
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}