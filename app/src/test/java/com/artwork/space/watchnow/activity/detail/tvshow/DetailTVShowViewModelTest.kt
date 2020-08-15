package com.artwork.space.watchnow.activity.detail.tvshow
//
//import com.artwork.space.watchnow.ui.detailTVShowActivity.DetailTVShowViewModel
//import com.artwork.space.watchnow.utils.DataDummy
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.junit.Before
//
//class DetailTVShowViewModelTest {
//    private lateinit var viewModel: DetailTVShowViewModel
//    private val dummyTVShow = DataDummy.generateDummyTvShow()[0]
//    private val dummyTVShowImgUrl = dummyTVShow.imageUrl
//
//    @Before
//    fun setUp() {
//        viewModel = DetailTVShowViewModel()
//        viewModel.setTVShow(dummyTVShowImgUrl)
//    }
//
//    @Test
//    fun getTVShow() {
//        viewModel.setTVShow(dummyTVShowImgUrl)
//        val tvShow = viewModel.getTVShow()
//
//        assertNotNull(tvShow)
//        assertEquals(dummyTVShow.title, tvShow.title)
//        assertEquals(dummyTVShow.description, tvShow.description)
//        assertEquals(dummyTVShow.releaseDate, tvShow.releaseDate)
//        assertEquals(dummyTVShow.imageUrl, tvShow.imageUrl)
//        assertEquals(dummyTVShow.popularity, tvShow.popularity)
//        assertEquals(dummyTVShow.rating, tvShow.rating)
//    }
//}