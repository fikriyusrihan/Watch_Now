package com.artwork.space.watchnow.activity.detail.movie
//
//import com.artwork.space.watchnow.ui.detailMovieActivity.DetailMovieViewModel
//import com.artwork.space.watchnow.utils.DataDummy
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.junit.Before
//
//class DetailMovieViewModelTest {
//
//    private lateinit var viewModel: DetailMovieViewModel
//    private val dummyMovie = DataDummy.generateDummyMovie()[0]
//    private val dummyImgUrl = dummyMovie.imageUrl
//
//    @Before
//    fun setUp() {
//        viewModel = DetailMovieViewModel()
//        viewModel.setMovie(dummyImgUrl)
//    }
//
//    @Test
//    fun getMovie() {
//        viewModel.setMovie(dummyImgUrl)
//
//        val movieEntity = viewModel.getMovie()
//        assertNotNull(movieEntity)
//        assertEquals(dummyMovie.title, movieEntity.title)
//        assertEquals(dummyMovie.description, movieEntity.description)
//        assertEquals(dummyMovie.imageUrl, movieEntity.imageUrl)
//        assertEquals(dummyMovie.popularity, movieEntity.popularity)
//        assertEquals(dummyMovie.rating, movieEntity.rating)
//        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
//    }
//}