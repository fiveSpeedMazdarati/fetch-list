package com.lukebusch.fetchlist

import com.lukebusch.fetchlist.domain.ListDisplayItem
import com.lukebusch.fetchlist.domain.use_case.GetAllListItemsUseCase
import com.lukebusch.fetchlist.presentation.view.viewmodel.MainActivityViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MainActivityViewModelTest {

    //needed this to run test on a view model which uses a flow
    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    // the starting list of items retrieved from API after being mapped to domain objects
    private lateinit var startingList : List<ListDisplayItem>

    @Before
    fun setUpStartingList() {
        startingList = listOf(
        ListDisplayItem("684", "1", "Item 684"),
        ListDisplayItem("755", "2", ""),
        ListDisplayItem("276", "1", "Item 276"),
        ListDisplayItem("680", "3", "Item 680"),
        ListDisplayItem("147", "3", ""),
        ListDisplayItem("685", "1", null)
        )
    }

    // for reference this is how the list should look after it is prepared by the viewModel for display
    val endingList = listOf(
        ListDisplayItem("276", "1", "Item 276"),
        ListDisplayItem("684", "1", "Item 684"),
        ListDisplayItem("680", "3", "Item 680")
    )

    /**
     * Tests to see that the proper number of items are removed from the list
     * Any DisplayListItem with a name value of blank or null should be removed
     */
    @Test
    fun `Correct number of elements are removed from the list`() {

        val viewModel = MainActivityViewModel(Mockito.mock(GetAllListItemsUseCase::class.java))

        assertEquals("3", viewModel.prepareDisplayData(startingList).count().toString())

    }

    @Test
    fun `elements of the remaining list are sorted correctly after nulls removed`() {

        val viewModel = MainActivityViewModel(Mockito.mock(GetAllListItemsUseCase::class.java))

        assertTrue(viewModel.prepareDisplayData(startingList).first().id == "276")
        assertTrue(viewModel.prepareDisplayData(startingList).last().id == "680")
    }
}