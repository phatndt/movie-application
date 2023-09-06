package vn.phatndt.movie.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.phatndt.movie.databinding.FragmentMovieBinding
import vn.phatndt.movie.ui.adapter.MovieAdapter
import vn.phatndt.movie.ui.adapter.MovieLoadStateAdapter

class MovieListFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private val moveListViewModel: MovieListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter()
        binding.rcvMovie.adapter = movieAdapter
        binding.rcvMovie.setHasFixedSize(true)
        movieAdapter.withLoadStateHeaderAndFooter(
            header = MovieLoadStateAdapter(),
            footer = MovieLoadStateAdapter()
        )
        movieAdapter.addLoadStateListener {
            binding.loading.isVisible = it.refresh is LoadState.Loading
            Log.d("phatndt", it.toString())
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                moveListViewModel.movieListState.collect {
                    movieAdapter.submitData(it)
                }
            }
        }
    }
}